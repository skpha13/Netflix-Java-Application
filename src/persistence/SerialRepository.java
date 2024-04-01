package persistence;

import model.video_service.Serial;
import service.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SerialRepository implements GenericRepository<Serial> {
    private final DatabaseConnection db;
    private final EpisodRepository episodRepository;

    public SerialRepository(DatabaseConnection db, EpisodRepository episodRepository) {
        this.db = db;
        this.episodRepository = episodRepository;
    }

    @Override
    public void add(Serial entity) {
        String sql = """
                     insert into serial(serial_id, denumire, nota, data_aparitie)
                     values (?, ?, ?, ?)
                     """;

        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getSerial_id());
            stmt.setString(2, entity.getDenumire());
            stmt.setFloat(3, entity.getNota());
            stmt.setDate(4, entity.getData_aparitie());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Serial get(int id) {
        String sql = """
                     SELECT serial_id, denumire, nota, data_aparitie
                     FROM serial
                     WHERE serial_id = ?
                     """;

        PreparedStatement stmt = null;
        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Serial(
                        rs.getInt("serial_id"),
                        episodRepository.getEpisoadeFromSerial(id),
                        rs.getString("denumire"),
                        rs.getFloat("nota"),
                        rs.getDate("data_aparitie")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public ArrayList<Serial> getAll() {
        String sql = """
                     SELECT serial_id, denumire, nota, data_aparitie
                     FROM serial
                     """;

        ArrayList<Serial> serials = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            stmt = db.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Serial serial = new Serial(
                        rs.getInt("serial_id"),
                        episodRepository.getEpisoadeFromSerial(rs.getInt("serial_id")),
                        rs.getString("denumire"),
                        rs.getFloat("nota"),
                        rs.getDate("data_aparitie")
                );
                serials.add(serial);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return serials;
    }

    @Override
    public void update(Serial entity) {
        String sql = """
                     UPDATE serial
                     SET denumire = ?, nota = ?, data_aparitie = ?
                     WHERE serial_id = ?
                     """;

        PreparedStatement stmt = null;
        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setString(1, entity.getDenumire());
            stmt.setFloat(2, entity.getNota());
            stmt.setDate(3, entity.getData_aparitie());
            stmt.setInt(4, entity.getSerial_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Serial entity) {
        String sql = """
                     DELETE FROM serial
                     WHERE serial_id = ?
                     """;

        PreparedStatement stmt = null;
        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getSerial_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
