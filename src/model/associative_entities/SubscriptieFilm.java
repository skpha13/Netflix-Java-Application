package model.associative_entities;

public class SubscriptieFilm {
    private int subscriptie_film_id;
    private int film_id;
    private int subscriptie_id;

    public SubscriptieFilm(int subscriptie_film_id, int film_id, int subscriptie_id) {
        this.subscriptie_film_id = subscriptie_film_id;
        this.film_id = film_id;
        this.subscriptie_id = subscriptie_id;
    }

    public int getSubscriptie_film_id() {
        return subscriptie_film_id;
    }

    public void setSubscriptie_film_id(int subscriptie_film_id) {
        this.subscriptie_film_id = subscriptie_film_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getSubscriptie_id() {
        return subscriptie_id;
    }

    public void setSubscriptie_id(int subscriptie_id) {
        this.subscriptie_id = subscriptie_id;
    }
}
