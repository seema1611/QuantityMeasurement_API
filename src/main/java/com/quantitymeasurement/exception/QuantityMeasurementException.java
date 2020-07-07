package com.quantitymeasurement.exception;

public class QuantityMeasurementException extends RuntimeException {
    public String message;

    public QuantityMeasurementException(String message) {
        this.message = message;
    }
}
