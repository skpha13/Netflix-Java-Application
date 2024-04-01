package model;

public class Subscriptie {
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
}
