package model;

public class Utilizator {
    private String utilizator_id;
    private String subscriptie_id;
    private String porecla;
    private String mail;
    private String parola;

    public Utilizator(String utilizator_id, String subscriptie_id, String porecla, String mail, String parola) {
        this.utilizator_id = utilizator_id;
        this.subscriptie_id = subscriptie_id;
        this.porecla = porecla;
        this.mail = mail;
        this.parola = parola;
    }

    public String getUtilizator_id() {
        return utilizator_id;
    }

    public void setUtilizator_id(String utilizator_id) {
        this.utilizator_id = utilizator_id;
    }

    public String getSubscriptie_id() {
        return subscriptie_id;
    }

    public void setSubscriptie_id(String subscriptie_id) {
        this.subscriptie_id = subscriptie_id;
    }

    public String getPorecla() {
        return porecla;
    }

    public void setPorecla(String porecla) {
        this.porecla = porecla;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}
