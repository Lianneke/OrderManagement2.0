import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DiscountExpirationDate implements IPriceCalculator {


    @Override
    public boolean checkIfListIsQualifiedForDiscount(Charge charge, Medicine medicine) {

            long daysBetween = DAYS.between(LocalDate.now(), charge.getExpirationDate());

            int discountDays = 30;

            if(daysBetween > discountDays){
                return false;
            }else{
                calculateDiscount(medicine);
                return true;
            }
        }


    //nog oplossen dat hij alleen de korting aanpast voor de charge waar het voor geldt, en niet voor alle charges van hetzelfde medicijn.
    @Override
    public double calculateDiscount(Medicine medicine) {

        double discountDouble = 0.75;

        double discountPrice = medicine.getPrice() * discountDouble;

        return discountPrice;
    }
}


