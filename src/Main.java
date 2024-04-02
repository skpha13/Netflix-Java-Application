import view.ConsoleApp;

public class Main {
    private static ConsoleApp consoleApp;

    public static void main(String[] args) {
        consoleApp = ConsoleApp.getInstance();
        consoleApp.start();
    }
}