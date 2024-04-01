package persistence;

import exceptions.OperationNotSupportedException;
import model.associative_entities.SubscriptieSerial;
import service.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubscriptieSerialRepository implements GenericRepository<SubscriptieSerial> {
    private final DatabaseConnection db;

    public SubscriptieSerialRepository(DatabaseConnection db) {
        this.db = db;
    }

    @Override
    public void add(SubscriptieSerial entity) {
        String sql = """
                     insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id)
                     values (INCREMENTARE_film.nextval, ?, ?)
                     """;

        PreparedStatement stmt = null;

        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getSerial_id());
            stmt.setInt(2, entity.getSubscriptie_id());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(SubscriptieSerial entity) {
        String sql = """
                     delete from SUBSCRIPTIE_SERIAL
                     where SERIAL_ID = ? or subscriptie_id = ?
                     """;

        PreparedStatement stmt = null;

        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getSerial_id());
            stmt.setInt(2, entity.getSubscriptie_id());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SubscriptieSerial get(int id) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Get operation is not supported");
    }

    @Override
    public ArrayList<SubscriptieSerial> getAll() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Get all operation is not supported");
    }

    @Override
    public void update(SubscriptieSerial entity) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Update operation is not supported");
    }
}
