package model;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Utilizator implements ReadUpdateInterface {
    private int utilizator_id;
    private int subscriptie_id;
    private Subscriptie subscriptie;
    private String porecla;
    private String mail;
    private String parola;

    public Utilizator() {}

    public Utilizator(int utilizator_id, int subscriptie_id, Subscriptie subscriptie, String porecla, String mail, String parola) {
        this.utilizator_id = utilizator_id;
        this.subscriptie_id = subscriptie_id;
        this.subscriptie = subscriptie;
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

    public Subscriptie getSubscriptie() {
        return subscriptie;
    }

    public void setSubscriptie(Subscriptie subscriptie) {
        this.subscriptie = subscriptie;
    }

    @Override
    public String toString() {
        String sub = "Subscriptie { None }";
        if (subscriptie != null) {
            sub = String.join("\n\t", subscriptie.toString().split("\n"));
        }

        return "Utilizator {\n" +
                "\tutilizator_id = " + utilizator_id +
                "\n\t" + sub +
                "\n\tporecla = " + porecla +
                "\n\tmail = " + mail +
                "\n\tparola = " + parola +
                "\n}\n";
    }


    @Override
    public void read() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter user id: ");
        setUtilizator_id(sc.nextInt());
        sc.nextLine();

        System.out.println("Enter nickname: ");
        setPorecla(sc.nextLine());

        System.out.println("Enter mail: ");
        setMail(sc.nextLine());

        System.out.println("Enter password: ");
        setParola(sc.nextLine());
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        String option;

        System.out.println("Update nickname? (y/n): ");
        option = sc.nextLine();

        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter nickname: ");
            setPorecla(sc.nextLine());
        }

        System.out.println("Update mail? (y/n): ");
        option = sc.nextLine();

        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter mail: ");
            setMail(sc.nextLine());
        }

        System.out.println("Update password? (y/n): ");
        option = sc.nextLine();

        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter password: ");
            setParola(sc.nextLine());
        }
    }
}
