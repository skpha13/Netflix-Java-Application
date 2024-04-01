package model.associative_entities;

public class SubscriptieSerial {
    private int subscriptie_serial_id;
    private int serial_id;
    private int subscriptie_id;

    public SubscriptieSerial(int subscriptie_serial_id, int serial_id, int subscriptie_id) {
        this.subscriptie_serial_id = subscriptie_serial_id;
        this.serial_id = serial_id;
        this.subscriptie_id = subscriptie_id;
    }

    public int getSubscriptie_serial_id() {
        return subscriptie_serial_id;
    }

    public void setSubscriptie_serial_id(int subscriptie_serial_id) {
        this.subscriptie_serial_id = subscriptie_serial_id;
    }

    public int getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(int serial_id) {
        this.serial_id = serial_id;
    }

    public int getSubscriptie_id() {
        return subscriptie_id;
    }

    public void setSubscriptie_id(int subscriptie_id) {
        this.subscriptie_id = subscriptie_id;
    }
}
