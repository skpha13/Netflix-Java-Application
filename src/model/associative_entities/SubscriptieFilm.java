package model.associative_entities;

public class SubscriptieFilm {
    private String subscriptie_film_id;
    private String film_id;
    private String subscriptie_id;

    public SubscriptieFilm(String subscriptie_film_id, String film_id, String subscriptie_id) {
        this.subscriptie_film_id = subscriptie_film_id;
        this.film_id = film_id;
        this.subscriptie_id = subscriptie_id;
    }

    public String getSubscriptie_film_id() {
        return subscriptie_film_id;
    }

    public void setSubscriptie_film_id(String subscriptie_film_id) {
        this.subscriptie_film_id = subscriptie_film_id;
    }

    public String getFilm_id() {
        return film_id;
    }

    public void setFilm_id(String film_id) {
        this.film_id = film_id;
    }

    public String getSubscriptie_id() {
        return subscriptie_id;
    }

    public void setSubscriptie_id(String subscriptie_id) {
        this.subscriptie_id = subscriptie_id;
    }
}
