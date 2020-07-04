package com.quantitymeasurement.service.implementors;

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
}