package model.video_service;

public class Episod {
    private String episod_id;
    private String serial_id;
    private String denumire;
    private String numar;
    private String durata;

    public Episod(String episod_id, String serial_id, String denumire, String numar, String durata) {
        this.episod_id = episod_id;
        this.serial_id = serial_id;
        this.denumire = denumire;
        this.numar = numar;
        this.durata = durata;
    }

    public String getEpisod_id() {
        return episod_id;
    }

    public void setEpisod_id(String episod_id) {
        this.episod_id = episod_id;
    }

    public String getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(String serial_id) {
        this.serial_id = serial_id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }
}
