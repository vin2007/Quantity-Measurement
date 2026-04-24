package main;

package com.apps.quantitymeasurement;

public class UC3 {

    public static class Quantity {
        private final double value;
        private final String unit;

        public Quantity(double value, String unit) {
            if (Double.isNaN(value) || unit == null) throw new IllegalArgumentException();
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity q = (Quantity) obj;
            return Double.compare(q.value, value) == 0 && unit.equals(q.unit);
        }
    }
}