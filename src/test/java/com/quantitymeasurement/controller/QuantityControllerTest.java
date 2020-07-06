/************************************************************************************
 * @purpose : Quantity Measurement Controller Test for checking code using mock MVC
 * @author  : Seema Balkrishna Rajpure
 * @Date    : 04/07/2020
 ************************************************************************************/
package com.quantitymeasurement.controller;

import com.google.gson.Gson;
import com.quantitymeasurement.dto.ConvertDTO;
import com.quantitymeasurement.dto.ResponseDTO;
import com.quantitymeasurement.enums.Quantities;
import com.quantitymeasurement.enums.SubQuantities;
import com.quantitymeasurement.service.implementors.QuantityMeasurementService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static com.quantitymeasurement.enums.Quantities.*;
import static com.quantitymeasurement.enums.SubQuantities.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class QuantityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuantityMeasurementService quantityMeasurementService;

    Gson gson = new Gson();

    //TC1 -> Test case for retire all main quantities
    @Test
    public void givenQuantityMeasurement_ShouldReturnAllTheMainUnits() throws Exception {
        Quantities[] array = {LENGTH, VOLUME, WEIGHT, TEMPERATURE};
        given(quantityMeasurementService.getAllMainUnits()).willReturn(array);
        mockMvc.perform(get("/units/mainunits"))
                .andExpect(content().json(Arrays.toString(array)));
    }

    //TC2 -> Test case for retire sub quantities based on main
    @Test
    public void givenQuantityMeasurement_WhenAnyMainUnitValue_ShouldReturnAllTheSubUnits() throws Exception {
        List<SubQuantities> list = Arrays.asList(FEET, INCH, GRAM, KILOGRAM);
        given(quantityMeasurementService.getAllSubUnits(LENGTH)).willReturn(list);
        mockMvc.perform(get("/units/subunits?unit=LENGTH"))
                .andExpect(content().json(String.valueOf(list)));
    }

    //TC3 -> Test case for conversion of feet to inch
    @Test
    public void givenBaseFeetAndTargetInchUnitType_WhenStatusCode200_ShouldReturnConvertedValue() throws Exception {
        ConvertDTO convertDTO = new ConvertDTO(1.0, FEET, INCH);
        String jsonConvertDTO = gson.toJson(convertDTO);

        ResponseDTO responseDTO = new ResponseDTO(12, "Conversion Done Successfully", 200);
        String jsonResponseDTO = gson.toJson(responseDTO);

        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(12.0);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }

    //TC4 -> Test case for conversion of yard to inch
    @Test
    public void givenBaseYardAndTargetInchUnitType_WhenStatusCode200_ShouldReturnConvertedValue() throws Exception {
        ConvertDTO convertDTO = new ConvertDTO(1.0, YARD, INCH);
        String jsonConvertDTO = gson.toJson(convertDTO);

        ResponseDTO responseDTO = new ResponseDTO(36, "Conversion Done Successfully", 200);
        String jsonResponseDTO = gson.toJson(responseDTO);

        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(36.0);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }

    //TC5 -> Test case for conversion of centimeter to inch
    @Test
    public void givenBaseCentimeterAndTargetInchUnitType_WhenStatusCode200_ShouldReturnConvertedValue() throws Exception {
        ConvertDTO convertDTO = new ConvertDTO(50.0, CENTIMETER, INCH);
        String jsonConvertDTO = gson.toJson(convertDTO);

        ResponseDTO responseDTO = new ResponseDTO(20.0, "Conversion Done Successfully", 200);
        String jsonResponseDTO = gson.toJson(responseDTO);

        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(20.0);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }

    //TC6 -> Test case for conversion of gallon to liter
    @Test
    public void givenBaseGallonAndTargetLiterUnitType_WhenStatusCode200_ShouldReturnConvertedValue() throws Exception {
        ConvertDTO convertDTO = new ConvertDTO(1.0, GALLON, LITER);
        String jsonConvertDTO = gson.toJson(convertDTO);

        ResponseDTO responseDTO = new ResponseDTO(3.78, "Conversion Done Successfully", 200);
        String jsonResponseDTO = gson.toJson(responseDTO);

        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(3.78);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }

    //TC7 -> Test case for conversion of milliliter to liter
    @Test
    public void givenBaseMilliliterAndTargetLiterUnitType_WhenStatusCode200_ShouldReturnConvertedValue() throws Exception {
        ConvertDTO convertDTO = new ConvertDTO(1.0, MILLILITRE, LITER);
        String jsonConvertDTO = gson.toJson(convertDTO);

        ResponseDTO responseDTO = new ResponseDTO(0.001, "Conversion Done Successfully", 200);
        String jsonResponseDTO = gson.toJson(responseDTO);

        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(0.001);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }

    //TC8 -> Test case for conversion of gram to kilogram
    @Test
    public void givenBaseGramAndTargetKilogramUnitType_WhenStatusCode200_ShouldReturnConvertedValue() throws Exception {
        ConvertDTO convertDTO = new ConvertDTO(1.0, GRAM, KILOGRAM);
        String jsonConvertDTO = gson.toJson(convertDTO);

        ResponseDTO responseDTO = new ResponseDTO(0.001, "Conversion Done Successfully", 200);
        String jsonResponseDTO = gson.toJson(responseDTO);

        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(0.001);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }

    //TC9 -> Test case for conversion of tonne to kilogram
    @Test
    public void givenBaseTonneAndTargetKilogramUnitType_WhenStatusCode200_ShouldReturnConvertedValue() throws Exception {
        ConvertDTO convertDTO = new ConvertDTO(1.0, TONNE, KILOGRAM);
        String jsonConvertDTO = gson.toJson(convertDTO);

        ResponseDTO responseDTO = new ResponseDTO(1000.0, "Conversion Done Successfully", 200);
        String jsonResponseDTO = gson.toJson(responseDTO);

        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(1000.0);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }

    //TC10 -> Test case for conversion of fahrenheit to celsius
    @Test
    public void givenBaseFahrenheitAndTargetCelsiusUnitType_WhenStatusCode200_ShouldReturnConvertedValue() throws Exception {
        ConvertDTO convertDTO = new ConvertDTO(202.0, FAHRENHEIT, CELSIUS);
        String jsonConvertDTO = gson.toJson(convertDTO);

        ResponseDTO responseDTO = new ResponseDTO(100.0, "Conversion Done Successfully", 200);
        String jsonResponseDTO = gson.toJson(responseDTO);

        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(100.0);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }

    //TC11 -> Test case for conversion of celsius to fahrenheit
    @Test
    public void givenBaseCelsiusAndTargetFahrenheitUnitType_WhenStatusCode200_ShouldReturnConvertedValue() throws Exception {
        ConvertDTO convertDTO = new ConvertDTO(100.0, CELSIUS, FAHRENHEIT);
        String jsonConvertDTO = gson.toJson(convertDTO);

        ResponseDTO responseDTO = new ResponseDTO(202.0, "Conversion Done Successfully", 200);
        String jsonResponseDTO = gson.toJson(responseDTO);

        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(202.0);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }
}
