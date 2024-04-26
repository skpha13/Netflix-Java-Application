package view;

import exceptions.OperationNotSupportedException;
import model.ReadUpdateInterface;
import model.Utilizator;
import model.associative_entities.SubscriptieFilm;
import model.associative_entities.SubscriptieSerial;
import model.video_service.Episod;
import model.video_service.Film;
import model.video_service.Serial;
import persistence.*;
import service.Audit;
import service.DatabaseConnection;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleApp {
    private static ConsoleApp instance;
    private final UtilizatorRepository utilizatorRepository;
    private final SubscriptieRepository subscriptieRepository;
    private final FilmRepository filmRepository;
    private final SerialRepository serialRepository;
    private final SubscriptieFilmRepository subscriptieFilmRepository;
    private final SubscriptieSerialRepository subscriptieSerialRepository;
    private final EpisodRepository episodRepository;

    private ConsoleApp() {
        DatabaseConnection db = DatabaseConnection.getInstance();
        Audit.getInstance();
        utilizatorRepository = new UtilizatorRepository(db);
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
        int option;

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
                case 6 -> {
                    try {
                        Audit.log_multiple(DatabaseConnection.audit());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("~ INVALID OPTION");
            }
        }
    }

    public void connectMenu() {
        Scanner sc = new Scanner(System.in);
        int option;

        while (true) {
            printConnectMenu();
            System.out.println("Enter option# ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.println(Arrays.toString(utilizatorRepository.getAll().toArray()));
                    System.out.println("Enter user ID: ");

                    int userId = sc.nextInt();
                    sc.nextLine();

                    System.out.println(Arrays.toString(subscriptieRepository.getAll().toArray()));
                    System.out.println("Enter subscription ID: ");

                    int subscriptionId = sc.nextInt();
                    sc.nextLine();

                    Utilizator u = utilizatorRepository.get(userId);
                    u.setSubscriptie_id(subscriptionId);

                    utilizatorRepository.update(u);
                }
                case 2 -> {
                    System.out.println(Arrays.toString(filmRepository.getAll().toArray()));
                    System.out.println("Enter movie ID: ");

                    int filmId = sc.nextInt();
                    sc.nextLine();

                    System.out.println(Arrays.toString(subscriptieRepository.getAll().toArray()));
                    System.out.println("Enter subscription ID: ");

                    int subscriptionId = sc.nextInt();
                    sc.nextLine();

                    subscriptieFilmRepository.add(new SubscriptieFilm(filmId, subscriptionId));
                }
                case 3 -> {
                    System.out.println(Arrays.toString(serialRepository.getAll().toArray()));
                    System.out.println("Enter series ID: ");

                    int serialId = sc.nextInt();
                    sc.nextLine();

                    System.out.println(Arrays.toString(subscriptieRepository.getAll().toArray()));
                    System.out.println("Enter subscription ID: ");

                    int subscriptionId = sc.nextInt();
                    sc.nextLine();

                    subscriptieSerialRepository.add(new SubscriptieSerial(serialId, subscriptionId));
                }
                case 4 -> {
                    System.out.println(Arrays.toString(episodRepository.getAll().toArray()));
                    System.out.println("Enter episode ID: ");

                    int episodId = sc.nextInt();
                    sc.nextLine();

                    System.out.println(Arrays.toString(serialRepository.getAll().toArray()));
                    System.out.println("Enter series ID: ");

                    int serialId = sc.nextInt();
                    sc.nextLine();

                    Episod e = episodRepository.get(episodId);
                    e.setSerial_id(serialId);

                    episodRepository.update(e);
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("~ INVALID OPTION");
            }
        }
    }

    public void deleteMenu() {
        Scanner sc = new Scanner(System.in);
        int option;

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
        int option;

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
        int option;

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
        int option;

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
                default -> System.out.println("~ INVALID OPTION");
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
        System.out.println("6 - Force Audit");
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
