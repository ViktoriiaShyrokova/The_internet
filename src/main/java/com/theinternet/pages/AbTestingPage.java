package com.theinternet.pages;

import com.theinternet.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbTestingPage extends BasePage {
    public AbTestingPage() {
        super();
    }

    @FindBy(tagName = "h3")
    WebElement header;

    public AbTestingPage verifyHeader(String text) {
        Assertions.assertTrue(getText(header).contains(text));
        return this;
    }

}
