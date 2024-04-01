package model.video_service;

import java.sql.Date;
import java.util.ArrayList;

public class Serial extends Video {
    private int serial_id;

    private ArrayList<Episod> episoade;

    public Serial(int serial_id, ArrayList<Episod> episoade, String denumire, float nota, Date data_aparitie) {
        super(denumire, nota, data_aparitie);
        this.serial_id = serial_id;
        this.episoade = episoade;
    }

    public ArrayList<Episod> getEpisoade() {
        return episoade;
    }

    public void setEpisoade(ArrayList<Episod> episoade) {
        this.episoade = episoade;
    }

    public int getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(int serial_id) {
        this.serial_id = serial_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Serial {\n");
        sb.append("\tserial_id = ").append(serial_id);
        sb.append(super.toString()).append("\n\n");
        sb.append("\tepisoade = [\n");
        for (Episod episod : episoade) {
            sb.append("\t\t").append(String.join("\n\t\t", episod.toString().split("\n"))).append(",\n");
        }
        sb.append("\t]");
        sb.append("\n}\n");
        return sb.toString();
    }
}
