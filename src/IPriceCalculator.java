public interface IPriceCalculator {

    boolean checkIfListIsQualifiedForDiscount(Order order);
    void calculateDiscount(Medicine medicine);



}
