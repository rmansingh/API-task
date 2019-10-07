package com.pages.globalelements;

import com.pages.BasePage;
import com.pages.MyDetailsPage;
import com.pages.TripsAndInvoicesPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.sun.activation.registries.LogSupport.log;

public class MainbarNavigation extends BasePage {

    @FindBy(className = "c2g-trips-invoices")
    WebElement tripsAndInvoice;

    @FindBy(xpath = "//*[@title='My Details']")
    WebElement myDetailsLink;

    @FindBy(className = "change")
    WebElement shareNowIcon;

    public MainbarNavigation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Click on trips and invoice tab")
    public TripsAndInvoicesPage clickTripsAndInvoice() {
        log("Click on trips and invoice tab");
        tripsAndInvoice.click();
        return new TripsAndInvoicesPage(driver);
    }

    @Step("Click on my details tab")
    public MyDetailsPage openMyDetailsLink() {
        log("Click on my details tab");
        wait.until(ExpectedConditions.elementToBeClickable(myDetailsLink));
        myDetailsLink.click();
        return new MyDetailsPage(driver);
    }
}
