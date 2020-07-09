/*******************************************************************
 * @purpose : Response DTO used for checking response of details
 * @author  : Seema Balkrishna Rajpure
 * @Date    : 04/07/2020
 *******************************************************************/
package com.quantitymeasurement.dto;

public class ResponseDTO {
    private Object data;
    private String message;
    private Integer statusCode;

    /**+
     * @purpose : To check output response
     * @param data
     * @param message
     * @param statusCode
     */
    public ResponseDTO(Object data, String message, Integer statusCode) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}

