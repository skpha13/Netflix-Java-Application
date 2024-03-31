package model.video_service;

public abstract class Video {
    private String denumire;
    private float nota;
    private String data_aparitie;

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

    public String getData_aparitie() {
        return data_aparitie;
    }

    public void setData_aparitie(String data_aparitie) {
        this.data_aparitie = data_aparitie;
    }
}
