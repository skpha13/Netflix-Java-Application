package persistence;

import exceptions.OperationNotSupportedException;
import model.associative_entities.SubscriptieFilm;
import service.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubscriptieFilmRepository implements GenericRepository<SubscriptieFilm> {
    private final DatabaseConnection db;

    public SubscriptieFilmRepository(DatabaseConnection db) {
        this.db = db;
    }

    @Override
    public void add(SubscriptieFilm entity) {
        String sql = """
                     insert into subscriptie_film(subscriptie_film_id, film_id, subscriptie_id)
                     values (INCREMENTARE_film.nextval, ?, ?)
                     """;

        PreparedStatement stmt = null;

        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getFilm_id());
            stmt.setInt(2, entity.getSubscriptie_id());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(SubscriptieFilm entity) {
        String sql = """
                     delete from subscriptie_film
                     where film_id = ? or subscriptie_id = ?
                     """;

        PreparedStatement stmt = null;

        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getFilm_id());
            stmt.setInt(2, entity.getSubscriptie_id());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SubscriptieFilm get(int id) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Get operation is not supported");
    }

    @Override
    public ArrayList<SubscriptieFilm> getAll() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Get all operation is not supported");
    }

    @Override
    public void update(SubscriptieFilm entity) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Update operation is not supported");
    }
}
