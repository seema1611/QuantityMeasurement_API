package com.quantitymeasurement.controller;

import com.google.gson.Gson;
import com.quantitymeasurement.dto.ConvertDTO;
import com.quantitymeasurement.dto.ResponseDTO;
import com.quantitymeasurement.enums.Quantities;
import com.quantitymeasurement.enums.SubQuantities;
import com.quantitymeasurement.service.implementors.QuantityMeasurementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
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
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuantityMeasurementService quantityMeasurementService;

    @Test
    public void givenQuantityMeasurement_ShouldReturnAllTheMainUnits() throws Exception {
        Quantities[] array = {LENGTH, VOLUME, WEIGHT, TEMPERATURE};
        given(quantityMeasurementService.getAllMainUnits()).willReturn(array);
        mockMvc.perform(get("/units/mainunits"))
                .andExpect(content().json(Arrays.toString(array)));
    }

    @Test
    public void givenQuantityMeasurement_WhenAnyMainUnitValue_ShouldReturnAllTheSubUnits() throws Exception {
        List<SubQuantities> list = Arrays.asList(FEET, INCH, GRAM, KILOGRAM);
        given(quantityMeasurementService.getAllSubUnits(LENGTH)).willReturn(list);
        mockMvc.perform(get("/units/subunits?unit=LENGTH"))
                .andExpect(content().json(String.valueOf(list)));
    }

    @Test
    public void givenBaseFeetAndTargetInchUnitType_WhenStatusCode200_ShouldReturnConvertedValue() throws Exception {
        Gson gson = new Gson();
        ConvertDTO convertDTO = new ConvertDTO(1.0, FEET, INCH);
        String jsonConvertDTO = gson.toJson(convertDTO);
        ResponseDTO responseDto = new ResponseDTO(12, "Response Successful", 200);
        String jsonResponseDTO = gson.toJson(responseDto);
        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(12.0);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }

    @Test
    public void givenBaseFeetAndTargetYardUnitType_WhenStatusCode200_ShouldReturnConvertedValue() throws Exception {
        Gson gson = new Gson();
        ConvertDTO convertDTO = new ConvertDTO(1.0, YARD, INCH);
        String jsonConvertDTO = gson.toJson(convertDTO);
        ResponseDTO responseDto = new ResponseDTO(36, "Response Successful", 200);
        String jsonResponseDTO = gson.toJson(responseDto);
        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(36.0);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }
}
