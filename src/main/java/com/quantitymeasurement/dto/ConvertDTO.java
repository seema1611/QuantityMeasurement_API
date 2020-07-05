package com.quantitymeasurement.dto;

import com.quantitymeasurement.enums.SubQuantities;

public class ConvertDTO {
    public Double valueOfInitialUnit;
    public SubQuantities baseUnit;
    public SubQuantities targetUnit;

    public ConvertDTO(Double valueOfInitialUnit, SubQuantities baseUnit, SubQuantities targetUnit) {
        this.valueOfInitialUnit = valueOfInitialUnit;
        this.baseUnit = baseUnit;
        this.targetUnit = targetUnit;
    }
}
