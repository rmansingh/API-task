package com.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Rupak Mansingh
 * this class captures the actions and elements of trips and invoice page
 */
public class TripsAndInvoicesPage extends BasePage {

    @FindBy(xpath = "//*[@class='message']")
    WebElement message;

    @FindBy(tagName = "select")
    WebElement monthSelect;

    @FindBy(tagName = "option")
    WebElement selectOption;

    @FindBy(className = "selected-item")
    WebElement selectedMonth;

    public TripsAndInvoicesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Select month from the dropdown")
    public TripsAndInvoicesPage selectMonth(Integer monthIndex) {
        Select monthSelect = new Select(this.monthSelect);
        this.monthSelect.click();
        monthSelect.selectByIndex(monthIndex);
        return this;
    }

    public Integer getNumberOfMonthSelectOptions() {
        waitForVisibilityOf(selectOption);
        return driver.findElements(By.tagName("option")).size();
    }

    public String getEmptyMonthMessage() {
        waitForVisibilityOf(message);
        return message.getText();
    }

    public String getSelectedMonth() {
        return selectedMonth.getText();
    }

    public String getSelectOptionText(Integer index) {
        return monthSelect.findElements(By.tagName("option")).get(index).getText();
    }
}