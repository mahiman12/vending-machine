package src.models;

import src.PaymentMethod;
import src.PaymentService;
import src.VendingMachineService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainService {
    public static void main(String[] args) {
        try {
            boolean processing = false;
            VendingMachineService vendingMachineService = new VendingMachineService();
            PaymentService paymentService = new PaymentService();
            Item item1 = new Item(UUID.randomUUID(), "Coke", 1, 30, 6);
            Item item2 = new Item(UUID.randomUUID(), "Pepsi", 1, 40, 6);
            Item item3 = new Item(UUID.randomUUID(), "Maggi", 1, 10, 6);
            Item item4 = new Item(UUID.randomUUID(), "Biscuit", 1, 20, 6);
            Item item5 = new Item(UUID.randomUUID(), "Chips", 1, 20, 6);
            List<Item> items = new ArrayList<>();
            items.add(item1);
            items.add(item2);
            items.add(item3);
            items.add(item4);
            items.add(item5);
            vendingMachineService.addItems(items);
            // get all items
            for (Item item : vendingMachineService.items) {
                System.out.println(item);
            }
            // buy 1st item
            UUID id = vendingMachineService.items.get(0).uuid;
            Item item = vendingMachineService.getItem(id);
            UUID id1 = vendingMachineService.items.get(1).uuid;
            Item item11 = vendingMachineService.getItem(id1);

            System.out.println(item.getId().toString() + " " + item11.getId().toString());
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                    10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
            threadPoolExecutor.execute(() -> {
                try {
                    paymentService.initiatePayment(item, 70, PaymentMethod.CASH);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            threadPoolExecutor.execute(() -> {
                try {
                    paymentService.initiatePayment(item11, 50, PaymentMethod.CASH);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}