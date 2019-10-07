package com.car2go.uiTest;

import com.base.BaseTest;
import com.pages.MyDetailsPage;
import com.pages.globalelements.MainbarNavigation;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Author: Rupak Mansingh
 * @Desc: Test cases for Edit page
 */
@Owner("Rupak Mansingh")
@Feature("Edit user personal details")
public class EditUserDetailsTest extends BaseTest {

    @Test(dataProvider = "userData")
    @Description("Edit user address details")
    public void editAddress(String streetName, String postalCode, String city) {
        loginWithCredential();
        MainbarNavigation mainbarNavigation = new MainbarNavigation(getDriver());
        MyDetailsPage myDetailsPage = mainbarNavigation.openMyDetailsLink()
                .editNameAndAddress()
                .editAddress(streetName, postalCode, city)
                .clickSaveButton();

        assertThat("Street name didn't update", myDetailsPage.getStreetAndHouseNumber(), is(streetName));
        assertThat("Postal code didn't update", myDetailsPage.getPostalCode(), is(postalCode));
        assertThat("City name didn't update", myDetailsPage.getCity(), is(city));
    }

    @Test()
    @Description("Edit user email address")
    public void editEmailAddress() {
        loginWithCredential();
        String emailInput=System.currentTimeMillis() + "uiTest@gmail.com";
        MainbarNavigation mainbarNavigation = new MainbarNavigation(getDriver());
        MyDetailsPage myDetailsPage = mainbarNavigation.openMyDetailsLink()
                .editNameAndAddress()
                .enterEmailAddress(emailInput)
                .clickSaveButton();

        assertThat("Email didn't update", myDetailsPage.getEmailAddress(), is(emailInput));
    }

    @DataProvider
    public Object[][] userData() {
        return new Object[][]{
                {"Teststraße 13", "10039", "Berlin"}
        };
    }
}
