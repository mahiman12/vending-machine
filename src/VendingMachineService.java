package src;

import src.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VendingMachineService {
    public List<Item> items = new ArrayList<>();

    public boolean process = false;

    public void addItems(List<Item> items) {
        this.items.addAll(items);
    }

    public List<Item> getAllItems() {
        return this.items;
    }

    public Item getItem(UUID id) throws Exception{
        for(Item item: this.items) {
            if (item.getId() == id && item.getQuantity() != 0) {
                return item;
            }
        }
        throw new Exception("Item not found");
    }
}

