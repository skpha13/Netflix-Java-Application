package view;

import model.Utilizator;
import persistence.*;
import service.DatabaseConnection;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleApp {
    private static ConsoleApp instance;
    private static DatabaseConnection db;
    private static UtilizatorRepository utilizatorRepository;
    private static SubscriptieRepository subscriptieRepository;
    private static FilmRepository filmRepository;
    private static SerialRepository serialRepository;
    private static SubscriptieFilmRepository subscriptieFilmRepository;
    private static SubscriptieSerialRepository subscriptieSerialRepository;
    private static EpisodRepository episodRepository;

    static {
        utilizatorRepository = new UtilizatorRepository(db);
        subscriptieRepository = new SubscriptieRepository(db);
        filmRepository = new FilmRepository(db);
        episodRepository = new EpisodRepository(db);
        serialRepository = new SerialRepository(db, episodRepository);
        subscriptieRepository = new SubscriptieRepository(db);
        subscriptieFilmRepository = new SubscriptieFilmRepository(db);
        subscriptieSerialRepository = new SubscriptieSerialRepository(db);
    }
    private ConsoleApp() {}
    public static ConsoleApp getInstance() {
        if (instance == null)
            instance = new ConsoleApp();

        return instance;
    }

    public static void start() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (true) {
            printMenu();
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    // enter new menu
                }
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

    public static void createMenu() {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (true) {
            printMenu();
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    Utilizator u = new Utilizator();
                    u.read();

                    System.out.println(Arrays.toString(serialRepository.getAll().toArray()));
                    System.out.println("Enter subscription ID: ");
                    u.setSubscriptie_id(sc.nextInt());
                    sc.nextLine();

                    System.out.println(u);
//                    utilizatorRepository.add(u);
                }
                case 2 -> {
                    // create new entity 2
                }
                case 3 -> {
                    // create new entity 3
                }
                case 4 -> {
                    // create new entity 4
                }
                case 5 -> {
                    // create new entity 5
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

    public static void printMenu() {
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

    public static void printCreateMenu() {
        System.out.println("====================== CREATE MENU ======================");
        System.out.println("1 - User");
        System.out.println("2 - Subscriptie");
        System.out.println("3 - Movie");
        System.out.println("4 - Series");
        System.out.println("5 - Episode");
        System.out.println("0 - Go back");
        System.out.println("==========================================================");
    }
}
