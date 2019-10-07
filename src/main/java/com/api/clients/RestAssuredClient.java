package com.api.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import static com.api.RestAssuredConstants.BASIC_REQUEST_SPECIFICATION;
import static io.restassured.http.ContentType.JSON;

public class RestAssuredClient {

    protected String baseUrl="https://api.mercedes-benz.com/vehicledata_tryout/v1/vehicles/";
    protected boolean loggingEnabled;


    /**
     * Uses a user to get an access token
     * sets Authorization header to the access token
     * modifies the user by setting its access token field
     *
     * @return RequestSpecification containing
     *         base URL,
     *         Authorization header,
     *         JSON content type,
     *         default configs(logging, objectMapping)
     *         default filters
     *         and other inside
     */
    protected RequestSpecification getBaseSpec() {

        RequestSpecBuilder specBuilder = new RequestSpecBuilder()
                .addRequestSpecification(BASIC_REQUEST_SPECIFICATION)
                .setContentType(JSON)
                .setBaseUri(baseUrl)
                .addHeader("Authorization", String.format("Bearer %s", System.getProperty("bearertoken")));

        if (loggingEnabled) {
            specBuilder.addFilter(new RequestLoggingFilter(LogDetail.ALL))
                    .addFilter(new ResponseLoggingFilter(LogDetail.ALL));
        }
        return specBuilder
                .build();
    }
}