package com.quantitymeasurement.service.implementors;

import com.quantitymeasurement.dto.ConvertDTO;
import com.quantitymeasurement.enums.Quantities;
import com.quantitymeasurement.enums.SubQuantities;
import com.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    @Override
    public Quantities[] getAllMainUnits() {
        return Quantities.values();
    }

    @Override
    public List<SubQuantities> getAllSubUnits(Quantities unit) {
        return Arrays.stream(SubQuantities.values())
                .filter(units -> units.mainQuantityType.equals(unit))
                .collect(Collectors.toList());
    }

    @Override
    public Double getConvertedValueOfUnit(ConvertDTO convertDTO) {
        if (convertDTO.baseUnit.mainQuantityType.equals(Quantities.TEMPERATURE)) {
            return conversionForTemperatureUnits(convertDTO);
        }
        return (convertDTO.valueOfInitialUnit * convertDTO.baseUnit.conversionFactor) / convertDTO.targetUnit.conversionFactor;
    }

    public Double conversionForTemperatureUnits(ConvertDTO convertDTO) {
        if (convertDTO.baseUnit == SubQuantities.CELSIUS && convertDTO.targetUnit == SubQuantities.FAHRENHEIT)
            return (convertDTO.valueOfInitialUnit * convertDTO.baseUnit.conversionFactor) + 32;
        return (convertDTO.valueOfInitialUnit - 32) * convertDTO.baseUnit.conversionFactor;
    }
}