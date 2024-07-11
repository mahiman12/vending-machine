package src.models;

import java.util.UUID;

public class Item {
    UUID uuid;
    String name;
    int vendor_machine_id;
    int price;
    int quantity;

    public Item(UUID uuid, String name, int vendor_machine_id, int price, int quantity) {
        this.uuid = uuid;
        this.name = name;
        this.vendor_machine_id = vendor_machine_id;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getId() {
        return uuid;
    }

    public void setId(UUID id) {
        this.uuid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVendor_machine_id() {
        return vendor_machine_id;
    }

    public void setVendor_machine_id(int vendor_machine_id) {
        this.vendor_machine_id = vendor_machine_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
