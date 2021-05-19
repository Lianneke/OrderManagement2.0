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

    public String getChargeNumber() {
        return chargeNumber;
    }
}
