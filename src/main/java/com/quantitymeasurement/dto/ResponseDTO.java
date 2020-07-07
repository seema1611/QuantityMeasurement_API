/*******************************************************************
 * @purpose : Response DTO used for checking response of details
 * @author  : Seema Balkrishna Rajpure
 * @Date    : 04/07/2020
 *******************************************************************/
package com.quantitymeasurement.dto;

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
    public ResponseDTO( Object value, String message, Integer statusCode) {
        this.value = value;
        this.message = message;
        this.statusCode = statusCode;
    }

//    public ResponseDTO(List<Quantities> value, String message, int statusCode) {
//        this.value = value;
//        this.message = message;
//        this.statusCode = statusCode;
//    }


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

