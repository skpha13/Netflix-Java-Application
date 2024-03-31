import model.AuditEntity;
import service.Audit;
import service.DatabaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    private static DatabaseConnection db;
    private static Audit auditService;

    public static void main(String[] args) throws SQLException {
        Main.db = DatabaseConnection.getInstance();
        DatabaseConnection.testConnection();

        auditService = Audit.getInstance();
        ArrayList<AuditEntity> audit_list = DatabaseConnection.audit();
        Audit.log_multiple(audit_list);
    }
}