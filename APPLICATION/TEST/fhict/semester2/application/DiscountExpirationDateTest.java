package fhict.semester2.application;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class DiscountExpirationDateTest {

    @Test
    public void checkIfListIsQualifiedForDiscount_true() {
        DiscountExpirationDateTest discountExpirationDateTest = new DiscountExpirationDateTest();
        Medicine medicineTest = new Medicine("123", "Paracetamol", 1.99);
        Charge chargeTest = new Charge("a15", LocalDate.of(2021,6,20), 100);

        assertTrue(chargeTest.getExpirationDate().toString());

    }



    @Test
    public void calculateDiscount() {
    }
}