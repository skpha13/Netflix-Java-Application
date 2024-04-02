package model.associative_entities;

public class SubscriptieFilm {
    private int film_id;
    private int subscriptie_id;

    public SubscriptieFilm(int film_id, int subscriptie_id) {
        this.film_id = film_id;
        this.subscriptie_id = subscriptie_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public int getSubscriptie_id() {
        return subscriptie_id;
    }
}
