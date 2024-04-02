import model.AuditEntity;
import model.Subscriptie;
import model.Utilizator;
import persistence.*;
import service.Audit;
import service.DatabaseConnection;
import view.ConsoleApp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ConsoleApp consoleApp;

    public static void main(String[] args) throws SQLException {
        consoleApp = ConsoleApp.getInstance();
        consoleApp.start();

//        TODO: Implement .read() function for every entity
    }
}