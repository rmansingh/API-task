package com.car2go.uiTest;

import com.base.BaseTest;
import com.pages.Homepage;
import com.pages.LoginPage;
import com.pages.globalelements.MetabarNavigation;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Author: Rupak Mansingh
 * @Desc: Test cases for Login page
 */
@Owner("Rupak Mansingh")
@Feature("Login features")
public class LoginTest extends BaseTest {

    @Test()
    @Description("Login with valid credentials")
    public void loginWithValidCredentials() {
        loginWithCredential();

        assertThat("Dashboard page title didn't displayed", getDriver().getTitle(), is("car2go Carsharing "));
        assertThat("Dashboard page url didn't displayed", getDriver().getCurrentUrl(), is(containsString(System.getProperty("baseurl") + "/US/en/myaccount")));
    }

    @Test(dataProvider = "invalidCredentials")
    @Description("Login with invalid credentials")
    public void loginWithInvalidCredentials(String username, String password) {
        Homepage homepage = new Homepage(getDriver());
        homepage.openHomePage()
                .clickOnLoginLink()
                .enterUserName(username)
                .enterPassword(password)
                .clickLoginButton();

        assertThat("Login error message is not as expected", new LoginPage(getDriver()).getErrorMessageText(),
                is(containsString("Login failed. Please enter your car2go e-mail address and your car2go password to log in to your car2go account.")));
    }

    @Test()
    @Description("Login with valid credential and log out from the system")
    public void loginAndThenLogout() {
        loginWithCredential()
                .addressDataIsDisplayed();

        assertThat("Dashboard page title didn't display", getDriver().getTitle(), is("car2go Carsharing "));
        assertThat("Dashboard page url didn't display", getDriver().getCurrentUrl(), is(System.getProperty("baseurl") + "/US/en/myaccount/#/dashboard.html"));

        MetabarNavigation metabarNavigation = new MetabarNavigation(getDriver());
        metabarNavigation.clickLogoutButton();

        assertThat("Home page title didn't display", getDriver().getTitle(), is("Hourly Car Rental and Car Sharing App | car2go USA"));
        assertThat("Home page url didn't display", getDriver().getCurrentUrl(), is(System.getProperty("baseurl") + "/US/en/"));
    }

    @DataProvider
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {System.getProperty("username"), "invalid-username" + System.currentTimeMillis()},
                {"invalid-" + System.currentTimeMillis() + "@gmail.com", System.getProperty("password")},
        };
    }
}
