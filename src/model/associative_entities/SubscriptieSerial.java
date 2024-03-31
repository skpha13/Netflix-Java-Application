package model.associative_entities;

public class SubscriptieSerial {
    private String subscriptie_serial_id;
    private String serial_id;
    private String subscriptie_id;

    public SubscriptieSerial(String subscriptie_serial_id, String serial_id, String subscriptie_id) {
        this.subscriptie_serial_id = subscriptie_serial_id;
        this.serial_id = serial_id;
        this.subscriptie_id = subscriptie_id;
    }

    public String getSubscriptie_serial_id() {
        return subscriptie_serial_id;
    }

    public void setSubscriptie_serial_id(String subscriptie_serial_id) {
        this.subscriptie_serial_id = subscriptie_serial_id;
    }

    public String getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(String serial_id) {
        this.serial_id = serial_id;
    }

    public String getSubscriptie_id() {
        return subscriptie_id;
    }

    public void setSubscriptie_id(String subscriptie_id) {
        this.subscriptie_id = subscriptie_id;
    }
}
