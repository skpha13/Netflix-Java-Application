import service.DatabaseConnection;

import java.sql.SQLException;

public class Main {
    private static DatabaseConnection db;

    Main() {
        db = DatabaseConnection.getInstance();
    }

    public static void main(String[] args) throws SQLException {
        Main.db = DatabaseConnection.getInstance();
        DatabaseConnection.testConnection();
    }
}