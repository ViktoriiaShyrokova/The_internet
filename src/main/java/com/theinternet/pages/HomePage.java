package com.theinternet.pages;

import com.theinternet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage() {
        super();
    }

    @FindBy(css = "a[href='/abtest']")
    WebElement abTestLink;
    @FindBy(css = "a[href='/add_remove_elements/']")
    WebElement addRemoveElements;
    @FindBy(css = "a[href='/basic_auth']")
    WebElement basicAuth;
    @FindBy(css = "a[href='/frames']")
    WebElement frames;
    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement javascriptAlerts;
    @FindBy(css = "a[href='/windows']")
    WebElement windows;

    public AbTestingPage getAbTesting() {
        click(abTestLink);
        return new AbTestingPage();
    }


    public JavascriptAlertsPage openJavascriptAlerts() {
        click(javascriptAlerts);
        return new JavascriptAlertsPage();
    }


    public MultipeWindowsPage openMultipleWindows() {
        click(windows);
        return new MultipeWindowsPage();
    }

    public FramesPage openFramesPage() {
        click(frames);
        return new FramesPage();
    }

    public AddRemoveElementsPage getAddRemoveElements() {
        click(addRemoveElements);
        return new AddRemoveElementsPage();
    }

    public BasicAuthPage openBasicAuth() {
        click(basicAuth);
        return new BasicAuthPage();
    }
}
