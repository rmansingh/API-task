package com.car2go.uiTest;

import com.base.BaseTest;
import com.pages.TripsAndInvoicesPage;
import com.pages.globalelements.MainbarNavigation;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TripsAndInvoicesTest extends BaseTest {

    @Test
    @Description("Check invoices for all years")
    public void tripsAndInvoicesIsEmptyTest() {
        loginWithCredential();
        MainbarNavigation mainbarNavigation = new MainbarNavigation(getDriver());
        TripsAndInvoicesPage tripsAndInvoicesPage = mainbarNavigation.clickTripsAndInvoice();
        Integer selectSize = tripsAndInvoicesPage.getNumberOfMonthSelectOptions();
        for (int i = 0; i < selectSize; i++) {
            tripsAndInvoicesPage.selectMonth(i);
            assertThat("Selected month not as expected", tripsAndInvoicesPage.getSelectedMonth(), is(tripsAndInvoicesPage.getSelectOptionText(i)));
            assertThat("Message not as expected", tripsAndInvoicesPage.getEmptyMonthMessage(), is(equalTo("Looks like you've not been on the road yet this month. Try a different month.")));
        }
    }
}
