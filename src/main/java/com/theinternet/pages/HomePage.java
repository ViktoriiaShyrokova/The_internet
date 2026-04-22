package com.theinternet.pages;

import com.theinternet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/abtest']")
    WebElement abTestLink;
    @FindBy(css = "a[href='/frames']")
    WebElement frames;
    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement javascriptAlerts;
    @FindBy(css = "a[href='/windows']")
    WebElement windows;

    public AbTestingPage getAbTesting() {
        click(abTestLink);
        return new AbTestingPage(driver);
    }


    public JavascriptAlertsPage openJavascriptAlerts() {
        click(javascriptAlerts);
        return new JavascriptAlertsPage(driver);
    }


    public MultipeWindowsPage openMultipleWindows() {
        click(windows);
        return new MultipeWindowsPage(driver);
    }

    public FramesPage openFramesPage() {
        click(frames);
        return new FramesPage(driver);
    }
}
