package model;

public class Subscriptie {
    private String subscriptie_id;
    private String tip;
    private int cost;

    public Subscriptie(String subscriptie_id, String tip, int cost) {
        this.subscriptie_id = subscriptie_id;
        this.tip = tip;
        this.cost = cost;
    }

    public String getSubscriptie_id() {
        return subscriptie_id;
    }

    public void setSubscriptie_id(String subscriptie_id) {
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
}
