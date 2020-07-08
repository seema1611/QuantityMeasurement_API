/******************************************************************
 * @purpose : Response DTO used for carries data between processes
 * @author  : Seema Balkrishna Rajpure
 * @Date    : 05/07/2020
 ******************************************************************/
package com.quantitymeasurement.dto;

import com.quantitymeasurement.enums.SubQuantities;

import javax.validation.constraints.NotNull;


public class ConvertDTO {
    @NotNull
    public Double valueOfInitialUnit;

    @NotNull
    public SubQuantities baseUnit;

    @NotNull
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