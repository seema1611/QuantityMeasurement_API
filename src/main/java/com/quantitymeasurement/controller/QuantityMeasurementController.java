/****************************************************************************************
 * @purpose : Quantity Measurement Controller used for handling the request and response
 * @author  : Seema Balkrishna Rajpure
 * @Date    : 04/07/2020
 ****************************************************************************************/
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

    /**+
     * @Purpose : To Retire all main quantities
     * @return : All main Quantities
     */
    @GetMapping("/mainunits")
    public Quantities[] getAllMainQuantities() {
        return quantityMeasurementService.getAllMainUnits();
    }

    /**+
     * @purpose : To Retire sub quantities based on main quantities
     * @param unit
     * @return : Respective sub quantities
     */
    @GetMapping("/subunits")
    public List<SubQuantities> getAllSubQuantities(@RequestParam(value = "unit") Quantities unit) {
        return quantityMeasurementService.getAllSubUnits(unit);
//        List<SubQuantities> allSubUnits = quantityMeasurementService.getAllSubUnits(unit);
//        ResponseDTO responseDTO = new ResponseDTO(allSubUnits, "Conversion Done Successfully", 200);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**+
     * @purpose : To convert data
     * @param convertDTO
     * @return : converted value
     */
    @PostMapping("/convert")
    public ResponseEntity<ResponseDTO> convert(@RequestBody ConvertDTO convertDTO) {
        Double convertedValue = quantityMeasurementService.getConvertedValueOfUnit(convertDTO);
        ResponseDTO responseDTO = new ResponseDTO(convertedValue, "Conversion Done Successfully", 200);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
