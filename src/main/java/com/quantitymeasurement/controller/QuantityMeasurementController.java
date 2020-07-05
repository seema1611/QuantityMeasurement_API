package com.quantitymeasurement.controller;

import com.quantitymeasurement.dto.ConvertDTO;
import com.quantitymeasurement.dto.ResponseDTO;
import com.quantitymeasurement.enums.Quantities;
import com.quantitymeasurement.enums.SubQuantities;
import com.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/convert")
    public ResponseEntity<ResponseDTO> convert(@RequestBody ConvertDTO convertDTO) {
        Double convertedValue = quantityMeasurementService.getConvertedValueOfUnit(convertDTO);
        ResponseDTO responseDTO = new ResponseDTO(convertedValue, "Response Successful", 200);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
