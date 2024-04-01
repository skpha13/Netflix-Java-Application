import model.AuditEntity;
import model.Subscriptie;
import persistence.*;
import service.Audit;
import service.DatabaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static DatabaseConnection db;
    private static Audit auditService;

    public static void main(String[] args) throws SQLException {
        Main.db = DatabaseConnection.getInstance();
//        DatabaseConnection.testConnection();

        /*auditService = Audit.getInstance();
        ArrayList<AuditEntity> audit_list = DatabaseConnection.audit();
        Audit.log_multiple(audit_list);*/

        /*UtilizatorRepository utilizator = new UtilizatorRepository(db);
        System.out.println(Arrays.toString(utilizator.getAll().toArray()));*/

        /*SubscriptieRepository sub = new SubscriptieRepository(db);
        System.out.println(sub.get(55245));
        System.out.println(Arrays.toString(sub.getAll().toArray()));*/

        /*FilmRepository film = new FilmRepository(db);
        System.out.println(Arrays.toString(film.getAll().toArray()));*/

        /*EpisodRepository episod = new EpisodRepository(db);
        System.out.println(Arrays.toString(episod.getAll().toArray()));*/

        /*SerialRepository serial = new SerialRepository(db, episod);
        System.out.println(Arrays.toString(serial.getAll().toArray()));*/

        
    }
}