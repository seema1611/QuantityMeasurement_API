package com.quantitymeasurement.exception.handler;

import com.quantitymeasurement.exception.QuantityMeasurementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class QuantityMeasurementHandlerException {

    @ExceptionHandler
    public ResponseEntity<String> handlingException(QuantityMeasurementException quantityMeasurementException) {
        return new ResponseEntity<>(quantityMeasurementException.message, HttpStatus.OK);
    }
}


