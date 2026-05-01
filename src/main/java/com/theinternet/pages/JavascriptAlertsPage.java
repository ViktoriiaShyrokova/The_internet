package com.theinternet.pages;

import com.theinternet.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavascriptAlertsPage extends BasePage {
    public JavascriptAlertsPage() {
        super();
    }

    @FindBy(xpath = "//button[.='Click for JS Alert']")
    WebElement jsAlertButton;
    @FindBy(xpath = "//button[.='Click for JS Confirm']")
    WebElement jsConfirmAlertButton;
    @FindBy(xpath = "//button[.='Click for JS Prompt']")
    WebElement jsPromptAlertButton;
    @FindBy(id = "result")
    WebElement confirmAlertResult;

    public JavascriptAlertsPage openSimpleAlert() {
        click(jsAlertButton);
        return this;
    }

    public JavascriptAlertsPage openConfirmAlert() {
        click(jsConfirmAlertButton);
        return this;
    }
    public JavascriptAlertsPage openPromptAlert() {
        click(jsPromptAlertButton);
        return this;
    }

    public String getResultText() {
       return getText(confirmAlertResult);
    }

//    public JavascriptAlertsPage typeToAlert() {
//
//        return this;
//    }
}
