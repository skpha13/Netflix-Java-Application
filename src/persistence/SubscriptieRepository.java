package persistence;

import model.Subscriptie;
import service.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubscriptieRepository implements GenericRepository<Subscriptie>{
    private final DatabaseConnection db;

    public SubscriptieRepository(DatabaseConnection db) {
        this.db = db;
    }

    @Override
    public void add(Subscriptie entity) {
        String sql = """
                     insert into subscriptie(subscriptie_id, tip, cost)
                     values(?, ?, ?)
                     """;

        PreparedStatement stmt = null;

        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getSubscriptie_id());
            stmt.setString(2, entity.getTip());
            stmt.setInt(3, entity.getCost());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Subscriptie get(int id) {
        String sql = """
                     select subscriptie_id, tip, cost
                     from subscriptie
                     where subscriptie_id = ?
                     """;

        PreparedStatement stmt = null;
        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Subscriptie s = new Subscriptie(
                        rs.getInt("subscriptie_id"),
                        rs.getString("tip"),
                        rs.getInt("cost")
                );

                return s;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public ArrayList<Subscriptie> getAll() {
        String sql = """
                 select subscriptie_id, tip, cost
                 from subscriptie
                 """;

        ArrayList<Subscriptie> subscriptii = new ArrayList<>();
        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Subscriptie s = new Subscriptie(
                        rs.getInt("subscriptie_id"),
                        rs.getString("tip"),
                        rs.getInt("cost")
                );
                subscriptii.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subscriptii;
    }

    @Override
    public void update(Subscriptie entity) {
        String sql = """
                 update subscriptie
                 set tip = ?, cost = ?
                 where subscriptie_id = ?
                 """;

        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setString(1, entity.getTip());
            stmt.setInt(2, entity.getCost());
            stmt.setInt(3, entity.getSubscriptie_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Subscriptie entity) {
        String sql = """
                 delete from subscriptie
                 where subscriptie_id = ?
                 """;

        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getSubscriptie_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
