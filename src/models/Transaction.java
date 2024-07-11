package src.models;

import src.PaymentMethod;
import src.PaymentStatus;

import java.util.UUID;

public class Transaction {
   UUID uuid;
   UUID item_id;
   int price;
   PaymentMethod paymentMethod;
   int creditAmount;
   int changeAmount;
   PaymentStatus paymentStatus;
   String reason;

   public UUID getUuid() {
      return uuid;
   }

   public void setUuid(UUID uuid) {
      this.uuid = uuid;
   }

   public UUID getItem_id() {
      return item_id;
   }

   public void setItem_id(UUID item_id) {
      this.item_id = item_id;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public PaymentMethod getPaymentMethod() {
      return paymentMethod;
   }

   public void setPaymentMethod(PaymentMethod paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   public int getCreditAmount() {
      return creditAmount;
   }

   public void setCreditAmount(int creditAmount) {
      this.creditAmount = creditAmount;
   }

   public int getChangeAmount() {
      return changeAmount;
   }

   public void setChangeAmount(int changeAmount) {
      this.changeAmount = changeAmount;
   }

   public PaymentStatus getPaymentStatus() {
      return paymentStatus;
   }

   public void setPaymentStatus(PaymentStatus paymentStatus) {
      this.paymentStatus = paymentStatus;
   }

   public String getReason() {
      return reason;
   }

   public void setReason(String reason) {
      this.reason = reason;
   }

   public Transaction(UUID uuid, UUID item_id, int price, PaymentMethod paymentMethod, int creditAmount) {
      this.uuid = uuid;
      this.item_id = item_id;
      this.price = price;
      this.paymentMethod = paymentMethod;
      this.creditAmount = creditAmount;
   }
}
