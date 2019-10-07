package com.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Rupak Mansingh
 * this class captures the actions and elements of registration page
 */
public class LoginPage extends BasePage {

    @FindBy(name = "username")
    WebElement userNameInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(name = "login")
    WebElement loginButton;

    @FindBy(id = "c2g_messageContainer")
    WebElement messageContainer;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Enter user name and password, click on login button")
    public DashboardPage loginWithCredential(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        loginButton.click();
        return new DashboardPage(driver);
    }

    @Step("Click login button")
    public DashboardPage clickLoginButton() {
        loginButton.click();
        return new DashboardPage(driver);
    }

    @Step("Enter user name")
    public LoginPage enterUserName(String userName) {
        userNameInput.sendKeys(userName);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public String getErrorMessageText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginErrorMessage")));
        return messageContainer.getText();
    }
}