package fhict.semester2.application;

import java.time.LocalDate;

public class Charge {

    private final String chargeNumber;
    private final LocalDate expirationDate;
    private int quantity;

    public Charge(String chargeNumber, LocalDate expirationDate, int quantity) {
        this.chargeNumber = chargeNumber;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    public boolean checkAndSetQuantity(int quantity){
        if(this.quantity < quantity){
            return false;
        }
        this.quantity = this.quantity-quantity;
        return true;
    }

    public String getChargeNumber() {
        return chargeNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "chargeNumber='" + chargeNumber + '\'' +
                ", expirationDate=" + expirationDate +
                ", quantity=" + quantity +
                '}';
    }
}
