package persistence;

import model.Subscriptie;
import model.Utilizator;
import oracle.jdbc.OraclePreparedStatement;
import service.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UtilizatorRepository implements GenericRepository<Utilizator> {
    private final DatabaseConnection db;

    public UtilizatorRepository(DatabaseConnection db) {
        this.db = db;
    }

    @Override
    public void add(Utilizator entity) {
        String sql = "INSERT INTO UTILIZATOR(" +
                        "utilizator_id, " +
                        "subscriptie_id, " +
                        "porecla, " +
                        "mail, " +
                        "parola) " +
                    "values (?, ?, ?, ?, ?)";

        OraclePreparedStatement optsmt = null;
        try {
            optsmt = (OraclePreparedStatement) db.connection.prepareStatement(sql);
            optsmt.setInt(1, entity.getUtilizator_id());
            optsmt.setInt(2, entity.getSubscriptie_id());
            optsmt.setString(3, entity.getPorecla());
            optsmt.setString(4, entity.getMail());
            optsmt.setString(5, entity.getParola());
            optsmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Utilizator get(int id) {
        String sql = """
                select *
                from UTILIZATOR
                join UTILIZATOR.SUBSCRIPTIE S2 on S2.SUBSCRIPTIE_ID = UTILIZATOR.SUBSCRIPTIE_ID
                where UTILIZATOR.UTILIZATOR_ID = ?
                """;

        PreparedStatement stmt = null;
        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Utilizator u = new Utilizator(
                        rs.getInt("utilizator_id"),
                        rs.getInt("subscriptie_id"),
                        new Subscriptie(rs.getInt("subscriptie_id"), rs.getString("tip"), rs.getInt("cost")),
                        rs.getString("porecla"),
                        rs.getString("mail"),
                        rs.getString("parola")
                );

                return u;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public ArrayList<Utilizator> getAll() {
        ArrayList<Utilizator> list = new ArrayList<>();

        String sql =  """
                SELECT *
                from UTILIZATOR
                join UTILIZATOR.SUBSCRIPTIE S2 on S2.SUBSCRIPTIE_ID = UTILIZATOR.SUBSCRIPTIE_ID
                """;

        try {
            Statement stmt = db.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Utilizator u = new Utilizator(
                        rs.getInt("utilizator_id"),
                        rs.getInt("subscriptie_id"),
                        new Subscriptie(rs.getInt("subscriptie_id"), rs.getString("tip"), rs.getInt("cost")),
                        rs.getString("porecla"),
                        rs.getString("mail"),
                        rs.getString("parola")
                );

                list.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void update(Utilizator entity) {
        String sql = """
                     update utilizator
                     set porecla = ?, mail = ?, parola = ?
                     where utilizator_id = ?
                     """;

        PreparedStatement stmt = null;

        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setString(1, entity.getPorecla());
            stmt.setString(2, entity.getMail());
            stmt.setString(3, entity.getParola());
            stmt.setInt(4, entity.getUtilizator_id());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Utilizator entity) {
        String sql = """
                     delete from utilizator where utilizator_id = ?
                     """;

        PreparedStatement stmt = null;
        try {
            stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getUtilizator_id());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
