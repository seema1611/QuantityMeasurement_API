package com.quantitymeasurement.exception;

import com.quantitymeasurement.exception.handler.QuantityMeasurementHandler;

public class QuantityMeasurementException extends RuntimeException {

    private QuantityMeasurementHandler handler;


    public QuantityMeasurementException(QuantityMeasurementHandler handler) {
        this.handler = handler;
    }

    public QuantityMeasurementHandler getHandler() {
        return handler;
    }

    public void setHandler(QuantityMeasurementHandler handler) {
        this.handler = handler;
    }
}