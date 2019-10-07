package com.pages.globalelements;

import com.pages.BasePage;
import com.pages.Homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MetabarNavigation extends BasePage {

    @FindBy(className = "login")
    WebElement logoutButton;

    @FindBy(className = "metabar-languages")
    WebElement languages;

    @FindBy(className = "hello-information")
    WebElement message;

    public MetabarNavigation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Homepage clickLogoutButton() {
       logoutButton.click();
        return new Homepage(driver);
    }

    public void selectLanguage(Integer index) {
        wait.until(ExpectedConditions.elementToBeClickable(languages));
        languages.findElement(By.tagName("li")).click();
    }

    public String getHelloMessage() {
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getText();
    }


}
