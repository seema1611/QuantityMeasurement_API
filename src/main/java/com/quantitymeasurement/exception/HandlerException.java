package com.quantitymeasurement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {
    @ExceptionHandler
    public ResponseEntity<String> handlingException(QuantityMeasurementException quantityMeasurementException) {
        return new ResponseEntity<>(quantityMeasurementException.message, HttpStatus.OK);
    }
}

