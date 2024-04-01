package model.video_service;

import java.sql.Date;
import java.util.ArrayList;

public class Serial extends Video {
    private String serial_id;

    private ArrayList<Episod> episoade = new ArrayList<>();

    public Serial(String serial_id, ArrayList<Episod> episoade, String denumire, float nota, Date data_aparitie) {
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

    public String getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(String serial_id) {
        this.serial_id = serial_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Serial {\n");
        sb.append("\tserial_id = ").append(serial_id).append(",\n");
        sb.append("\tepisoade = [\n");
        for (Episod episod : episoade) {
            sb.append("\t\t").append(episod).append(",\n");
        }
        sb.append("\t],\n");
        sb.append(super.toString()).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
