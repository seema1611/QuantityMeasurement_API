/******************************************************************************
 * @purpose : Quantity Measurement Service class implement the business logic
 * @author  : Seema Balkrishna Rajpure
 * @Date    : 04/07/2020
 ******************************************************************************/
package com.quantitymeasurement.service.implementors;

import com.quantitymeasurement.dto.ConvertDTO;
import com.quantitymeasurement.enums.Quantities;
import com.quantitymeasurement.enums.SubQuantities;
import com.quantitymeasurement.exception.QuantityMeasurementException;
import com.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    /**+
     * @purpose : To pass main quantities
     * @return : Retire main Quantities
     */
    @Override
    public List<Quantities> getAllMainUnits() {
        return Arrays.asList(Quantities.values());
    }

    /**+
     * @purpose : To pass sub quantities
     * @param unit
     * @return : Retire sub quantities based on main quantities
     */
    @Override
    public List<SubQuantities> getAllSubUnits(Quantities unit) {
        return Arrays.stream(SubQuantities.values())
                .filter(units -> units.mainQuantityType.equals(unit))
                .collect(Collectors.toList());
    }

    /**+
     * @purpose : To convert the value base into target
     * @param convertDTO
     * @return : Converted value
     */
    @Override
    public Double getConvertedValueOfUnit(ConvertDTO convertDTO) throws QuantityMeasurementException {
        if (convertDTO.baseUnit.mainQuantityType.equals(convertDTO.targetUnit.mainQuantityType)) {
            if (convertDTO.baseUnit.mainQuantityType.equals(Quantities.TEMPERATURE)) {
                return conversionForTemperatureUnits(convertDTO);
            }
            return (convertDTO.valueOfInitialUnit * convertDTO.baseUnit.conversionFactor) / convertDTO.targetUnit.conversionFactor;
        }
        throw new QuantityMeasurementException("Main units are different");
    }

    public Double conversionForTemperatureUnits(ConvertDTO convertDTO) {
        if (convertDTO.baseUnit == SubQuantities.CELSIUS && convertDTO.targetUnit == SubQuantities.FAHRENHEIT)
            return (convertDTO.valueOfInitialUnit * convertDTO.baseUnit.conversionFactor) + 32;
        return (convertDTO.valueOfInitialUnit - 32) * convertDTO.baseUnit.conversionFactor;
    }
}