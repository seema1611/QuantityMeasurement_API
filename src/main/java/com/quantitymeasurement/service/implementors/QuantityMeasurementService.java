package com.quantitymeasurement.service.implementors;

import com.quantitymeasurement.enums.Quantities;
import com.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {
    @Override
    public Quantities[] getAllMainUnits() {
        return Quantities.values();
    }
}