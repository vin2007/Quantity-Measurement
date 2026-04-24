package main;

package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public enum LengthUnit {

        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.393701 / 12.0);

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeetFactor;
        }
    }

    public static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {

            if (unit == null)
                throw new IllegalArgumentException();

            if (!Double.isFinite(value))
                throw new IllegalArgumentException();

            this.value = value;
            this.unit = unit;
        }

        public QuantityLength add(QuantityLength other) {

            if (other == null)
                throw new IllegalArgumentException();

            double thisFeet = unit.toFeet(this.value);
            double otherFeet = other.unit.toFeet(other.value);
            double sumFeet = thisFeet + otherFeet;
            double resultValue = unit.fromFeet(sumFeet);

            return new QuantityLength(resultValue, unit);
        }

        public static QuantityLength add(
                QuantityLength length1,
                QuantityLength length2) {

            if (length1 == null || length2 == null)
                throw new IllegalArgumentException();

            return length1.add(length2);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityLength other = (QuantityLength) obj;

            double thisFeet = unit.toFeet(value);
            double otherFeet = other.unit.toFeet(other.value);

            return Double.compare(thisFeet, otherFeet) == 0;
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2);

        System.out.println(
                "add(Quantity(1.0, FEET), Quantity(12.0, INCHES))");

        System.out.println("Output: " + result);

        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARDS);

        QuantityLength feet =
                new QuantityLength(3.0, LengthUnit.FEET);

        System.out.println(
                "add(Quantity(1.0, YARDS), Quantity(3.0, FEET))");

        System.out.println("Output: " + yard.add(feet));
    }
}