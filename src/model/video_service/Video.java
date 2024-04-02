package model.video_service;

import model.ReadUpdateInterface;

import java.sql.Date;

public abstract class Video implements ReadUpdateInterface {
    private String denumire;
    private float nota;
    private Date data_aparitie;

    public Video(String denumire, float nota, Date data_aparitie) {
        this.denumire = denumire;
        this.nota = nota;
        this.data_aparitie = data_aparitie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Date getData_aparitie() {
        return data_aparitie;
    }

    public void setData_aparitie(Date data_aparitie) {
        this.data_aparitie = data_aparitie;
    }

    @Override
    public String toString() {
        return  "\n\tdenumire = " + denumire +
                "\n\tnota = " + nota +
                "\n\tdata_aparitie = " + data_aparitie;
    }
}
