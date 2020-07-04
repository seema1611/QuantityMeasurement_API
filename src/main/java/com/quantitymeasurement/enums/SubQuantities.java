package com.quantitymeasurement.enums;

public enum SubQuantities {
    FEET(12.00, Quantities.LENGTH), INCH(1.00, Quantities.LENGTH),
    YARD(36.01, Quantities.LENGTH), CENTIMETER(0.4, Quantities.LENGTH),

    LITER(1.0, Quantities.VOLUME), GALLON(3.78, Quantities.VOLUME),
    MILLILITRE(1 / 1000.0, Quantities.VOLUME),

    KILOGRAM(1.0, Quantities.WEIGHT), GRAM(1d / 1000, Quantities.WEIGHT),
    TONNE(1000.0, Quantities.WEIGHT),

    CELSIUS(2.12, Quantities.TEMPERATURE), FAHRENHEIT(1.0, Quantities.TEMPERATURE);

    public Double conversionFactor;
    public Quantities mainQuantityType;

    SubQuantities(Double conversionFactor, Quantities mainQuantityType) {
        this.conversionFactor = conversionFactor;
        this.mainQuantityType = mainQuantityType;
    }
}