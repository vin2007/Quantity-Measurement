package Test;

package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC5.Quantity;
import com.apps.quantitymeasurement.UC5.Unit;

public class UC5Test {

    @Test
    void testFeetToInches() {
        assertEquals(new Quantity(1.0, Unit.FEET), new Quantity(12.0, Unit.INCH));
    }

    @Test
    void testYardToFeet() {
        assertEquals(new Quantity(1.0, Unit.YARD), new Quantity(3.0, Unit.FEET));
    }

    @Test
    void testDifferentValues() {
        assertNotEquals(new Quantity(1.0, Unit.FEET), new Quantity(2.0, Unit.FEET));
    }

    @Test
    void testNull() {
        assertNotEquals(new Quantity(1.0, Unit.FEET), null);
    }

    @Test
    void testSameReference() {
        Quantity q = new Quantity(1.0, Unit.FEET);
        assertEquals(q, q);
    }
}