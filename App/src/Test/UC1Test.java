package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC1.Feet;

public class UC1Test {

    @Test
    void testEquality_SameValue() {
        assertEquals(new Feet(1.0), new Feet(1.0));
    }

    @Test
    void testEquality_DifferentValue() {
        assertNotEquals(new Feet(1.0), new Feet(2.0));
    }

    @Test
    void testEquality_NullComparison() {
        assertNotEquals(new Feet(1.0), null);
    }

    @Test
    void testEquality_DifferentClass() {
        assertNotEquals(new Feet(1.0), "1.0");
    }

    @Test
    void testEquality_SameReference() {
        Feet f = new Feet(1.0);
        assertEquals(f, f);
    }
}