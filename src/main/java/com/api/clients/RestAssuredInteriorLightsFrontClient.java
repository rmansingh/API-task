package com.api.clients;

import com.api.model.InteriorLightStatus;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import lombok.Builder;
import org.apache.http.HttpStatus;

import static com.api.RestAssuredHelper.statusMatcherFor;
import static io.restassured.RestAssured.given;

public class RestAssuredInteriorLightsFrontClient extends RestAssuredClient {

    private static final String PATH = "/resources/interiorLightsFront";
    private static final String GET_DELIVERIES_ERROR_MESSAGE = "Interior lights front";

    @Builder
    public RestAssuredInteriorLightsFrontClient(boolean loggingEnabled) {
        this.loggingEnabled = loggingEnabled;
    }

    protected RequestSpecification getSpec() {
        return getBaseSpec();
    }

    @Step
    public InteriorLightStatus getInteriorLightsStatus(String vehicleId) {
        return given()
                .spec(getSpec())
                .when()
                .get(vehicleId + PATH)
                .then()
                .assertThat()
                .statusCode(
                        statusMatcherFor(HttpStatus.SC_OK, GET_DELIVERIES_ERROR_MESSAGE)
                )
                .extract()
                .as(InteriorLightStatus.class);
    }
}
