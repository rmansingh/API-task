package com.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends BasePage {

    @FindBy(className = "login")
    WebElement loginLink;

    public Homepage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Click on login link on home page")
    public LoginPage clickOnLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
        loginLink.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(System.getProperty("baseurl"))));
        return new LoginPage(driver);
    }

    public Homepage openHomePage() {
        driver.get(System.getProperty("baseurl"));
        return this;
    }
}
