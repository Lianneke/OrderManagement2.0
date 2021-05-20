public interface IPriceCalculator {


    boolean checkIfListIsQualifiedForDiscount(Charge charge, Medicine medicine);

    double calculateDiscount(Medicine medicine);



}
