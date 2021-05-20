import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DiscountExpirationDate implements IPriceCalculator {


    @Override
    public boolean checkIfListIsQualifiedForDiscount(Order order) {
        for(OrderLine o : order.getOrderLines()){
            long daysBetween = DAYS.between(LocalDate.now(), o.getCharge().getExpirationDate());

            int discountDays = 30;

            if(daysBetween > discountDays){
                return false;
            }else{
                calculateDiscount(o.getMedicine());
                return true;
            }
        }
        return true;

    }

    //nog oplossen dat hij alleen de korting aanpast voor de charge waar het voor geldt, en niet voor alle charges van hetzelfde medicijn.
    @Override
    public void calculateDiscount(Medicine medicine) {

        double discountDouble = 0.75;

        double discountPrice = medicine.getPrice() * discountDouble;

        medicine.setPrice(discountPrice);
    }
}
