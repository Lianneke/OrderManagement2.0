package fhict.semester2.application;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DiscountExpirationDate implements IPriceCalculator {

    private final int discountDays = 30;
    private final double discountDouble = 0.75;

    @Override
    public double checkIfListIsQualifiedForDiscount(Charge charge, Medicine medicine) {

        long daysBetween = DAYS.between(LocalDate.now(), charge.getExpirationDate());

        if (!(daysBetween > discountDays)) {
            return calculateDiscount(medicine);
        }
        return 0.0;
    }

    @Override
    public double calculateDiscount(Medicine medicine){

        return medicine.getPrice() * discountDouble;
    }
}
