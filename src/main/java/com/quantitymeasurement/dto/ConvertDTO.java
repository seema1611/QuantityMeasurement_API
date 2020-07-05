/******************************************************************
 * @purpose : Response DTO used for carries data between processes
 * @author  : Seema Balkrishna Rajpure
 * @Date    : 05/07/2020
 ******************************************************************/
package com.quantitymeasurement.dto;

import com.quantitymeasurement.enums.SubQuantities;

public class ConvertDTO {
    public Double valueOfInitialUnit;
    public SubQuantities baseUnit;
    public SubQuantities targetUnit;

    /**+
     * @purpose : To conversion purpose
     * @param valueOfInitialUnit
     * @param baseUnit
     * @param targetUnit
     */
    public ConvertDTO(Double valueOfInitialUnit, SubQuantities baseUnit, SubQuantities targetUnit) {
        this.valueOfInitialUnit = valueOfInitialUnit;
        this.baseUnit = baseUnit;
        this.targetUnit = targetUnit;
    }
}