package persistence;

import model.video_service.Film;
import service.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FilmRepository implements GenericRepository<Film> {
    private final DatabaseConnection db;

    public FilmRepository(DatabaseConnection db) {
        this.db = db;
    }


    @Override
    public void add(Film entity) {
        String sql = """
                     insert into film(film_id, denumire, nota, data_aparitie)
                     values (?, ?, ?, ?)
                     """;

        try {
            PreparedStatement stmt = null;
            stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getFilm_id());
            stmt.setString(2, entity.getDenumire());
            stmt.setFloat(3, entity.getNota());
            stmt.setDate(4, entity.getData_aparitie());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Film get(int id) {
        String sql = """
                     select film_id, denumire, nota, data_aparitie
                     from film
                     where film_id = ?
                     """;

        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Film(
                        rs.getInt("film_id"),
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
    public ArrayList<Film> getAll() {
        String sql = """
                     select film_id, denumire, nota, data_aparitie
                     from film
                     """;

        ArrayList<Film> filme = new ArrayList<>();
        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Film film = new Film(
                        rs.getInt("film_id"),
                        rs.getString("denumire"),
                        rs.getFloat("nota"),
                        rs.getDate("data_aparitie")
                );
                filme.add(film);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(filme);
        return filme;
    }

    @Override
    public void update(Film entity) {
        String sql = """
                     update film
                     set denumire = ?, nota = ?, data_aparitie = ?
                     where film_id = ?
                     """;

        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setString(1, entity.getDenumire());
            stmt.setFloat(2, entity.getNota());
            stmt.setDate(3, entity.getData_aparitie());
            stmt.setInt(4, entity.getFilm_id());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Film entity) {
        String sql = """
                     delete from film
                     where film_id = ?
                     """;

        try {
            PreparedStatement stmt = db.connection.prepareStatement(sql);
            stmt.setInt(1, entity.getFilm_id());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
