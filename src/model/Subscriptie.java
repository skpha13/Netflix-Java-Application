package model;

import java.util.Scanner;

public class Subscriptie implements ReadUpdateInterface {
    private int subscriptie_id;
    private String tip;
    private int cost;

    public Subscriptie(int subscriptie_id, String tip, int cost) {
        this.subscriptie_id = subscriptie_id;
        this.tip = tip;
        this.cost = cost;
    }

    public int getSubscriptie_id() {
        return subscriptie_id;
    }

    public void setSubscriptie_id(int subscriptie_id) {
        this.subscriptie_id = subscriptie_id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Subscriptie {" +
                "\n\tsubscriptie_id = " + subscriptie_id +
                "\n\ttip = " + tip +
                "\n\tcost = " + cost +
                "\n}\n";
    }

    @Override
    public void read() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter subscriptie id: ");
        setSubscriptie_id(sc.nextInt());
        sc.nextLine();

        System.out.println("Enter tip: ");
        setTip(sc.nextLine());

        System.out.println("Enter cost: ");
        setCost(sc.nextInt());
        sc.nextLine();
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        String option;

        System.out.println("Update tip? (y/n): ");
        option = sc.nextLine();
        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter tip: ");
            setTip(sc.nextLine());
        }

        System.out.println("Update cost? (y/n): ");
        option = sc.nextLine();
        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter cost: ");
            setCost(sc.nextInt());
            sc.nextLine();
        }
    }
}
