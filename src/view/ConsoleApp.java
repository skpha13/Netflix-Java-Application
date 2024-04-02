package view;

import exceptions.OperationNotSupportedException;
import model.ReadUpdateInterface;
import model.Utilizator;
import model.video_service.Episod;
import model.video_service.Film;
import model.video_service.Serial;
import persistence.*;
import service.DatabaseConnection;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleApp {
    private static ConsoleApp instance;
    private DatabaseConnection db;
    private UtilizatorRepository utilizatorRepository;
    private SubscriptieRepository subscriptieRepository;
    private FilmRepository filmRepository;
    private SerialRepository serialRepository;
    private SubscriptieFilmRepository subscriptieFilmRepository;
    private SubscriptieSerialRepository subscriptieSerialRepository;
    private EpisodRepository episodRepository;

    private ConsoleApp() {
        db = DatabaseConnection.getInstance();
        utilizatorRepository = new UtilizatorRepository(db);
        subscriptieRepository = new SubscriptieRepository(db);
        filmRepository = new FilmRepository(db);
        episodRepository = new EpisodRepository(db);
        serialRepository = new SerialRepository(db, episodRepository);
        subscriptieRepository = new SubscriptieRepository(db);
        subscriptieFilmRepository = new SubscriptieFilmRepository(db);
        subscriptieSerialRepository = new SubscriptieSerialRepository(db);
    }
    public static ConsoleApp getInstance() {
        if (instance == null)
            instance = new ConsoleApp();

        return instance;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (true) {
            printMenu();
            System.out.println("Enter option# ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> createMenu();
                case 2 -> readMenu();
                case 3 -> updateMenu();
                case 4 -> deleteMenu();
                case 5 -> connectMenu();
                case 0 -> {
                    return;
                }
                default -> System.out.println("~ INVALID OPTION");
            }
        }
    }

    public void connectMenu() {

    }

    public void deleteMenu() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (true) {
            printDeleteMenu();
            System.out.println("Enter option# ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> deleteService(utilizatorRepository);
                case 2 -> deleteService(filmRepository);
                case 3 -> deleteService(serialRepository);
                case 4 -> deleteService(episodRepository);
                case 0 -> {
                    return;
                }
                default -> System.out.println("~ INVALID OPTION");
            }
        }
    }

    public <T extends ReadUpdateInterface> void deleteService(GenericRepository<T> repository) {
        try {
            System.out.println(Arrays.toString(repository.getAll().toArray()));
            System.out.println("Enter ID: ");

            Scanner sc = new Scanner(System.in);
            T entity = repository.get(sc.nextInt());
            sc.nextLine();

            repository.delete(entity);

        } catch (OperationNotSupportedException e) {
            System.out.println(e);
        }
    }

    public void updateMenu() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (true) {
            printUpdateMenu();
            System.out.println("Enter option# ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> updateService(utilizatorRepository);
                case 2 -> updateService(filmRepository);
                case 3 -> updateService(serialRepository);
                case 4 -> updateService(episodRepository);
                case 0 -> {
                    return;
                }
                default -> System.out.println("~ INVALID OPTION");
            }
        }
    }

    public <T extends ReadUpdateInterface> void updateService(GenericRepository<T> repository) {
        try {
            System.out.println(Arrays.toString(repository.getAll().toArray()));
            System.out.println("Enter ID: ");

            Scanner sc = new Scanner(System.in);
            T entity = repository.get(sc.nextInt());
            sc.nextLine();

            entity.update();
            repository.update(entity);

        } catch (OperationNotSupportedException e) {
            System.out.println(e);
        }
    }

    public void readMenu() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (true) {
            printReadMenu();
            System.out.println("Enter option# ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> System.out.println(Arrays.toString(utilizatorRepository.getAll().toArray()));
                case 2 -> System.out.println(Arrays.toString(filmRepository.getAll().toArray()));
                case 3 -> System.out.println(Arrays.toString(serialRepository.getAll().toArray()));
                case 4 -> System.out.println(Arrays.toString(episodRepository.getAll().toArray()));
                case 5 -> System.out.println(Arrays.toString(subscriptieRepository.getAll().toArray()));
                case 0 -> {
                    return;
                }
                default -> System.out.println("~ INVALID OPTION");
            }
        }
    }

    public void createMenu() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (true) {
            printCreateMenu();
            System.out.println("Enter option# ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    Utilizator u = new Utilizator();
                    u.read();

                    System.out.println(Arrays.toString(subscriptieRepository.getAll().toArray()));
                    System.out.println("Enter subscription ID: ");
                    u.setSubscriptie_id(sc.nextInt());
                    sc.nextLine();

                    utilizatorRepository.add(u);
                }
                case 2 -> {
                    Film f = new Film();
                    f.read();

                    filmRepository.add(f);
                }
                case 3 -> {
                    Serial s = new Serial();
                    s.read();

                    serialRepository.add(s);
                }
                case 4 -> {
                    Episod e = new Episod();
                    e.read();

                    System.out.println(Arrays.toString(serialRepository.getAll().toArray()));
                    System.out.println("Enter series ID: ");
                    e.setSerial_id(sc.nextInt());
                    sc.nextLine();

                    episodRepository.add(e);
                }
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("~ INVALID OPTION");
                }
            }
        }
    }

    public void printMenu() {
        System.out.println("====================== MENU ======================");
        System.out.println("1 - Create menu");
        System.out.println("2 - Read menu");
        System.out.println("3 - Update menu");
        System.out.println("4 - Delete menu");
        System.out.println("5 - Connect menu");
        System.out.println("6 - Audit menu");
        System.out.println("0 - Exit the program");
        System.out.println("==================================================");
    }

    public void printCreateMenu() {
        System.out.println("====================== CREATE MENU ======================");
        System.out.println("1 - User");
        System.out.println("2 - Movie");
        System.out.println("3 - Series");
        System.out.println("4 - Episode");
        System.out.println("0 - Go back");
        System.out.println("=========================================================");
    }

    public void printReadMenu() {
        System.out.println("====================== READ MENU ======================");
        System.out.println("1 - Users");
        System.out.println("2 - Movies");
        System.out.println("3 - Series");
        System.out.println("4 - Episodes");
        System.out.println("5 - Subscriptions");
        System.out.println("0 - Go back");
        System.out.println("=======================================================");

    }

    public void printUpdateMenu() {
        System.out.println("====================== UPDATE MENU ======================");
        System.out.println("1 - User");
        System.out.println("2 - Movie");
        System.out.println("3 - Series");
        System.out.println("4 - Episode");
        System.out.println("0 - Go back");
        System.out.println("=========================================================");

    }

    public void printDeleteMenu() {
        System.out.println("====================== DELETE MENU ======================");
        System.out.println("1 - User");
        System.out.println("2 - Movie");
        System.out.println("3 - Series");
        System.out.println("4 - Episode");
        System.out.println("0 - Go back");
        System.out.println("=========================================================");

    }

    public void printConnectMenu() {
        System.out.println("====================== CONNECT MENU ======================");
        System.out.println("1 - Connect User to Subscription");
        System.out.println("2 - Connect Movie to Subscription");
        System.out.println("3 - Connect Series to Subscription");
        System.out.println("4 - Connect Episode to Series");
        System.out.println("0 - Go back");
        System.out.println("==========================================================");

    }
}
