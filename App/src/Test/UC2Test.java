package Test;

package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC2.Feet;
import com.apps.quantitymeasurement.UC2.Inches;

public class UC2Test {

    @Test
    void testFeet_SameValue() {
        assertEquals(new Feet(1.0), new Feet(1.0));
    }

    @Test
    void testFeet_DifferentValue() {
        assertNotEquals(new Feet(1.0), new Feet(2.0));
    }

    @Test
    void testFeet_Null() {
        assertNotEquals(new Feet(1.0), null);
    }

    @Test
    void testFeet_DifferentClass() {
        assertNotEquals(new Feet(1.0), new Inches(12.0));
    }

    @Test
    void testFeet_SameReference() {
        Feet f = new Feet(1.0);
        assertEquals(f, f);
    }

    @Test
    void testInches_SameValue() {
        assertEquals(new Inches(12.0), new Inches(12.0));
    }

    @Test
    void testInches_DifferentValue() {
        assertNotEquals(new Inches(12.0), new Inches(24.0));
    }

    @Test
    void testInches_Null() {
        assertNotEquals(new Inches(12.0), null);
    }

    @Test
    void testInches_DifferentClass() {
        assertNotEquals(new Inches(12.0), new Feet(1.0));
    }

    @Test
    void testInches_SameReference() {
        Inches i = new Inches(12.0);
        assertEquals(i, i);
    }
}