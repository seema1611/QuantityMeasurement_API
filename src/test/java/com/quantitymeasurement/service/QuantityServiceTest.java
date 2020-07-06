/*************************************************************************
 * @purpose : Quantity Measurement Service Test used for checking code
 * @author  : Seema Balkrishna Rajpure
 * @Date    : 05/07/2020
 *************************************************************************/
package com.quantitymeasurement.service;

import com.quantitymeasurement.dto.ConvertDTO;
import com.quantitymeasurement.enums.Quantities;
import com.quantitymeasurement.enums.SubQuantities;
import com.quantitymeasurement.service.implementors.QuantityMeasurementService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class QuantityServiceTest {

    //TC1 -> Test case for retire all main quantities size
    @Test
    void givenQuantityMeasurementMainUnits_ShouldReturnAllUnitList() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        List<Quantities> allQuantityTypes = Arrays.asList( quantityMeasurementService.getAllMainUnits());
        Assert.assertEquals(4,allQuantityTypes.size());
    }

    //TC2 -> Test case for retire length subQuantities size
    @Test
    void givenQuantityMeasurement_WhenLengthMainUnit_ShouldReturnAllSubUnits() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        List<SubQuantities> allSubQuantitiesTypes = quantityMeasurementService.getAllSubUnits(Quantities.LENGTH);
        Assert.assertEquals(4,allSubQuantitiesTypes.size());
    }

    //TC3 -> Test case for retire volume subQuantities size
    @Test
    void givenQuantityMeasurement_WhenVolumeMainUnit_ShouldReturnAllSubUnits() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        List<SubQuantities> allSubQuantitiesTypes = quantityMeasurementService.getAllSubUnits(Quantities.VOLUME);
        Assert.assertEquals(3,allSubQuantitiesTypes.size());
    }

    //TC4 -> Test case for retire weight subQuantities size
    @Test
    void givenQuantityMeasurement_WhenWeightMainUnit_ShouldReturnAllSubUnits() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        List<SubQuantities> allSubQuantitiesTypes = quantityMeasurementService.getAllSubUnits(Quantities.WEIGHT);
        Assert.assertEquals(3,allSubQuantitiesTypes.size());
    }

    //TC5 -> Test case for retire temperature subQuantities size
    @Test
    void givenQuantityMeasurement_WhenTemperatureMainUnit_ShouldReturnAllSubUnits() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        List<SubQuantities> allSubQuantitiesTypes = quantityMeasurementService.getAllSubUnits(Quantities.TEMPERATURE);
        Assert.assertEquals(2,allSubQuantitiesTypes.size());
    }

    //TC6 -> Test case for convert feet to inch
    @Test
    void givenQuantityMeasurementInLength_When1FeetConvertToInch_ShouldReturn12Inch() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        ConvertDTO convertDTO = new ConvertDTO(1.0,SubQuantities.FEET,SubQuantities.INCH);
        double convertedResult = quantityMeasurementService.getConvertedValueOfUnit(convertDTO);
        Assert.assertEquals(12.0,convertedResult,0.0);
    }

    //TC7 -> Test case for convert yard to inch
    @Test
    void givenQuantityMeasurementInLength_When1YardConvertToInch_ShouldReturn36Inch() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        ConvertDTO convertDTO = new ConvertDTO(1.0,SubQuantities.YARD,SubQuantities.INCH);
        double convertedResult = quantityMeasurementService.getConvertedValueOfUnit(convertDTO);
        Assert.assertEquals(36.01,convertedResult,0.0);
    }

    //TC8 -> Test case for convert centimeter to inch
    @Test
    void givenQuantityMeasurementInLength_When50CentimeterConvertToInch_ShouldReturn20Inch() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        ConvertDTO convertDTO = new ConvertDTO(50.0,SubQuantities.CENTIMETER,SubQuantities.INCH);
        double convertedResult = quantityMeasurementService.getConvertedValueOfUnit(convertDTO);
        Assert.assertEquals(20.0,convertedResult,0.0);
    }

    //TC9 -> Test case for convert inch to feet
    @Test
    void givenQuantityMeasurementInLength_When12InchConvertToFeet_ShouldReturn1Feet() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        ConvertDTO convertDTO = new ConvertDTO(12.0,SubQuantities.INCH,SubQuantities.FEET);
        double convertedResult = quantityMeasurementService.getConvertedValueOfUnit(convertDTO);
        Assert.assertEquals(1.00,convertedResult,0.0);
    }

    //TC10 -> Test case for convert inch to centimeter
    @Test
    void givenQuantityMeasurementInLength_When1InchConvertToCentimeter_ShouldReturn2Pt5Centimeter() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        ConvertDTO convertDTO = new ConvertDTO(1.0,SubQuantities.INCH,SubQuantities.CENTIMETER);
        double convertedResult = quantityMeasurementService.getConvertedValueOfUnit(convertDTO);
        Assert.assertEquals(2.50,convertedResult,0.0);
    }

    //TC11 -> Test case for convert milliliter to liter
    @Test
    void givenQuantityMeasurementInVolume_When1000MilliliterConvertLiter_ShouldReturn1Liter() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        ConvertDTO convertDTO = new ConvertDTO(1000.0,SubQuantities.MILLILITRE,SubQuantities.LITER);
        double convertedResult = quantityMeasurementService.getConvertedValueOfUnit(convertDTO);
        Assert.assertEquals(1.0,convertedResult,0.0);
    }

    //TC12 -> Test case for convert tonne to kilogram
    @Test
    void givenQuantityMeasurementInWeight_When1TonneConvertKilogram_ShouldReturn1000Kilogram() {
        QuantityMeasurementService quantityMeasurementService = new QuantityMeasurementService();
        ConvertDTO convertDTO = new ConvertDTO(1.0,SubQuantities.TONNE,SubQuantities.KILOGRAM);
        double convertedResult = quantityMeasurementService.getConvertedValueOfUnit(convertDTO);
        Assert.assertEquals(1000.0,convertedResult,0.0);
    }
}
