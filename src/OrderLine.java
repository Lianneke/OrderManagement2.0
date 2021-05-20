public class OrderLine {

    private Medicine medicine;
    private Charge charge;
    private int quantity;

    public OrderLine(Medicine medicine, Charge charge, int quantity) {
        this.medicine = medicine;
        this.charge = charge;
        this.quantity = quantity;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public Charge getCharge() {
        return charge;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "medicine=" + medicine +
                ", charge=" + charge +
                ", quantity=" + quantity +
                '}';
    }
}
