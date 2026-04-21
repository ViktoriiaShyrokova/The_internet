package com.theinternet.pages.abTesting;

import com.theinternet.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AbTestingPage extends BasePage {

    public AbTestingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    WebElement header;

    public AbTestingPage verifyHeader(String text) {
        Assertions.assertTrue(getText(header).contains(text));
        return this;
    }

}
