package service;

import oracle.jdbc.OraclePreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class DatabaseConnection {
    //singleton class
    private static final String DB_DRIVER = System.getenv("DB_DRIVER");
    private static final String DB_URL = System.getenv("DB_URL");
    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PASS = System.getenv("DB_PASS");

    private static Connection connection;
    private static DatabaseConnection instance;

    private DatabaseConnection(){
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public static int testConnection() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM FILM");

        while (rs.next()) {
            // Assuming FILM table has columns like "title", "director", etc.
            String title = rs.getString("denumire");
            String nota = rs.getString("nota");
            // ... process other columns as needed
            System.out.println("Film: " + title + " (Nota: " + nota + ")");
        }

        return 0;
    }
}