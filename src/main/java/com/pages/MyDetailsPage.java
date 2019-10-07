package com.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.sun.activation.registries.LogSupport.log;

/**
 * @author Rupak Mansingh
 * this class captures the actions and elements of my details page
 */
public class MyDetailsPage extends BasePage {

    @FindBy(className = "c2g-mydetails-edit-personaldata")
    WebElement editNameAndAddress;

    @FindBy(xpath = "//*[@class='button js_button button--primary  when-is-unlocked']")
    WebElement saveButton;

    @FindBy(id = "addressStreet")
    WebElement streetAndHouseNumberInput;

    @FindBy(id = "addressZipCode")
    WebElement postalCodeInput;

    @FindBy(id = "addressCity")
    WebElement cityInput;

    @FindBy(id = "email")
    WebElement eMail;

    @FindBy(className = "main-loader")
    WebElement mainLoader;

    @FindBy(xpath = "//*[@id='name-address']/label[11]/p")
    WebElement eMailField;

    @FindBy(xpath = "//*[@id='name-address']/div[2]/label[1]/p")
    WebElement streetAndHouseNumberField;

    @FindBy(xpath = "//*[@id='name-address']/div[2]/label[3]/p")
    WebElement postalCodeField;

    @FindBy(xpath = "//*[@id='name-address']/div[2]/label[4]/p")
    WebElement cityField;

    public MyDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Edit name and address")
    public MyDetailsPage editNameAndAddress() {
        log("Edit name and address");
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.className("main-loader"))));
        waitForVisibilityOf(editNameAndAddress);
        editNameAndAddress.click();
        return this;
    }

    @Step("Click on save button")
    public MyDetailsPage clickSaveButton() {
        log("Click on save button");
        waitForVisibilityOf(saveButton);
        saveButton.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(mainLoader)));
        return this;
    }

    @Step("Edit address for street number, postal code, city")
    public MyDetailsPage editAddress(String streetNumber, String postalCode, String city) {
        waitForVisibilityOf(streetAndHouseNumberInput);
        streetAndHouseNumberInput.clear();
        streetAndHouseNumberInput.sendKeys(streetNumber);
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
        cityInput.clear();
        cityInput.sendKeys(city);
        return this;
    }

    @Step("Enter email address")
    public MyDetailsPage enterEmailAddress(String email) {
        waitForVisibilityOf(eMail);
        eMail.clear();
        eMail.sendKeys(email);
        return this;
    }

    public String getEmailAddress() {
        findElement(eMailField);
        return eMailField.getText();
    }

    public String getStreetAndHouseNumber() {
        findElement(streetAndHouseNumberField);
        return streetAndHouseNumberField.getText();
    }

    public String getPostalCode() {
        findElement(postalCodeField);
        return postalCodeField.getText();
    }

    public String getCity() {
        findElement(cityField);
        return cityField.getText();
    }
}
