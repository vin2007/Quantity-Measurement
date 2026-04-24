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
        private final Test.QuantityMeasurementApp.LengthUnit unit;


        public QuantityLength(double value, Test.QuantityMeasurementApp.LengthUnit unit) {

            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid numeric value");

            this.value = value;
            this.unit = unit;
        }



        public Test.QuantityMeasurementApp.QuantityLength add(Test.QuantityMeasurementApp.QuantityLength other) {

            return add(this, other, this.unit);
        }



        public static Test.QuantityMeasurementApp.QuantityLength add(
                Test.QuantityMeasurementApp.QuantityLength length1,
                Test.QuantityMeasurementApp.QuantityLength length2,
                Test.QuantityMeasurementApp.LengthUnit targetUnit) {

            if (length1 == null || length2 == null)
                throw new IllegalArgumentException("Operands cannot be null");

            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            double feetValue1 =
                    length1.unit.toFeet(length1.value);

            double feetValue2 =
                    length2.unit.toFeet(length2.value);

            double sumFeet =
                    feetValue1 + feetValue2;

            double resultValue =
                    targetUnit.fromFeet(sumFeet);

            return new Test.QuantityMeasurementApp.QuantityLength(resultValue, targetUnit);
        }


        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Test.QuantityMeasurementApp.QuantityLength other =
                    (Test.QuantityMeasurementApp.QuantityLength) obj;

            double thisFeet =
                    unit.toFeet(value);

            double otherFeet =
                    other.unit.toFeet(other.value);

            return Double.compare(thisFeet, otherFeet) == 0;
        }


        @Override
        public String toString() {

            return "Quantity(" + value + ", " + unit + ")";
        }
    }


    public static void main(String[] args) {

        Test.QuantityMeasurementApp.QuantityLength feet =
                new Test.QuantityMeasurementApp.QuantityLength(1.0, Test.QuantityMeasurementApp.LengthUnit.FEET);

        Test.QuantityMeasurementApp.QuantityLength inches =
                new Test.QuantityMeasurementApp.QuantityLength(12.0, Test.QuantityMeasurementApp.LengthUnit.INCHES);


        System.out.println(
                Test.QuantityMeasurementApp.QuantityLength.add(
                        feet,
                        inches,
                        Test.QuantityMeasurementApp.LengthUnit.FEET));

        System.out.println(
                Test.QuantityMeasurementApp.QuantityLength.add(
                        feet,
                        inches,
                        Test.QuantityMeasurementApp.LengthUnit.INCHES));

        System.out.println(
                Test.QuantityMeasurementApp.QuantityLength.add(
                        feet,
                        inches,
                        Test.QuantityMeasurementApp.LengthUnit.YARDS));
    }
}