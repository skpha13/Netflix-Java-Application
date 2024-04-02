package model.video_service;

import java.sql.Date;
import java.util.Scanner;

public class Film extends Video {
    private int film_id;

    public Film() {
        super();
    }

    public Film(int film_id, String denumire, float nota, Date data_aparitie) {
        super(denumire, nota, data_aparitie);
        this.film_id = film_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    @Override
    public String toString() {
        return "Film { " +
                "\n\tfilm_id = " + film_id +
                super.toString() +
                "\n}";
    }

    @Override
    public void read() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter film ID: ");
        setFilm_id(sc.nextInt());
        sc.nextLine();

        System.out.println("Enter film title: ");
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

        System.out.println("Update film title? (y/n): ");
        option = sc.nextLine();
        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter film title: ");
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
