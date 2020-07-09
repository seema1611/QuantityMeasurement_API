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
import com.quantitymeasurement.exception.QuantityMeasurementException;
import com.quantitymeasurement.exception.handler.QuantityMeasurementHandler;
import com.quantitymeasurement.service.IQuantityMeasurementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class QuantityMeasurementController {
    @Autowired
    IQuantityMeasurementService quantityMeasurementService;

    /**+
     * @Purpose : The API Used for Get list of Main units and Retire all main quantities
     * @return : All main Quantities
     */
    @ApiOperation("You are access main units(LENGTH, VOLUME, WEIGHT, TEMPERATURE)")
    @GetMapping("/mainunits")
    public ResponseEntity getAllMainQuantities() {
        List<Quantities> allMainUnits = quantityMeasurementService.getAllMainUnits();
        ResponseDTO responseDTO = new ResponseDTO(allMainUnits,  QuantityMeasurementHandler.MAIN_UNITS.getMessage(), QuantityMeasurementHandler.MAIN_UNITS.getCode());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**+
     * @purpose : The API Used for Get list of Sub units based on main quantities
     * @param unit
     * @return : Respective sub quantities
     */
    @ApiOperation("You are access sub units based on main unit")
    @GetMapping("/subunits")
    public ResponseEntity getAllSubQuantities(@RequestParam(value = "unit") Quantities unit) {
        List<SubQuantities> allSubUnits = quantityMeasurementService.getAllSubUnits(unit);
        ResponseDTO responseDTO = new ResponseDTO(allSubUnits, QuantityMeasurementHandler.SUB_UNITS.getMessage(), QuantityMeasurementHandler.SUB_UNITS.getCode());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**+
     * @purpose : The API Used for to convert data base unit into target unit
     * @param convertDTO
     * @return : converted value
     */
    @ApiOperation("Convert the values base unit into target units")
    @PostMapping("/convert")
    public ResponseEntity<ResponseDTO> convert(@RequestBody ConvertDTO convertDTO) throws QuantityMeasurementException {
        Double convertedValue = quantityMeasurementService.getConvertedValueOfUnit(convertDTO);
        ResponseDTO responseDTO = new ResponseDTO(convertedValue, QuantityMeasurementHandler.CONVERSION_SUCCESS.getMessage(), QuantityMeasurementHandler.CONVERSION_SUCCESS.getCode());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseDTO handleWrongUnitExceptions(HttpMessageNotReadableException ex) {
        return new ResponseDTO(null, QuantityMeasurementHandler.INVALID_UNIT.getMessage(),QuantityMeasurementHandler.INVALID_UNIT.getCode());
    }


    @ExceptionHandler(QuantityMeasurementException.class)
    public ResponseDTO handlerQuantityException(QuantityMeasurementException ex) {
        return new ResponseDTO(ex.getHandler(), ex.getHandler().getMessage(),500);
    }


    @ExceptionHandler(Exception.class)
    public ResponseDTO handleGenericRExceptions(Exception e){
        return new ResponseDTO(null, QuantityMeasurementHandler.INTERNAL_ERROR.getMessage(),QuantityMeasurementHandler.INTERNAL_ERROR.getCode());
    }
}
