package view;

import model.Utilizator;
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
                case 2 -> {
                    // enter new menu 2
                }
                case 3 -> {
                    // enter new menu 3
                }
                case 4 -> {
                    // enter new menu 4
                }
                case 5 -> {
                    // enter new menu 5
                }
                case 6 -> {
                    // enter new menu 6
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

                }
                case 3 -> {
                    // create new entity 3
                }
                case 4 -> {
                    // create new entity 4
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
        System.out.println("==========================================================");
    }
}