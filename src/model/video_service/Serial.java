package model.video_service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Serial extends Video {
    private int serial_id;

    private ArrayList<Episod> episoade;

    public Serial() {
        super();
    }

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

    @Override
    public void read() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter serial ID: ");
        setSerial_id(sc.nextInt());
        sc.nextLine();

        System.out.println("Enter serial title: ");
        setDenumire(sc.nextLine());

        System.out.println("Enter rating: ");
        setNota(sc.nextFloat());
        sc.nextLine();

        System.out.println("Enter release date (YYYY-MM-DD): ");
        var date = sc.nextLine().split("-");
        setData_aparitie(new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        String option;

        System.out.println("Update serial title? (y/n): ");
        option = sc.nextLine();
        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter serial title: ");
            setDenumire(sc.nextLine());
        }

        System.out.println("Update rating? (y/n): ");
        option = sc.nextLine();
        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter rating: ");
            setNota(sc.nextFloat());
            sc.nextLine();
        }
    }
}
