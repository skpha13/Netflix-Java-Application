package model;

public class Utilizator {
    private int utilizator_id;
    private int subscriptie_id;
    private String porecla;
    private String mail;
    private String parola;

    public Utilizator(int utilizator_id, int subscriptie_id, String porecla, String mail, String parola) {
        this.utilizator_id = utilizator_id;
        this.subscriptie_id = subscriptie_id;
        this.porecla = porecla;
        this.mail = mail;
        this.parola = parola;
    }

    public int getUtilizator_id() {
        return utilizator_id;
    }

    public void setUtilizator_id(int utilizator_id) {
        this.utilizator_id = utilizator_id;
    }

    public int getSubscriptie_id() {
        return subscriptie_id;
    }

    public void setSubscriptie_id(int subscriptie_id) {
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

    @Override
    public String toString() {
        return "Utilizator{" +
                "utilizator_id=" + utilizator_id +
                ", subscriptie_id=" + subscriptie_id +
                ", porecla='" + porecla + '\'' +
                ", mail='" + mail + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
