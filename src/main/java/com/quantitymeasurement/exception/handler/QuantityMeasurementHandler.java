package com.quantitymeasurement.exception.handler;

public enum QuantityMeasurementHandler {
    MAIN_UNITS(200,"Main Units Access Successfully"),
    SUB_UNITS(200,"Sub Units Access Successfully"),
    CONVERSION_SUCCESS(200,"Conversion Done successfully"),
    DIFFERENT_MAIN_UNIT(400, "Entered Main Units are Different"),
    INVALID_UNIT(400,"Please Enter Valid Unit" ),
    INTERNAL_ERROR(500, "Something went wrong try again later");

    private int code;
    private String message;

    QuantityMeasurementHandler(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
