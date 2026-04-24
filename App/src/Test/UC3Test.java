package Test;

package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC3.Quantity;

public class UC3Test {

    @Test
    void testSameValueSameUnit() {
        assertEquals(new Quantity(1.0, "FEET"), new Quantity(1.0, "FEET"));
    }

    @Test
    void testDifferentValue() {
        assertNotEquals(new Quantity(1.0, "FEET"), new Quantity(2.0, "FEET"));
    }

    @Test
    void testDifferentUnit() {
        assertNotEquals(new Quantity(1.0, "FEET"), new Quantity(1.0, "INCH"));
    }

    @Test
    void testNull() {
        assertNotEquals(new Quantity(1.0, "FEET"), null);
    }

    @Test
    void testSameReference() {
        Quantity q = new Quantity(1.0, "FEET");
        assertEquals(q, q);
    }
}