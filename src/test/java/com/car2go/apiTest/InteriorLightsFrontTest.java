package com.car2go.apiTest;

import com.api.clients.RestAssuredInteriorLightsFrontClient;
import com.api.model.InteriorLightsFront;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Owner("Rupak Mansingh")
@Feature("Api tests for interior lights front")
public class InteriorLightsFrontTest extends BaseAPITest{

    @Test(dataProvider = "userData")
    public void authorizedInteriorLightsFront(String vehicleId) {
        InteriorLightsFront interiorLightsFront = getInteriorLightsFrontStatus(vehicleId);
        assertThat("Meals size didn't update", interiorLightsFront.getTimestamp(), is(1541080800000L));
        assertThat("Number of people(size) didn't update", interiorLightsFront.getValue(), is(false));
    }

    private InteriorLightsFront getInteriorLightsFrontStatus(String vehicleId) {
        return RestAssuredInteriorLightsFrontClient
                .builder()
                .build()
                .getInteriorLightsStatus(vehicleId)
                .getInteriorLightsFront();
    }
}
