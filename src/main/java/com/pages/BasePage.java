package com.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 50);
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForVisibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> visibilityOfAllElements(List<WebElement>  element) {
        return wait.withTimeout(Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    @Step("Find element: {element}")
    protected WebElement findElement(WebElement element) {
        return this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Step("Find element {element}")
    protected WebElement findElement(WebElement element, int timeOutInSeconds) {
        return (new WebDriverWait(this.driver, (long) timeOutInSeconds, 50L)).withMessage(String.format("Timed out waiting for: %s", element.toString())).until(ExpectedConditions.visibilityOf(element));
    }

    @Step("Is element visible {element}")
    protected boolean isElementVisible(WebElement element, int timeOutInSeconds) {
        try {
            this.findElement(element, timeOutInSeconds);
            return true;
        } catch (WebDriverException var1) {
            return false;
        }
    }
}