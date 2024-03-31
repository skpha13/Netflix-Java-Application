package model.video_service;

import java.util.ArrayList;

public class Serial extends Video {
    private String serial_id;
    private ArrayList<Episod> episoade = new ArrayList<>();

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
}
