package com.car2go.apiTest;

import com.api.clients.RestAssuredFrontRightDoorResourceClient;
import com.api.model.DoorStatusFrontRight;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Owner("Rupak Mansingh")
@Feature("Api tests for front right door resources")
public class FrontRightDoorResourceTest extends BaseAPITest {

    @Test(dataProvider = "userData")
    public void authorizedFrontRightDoorResource(String vehicleId) {
        DoorStatusFrontRight doorstatusfrontright = getDoorStatusFrontRight(vehicleId);
        assertThat("Meals size didn't update", doorstatusfrontright.getTimestamp(), is(1541080800000L));
        assertThat("Number of people(size) didn't update", doorstatusfrontright.getValue(), is(false));
    }

    private DoorStatusFrontRight getDoorStatusFrontRight(String vehicleId) {
        return RestAssuredFrontRightDoorResourceClient
                .builder()
                .build()
                .getDoorStatus(vehicleId)
                .getDoorstatusfrontright();
    }
}
