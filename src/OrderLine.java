public class OrderLine {

    private Medicine medicine;
    private Charge charge;
    private int quantity;

    public OrderLine(Medicine medicine, Charge charge, int quantity) {
        this.medicine = medicine;
        this.charge = charge;
        this.quantity = quantity;
    }
}
