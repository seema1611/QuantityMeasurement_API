package com.quantitymeasurement.controller;

import com.quantitymeasurement.enums.Quantities;
import com.quantitymeasurement.enums.SubQuantities;
import com.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/units")
public class QuantityMeasurementController {
    @Autowired
    IQuantityMeasurementService quantityMeasurementService;

    @GetMapping("/mainunits")
    public Quantities[] getAllMainQuantities() {
        return quantityMeasurementService.getAllMainUnits();
    }

    @GetMapping("/subunits")
    public List<SubQuantities> getAllSubQuantities(@RequestParam(value = "unit") Quantities unit) {
        return quantityMeasurementService.getAllSubUnits(unit);
    }
}
