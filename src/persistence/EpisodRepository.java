package persistence;

import model.video_service.Episod;
import service.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EpisodRepository implements GenericRepository<Episod> {
    private final DatabaseConnection db;

    public EpisodRepository(DatabaseConnection db) {
        this.db = db;
    }

    @Override
    public void add(Episod entity) {
        String sql = """
                     INSERT INTO episod(episod_id, serial_id, denumire, numar, durata)
                     VALUES (?, ?, ?, ?, ?)
                     """;

        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getEpisod_id());
            stmt.setInt(2, entity.getSerial_id());
            stmt.setString(3, entity.getDenumire());
            stmt.setInt(4, entity.getNumar());
            stmt.setInt(5, entity.getDurata());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Episod get(int id) {
        String sql = """
                     SELECT episod_id, serial_id, denumire, numar, durata
                     FROM episod
                     WHERE episod_id = ?
                     """;

        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Episod(
                        rs.getInt("episod_id"),
                        rs.getInt("serial_id"),
                        rs.getString("denumire"),
                        rs.getInt("numar"),
                        rs.getInt("durata")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ArrayList<Episod> getAll() {
        String sql = """
                     SELECT episod_id, serial_id, denumire, numar, durata
                     FROM episod
                     """;

        ArrayList<Episod> episoade = new ArrayList<>();
        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Episod episod = new Episod(
                        rs.getInt("episod_id"),
                        rs.getInt("serial_id"),
                        rs.getString("denumire"),
                        rs.getInt("numar"),
                        rs.getInt("durata")
                );
                episoade.add(episod);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return episoade;
    }

    @Override
    public void update(Episod entity) {
        String sql = """
                     UPDATE episod
                     SET serial_id = ?, denumire = ?, numar = ?, durata = ?
                     WHERE episod_id = ?
                     """;

        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getSerial_id());
            stmt.setString(2, entity.getDenumire());
            stmt.setInt(3, entity.getNumar());
            stmt.setInt(4, entity.getDurata());
            stmt.setInt(5, entity.getEpisod_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Episod entity) {
        String sql = """
                     DELETE FROM episod
                     WHERE episod_id = ?
                     """;

        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getEpisod_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Episod> getEpisoadeFromSerial(int serial_id) {
        String sql = """
                     SELECT *
                     FROM episod
                     join UTILIZATOR.SERIAL S on episod.SERIAL_ID = S.SERIAL_ID
                     where S.SERIAL_ID = ?
                     """;

        ArrayList<Episod> episoade = new ArrayList<>();
        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, serial_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Episod episod = new Episod(
                        rs.getInt("episod_id"),
                        rs.getInt("serial_id"),
                        rs.getString("denumire"),
                        rs.getInt("numar"),
                        rs.getInt("durata")
                );
                episoade.add(episod);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return episoade;
    }
}
