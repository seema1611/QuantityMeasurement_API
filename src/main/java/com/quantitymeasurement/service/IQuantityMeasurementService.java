/********************************************************************************************
 * @purpose : IQuantity measurement Service interface is used for managed service operation
 * @author  : Seema Balkrishna Rajpure
 * @Date    : 04/07/2020
 ********************************************************************************************/
package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.ConvertDTO;
import com.quantitymeasurement.enums.Quantities;
import com.quantitymeasurement.enums.SubQuantities;
import com.quantitymeasurement.exception.QuantityMeasurementException;

import java.util.List;

public interface IQuantityMeasurementService {
    List<Quantities> getAllMainUnits();
    List<SubQuantities> getAllSubUnits(Quantities unit);
    Double getConvertedValueOfUnit(ConvertDTO convertDTO) throws QuantityMeasurementException;
}
