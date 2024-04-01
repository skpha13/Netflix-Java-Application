package model.video_service;

public class Episod {
    private int episod_id;
    private int serial_id;
    private String denumire;
    private int numar;
    private int durata;

    public Episod(int episod_id, int serial_id, String denumire, int numar, int durata) {
        this.episod_id = episod_id;
        this.serial_id = serial_id;
        this.denumire = denumire;
        this.numar = numar;
        this.durata = durata;
    }

    public int getEpisod_id() {
        return episod_id;
    }

    public void setEpisod_id(int episod_id) {
        this.episod_id = episod_id;
    }

    public int getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(int serial_id) {
        this.serial_id = serial_id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "Episod {" +
                "\n\tepisod_id = " + episod_id +
                "\n\tdenumire = " + denumire +
                "\n\tnumar = " + numar +
                "\n\tdurata = " + durata +
                "\n}\n";
    }
}
