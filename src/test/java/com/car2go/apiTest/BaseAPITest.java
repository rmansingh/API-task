package com.car2go.apiTest;

import org.testng.annotations.DataProvider;

public class BaseAPITest {

    @DataProvider
    public Object[][] userData() {
        return new Object[][]{
                {"WDB111111ZZZ22222"}
        };
    }
}
