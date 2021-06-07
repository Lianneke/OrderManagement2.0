package fhict.semester2.application;

import org.junit.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;

public class DiscountExpirationDateTest {

    @Test
    public void checkIfListIsQualifiedForDiscount_false() {
    Charge testCharge = new Charge("a15", LocalDate.of(2021, 8, 20), 100);
    Medicine testMedicine = new Medicine("123", "Paracetamol", 2);
    DiscountExpirationDate testDiscountExpirationDate = new DiscountExpirationDate();

    assertEquals(0.0, testDiscountExpirationDate.checkIfListIsQualifiedForDiscount(testCharge, testMedicine));
    }


    @Test
    public void calculateDiscount() {
        Medicine testMedicine = new Medicine("123", "Paracetamol", 2);
        DiscountExpirationDate testDiscountExpirationDate = new DiscountExpirationDate();

        assertEquals(1.5, testDiscountExpirationDate.calculateDiscount(testMedicine));
    }
}