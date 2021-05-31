package fhict.semester2.application;

public interface IPriceCalculator {


    double checkIfListIsQualifiedForDiscount(Charge charge, Medicine medicine);

    double calculateDiscount(Medicine medicine);


}
