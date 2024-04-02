package model.associative_entities;

public class SubscriptieSerial {
    private int serial_id;
    private int subscriptie_id;

    public SubscriptieSerial(int serial_id, int subscriptie_id) {
        this.serial_id = serial_id;
        this.subscriptie_id = subscriptie_id;
    }

    public int getSerial_id() {
        return serial_id;
    }

    public int getSubscriptie_id() {
        return subscriptie_id;
    }
}
