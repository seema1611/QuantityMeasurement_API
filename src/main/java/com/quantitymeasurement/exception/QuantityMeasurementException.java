package com.quantitymeasurement.exception;

import com.quantitymeasurement.exception.handler.QuantityMeasurementHandler;

public class QuantityMeasurementException extends RuntimeException {

    private QuantityMeasurementHandler error;

    public QuantityMeasurementException(QuantityMeasurementHandler error) {
        this.error=error;
    }

    public QuantityMeasurementHandler getError() {
        return error;
    }

    public void setError(QuantityMeasurementHandler error) {
        this.error=error;
    }
}