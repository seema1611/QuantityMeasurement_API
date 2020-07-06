/*************************************************************************
 * @purpose : Quantity Measurement Service Test used for checking code
 * @author  : Seema Balkrishna Rajpure
 * @Date    : 05/07/2020
 *************************************************************************/
package com.quantitymeasurement.service;

import com.quantitymeasurement.enums.Quantities;
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
}
