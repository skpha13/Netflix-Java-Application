package model.video_service;

import java.sql.Date;

public class Film extends Video {
    private int film_id;

    public Film(int film_id, String denumire, float nota, Date data_aparitie) {
        super(denumire, nota, data_aparitie);
        this.film_id = film_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    @Override
    public String toString() {
        return "Film { " +
                "\n\tfilm_id = " + film_id +
                super.toString() +
                "\n}";
    }
}
