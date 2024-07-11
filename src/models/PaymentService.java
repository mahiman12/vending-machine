package src.models;

import src.PaymentMethod;
import src.PaymentStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaymentService {
    List<Transaction> transactions = new ArrayList<>();
    boolean processing = false;

    public Transaction initiatePayment(Item item, int cash, PaymentMethod paymentMethod) throws InterruptedException {
        int price = item.getPrice();
        Transaction transaction = new Transaction(
                UUID.randomUUID(), item.getId(), price, paymentMethod, cash
        );
        try {
            if (this.processing) {
                throw new Exception("Machine is dispensing an item, please wait!!");
            }
            this.processing = true;
            int change = cashHandling(price, cash);
            transaction.setChangeAmount(change);
            transaction.setPaymentStatus(PaymentStatus.CAPTURED);
            transaction.setReason("Success");
        } catch (Exception e) {
            transaction.setPaymentStatus(PaymentStatus.FAILED);
            transaction.setReason(e.getMessage());
            System.out.println(e.getMessage() + " " + transaction.getItem_id().toString());
        }
        this.transactions.add(transaction);
        Thread.sleep(3000);
        return transaction;
    }

    public int cashHandling(int price, int cash) throws Exception {
        if (cash < price) {
            throw new Exception("Not enough cash");
        }
        return cash - price;
    }

}
