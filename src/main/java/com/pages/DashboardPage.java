package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    @FindBy(className = "hub-icon-address")
    WebElement adressDataIcon;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean addressDataIsDisplayed() {
        wait.until(ExpectedConditions.urlContains("dashboard.html"));
        return adressDataIcon.isDisplayed();
    }
}
