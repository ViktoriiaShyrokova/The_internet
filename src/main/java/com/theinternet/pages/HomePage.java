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
    public AbTestingPage getAbTesting() {
        click(abTestLink);
        return new AbTestingPage(driver);
    }
    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement javascriptAlerts;
    public JavascriptAlertsPage openJavascriptAlerts() {
        click(javascriptAlerts);
        return new JavascriptAlertsPage(driver);
    }
}
