package fhict.semester2.application;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ChargeTest {

    @Test
    public void checkAndSetQuantity_true() {
    Charge chargeTest = new Charge("4596", LocalDate.of(2021,9,10), 500 );
    assertTrue(chargeTest.checkAndSetQuantity(100));
    }

    @Test
    public void checkAndSetQuantity_false() {
        Charge chargeTest = new Charge("4596", LocalDate.of(2021,9,10), 500 );
        assertFalse(chargeTest.checkAndSetQuantity(501));
    }

    @Test
    public void getQuantity() {
        Charge chargeTest = new Charge("4596", LocalDate.of(2021,9,10), 500 );
        chargeTest.checkAndSetQuantity(200);
        assertEquals(300, chargeTest.getQuantity(), 0);
    }
}