/*******************************************************************
 * @purpose : Response DTO used for checking response of details
 * @author  : Seema Balkrishna Rajpure
 * @Date    : 04/07/2020
 *******************************************************************/
package com.quantitymeasurement.dto;

import com.quantitymeasurement.enums.SubQuantities;

import java.util.List;

public class ResponseDTO {
    private Object value;
    private String message;
    private Integer statusCode;

    /**+
     * @purpose : To check output response
     * @param value
     * @param message
     * @param statusCode
     */
    public ResponseDTO(double value, String message, Integer statusCode) {
        this.value = value;
        this.message = message;
        this.statusCode = statusCode;
    }

    public Object getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}

