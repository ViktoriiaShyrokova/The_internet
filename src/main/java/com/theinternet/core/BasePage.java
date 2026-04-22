package com.theinternet.core;

import com.theinternet.pages.JavascriptAlertsPage;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void type(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public String getAlertText() {
        waitAlert();
        return driver.switchTo().alert().getText();
    }

    private void waitAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waitAlert();
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        waitAlert();
        driver.switchTo().alert().dismiss();
    }
    public void typeToAlert(String text) {
        waitAlert();
        driver.switchTo().alert().sendKeys(text);
    }
}
