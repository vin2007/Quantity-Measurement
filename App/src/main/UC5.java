package main;

package com.apps.quantitymeasurement;

public class UC5 {

    public enum Unit {
        FEET(12), INCH(1), YARD(36);

        private final double factor;

        Unit(double factor) {
            this.factor = factor;
        }

        public double toBase(double value) {
            return value * factor;
        }
    }

    public static class Quantity {
        private final double value;
        private final Unit unit;

        public Quantity(double value, Unit unit) {
            if (Double.isNaN(value) || unit == null) throw new IllegalArgumentException();
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity q = (Quantity) obj;
            return Double.compare(unit.toBase(value), q.unit.toBase(q.value)) == 0;
        }
    }
}