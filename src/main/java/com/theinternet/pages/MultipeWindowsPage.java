package com.theinternet.pages;

import com.theinternet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipeWindowsPage extends BasePage {

    public MultipeWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href$='/windows/new']")
    WebElement newWindow;
    @FindBy(css = "h3")
    WebElement header;

    public MultipeWindowsPage openNewWindow() {
        click(newWindow);
        return new MultipeWindowsPage(driver);
    }
    public MultipeWindowsPage switchToNewWindow() {
        waitForNumberOfWindows(2);
        switchToWindow(1);
        return new MultipeWindowsPage(driver);
    }

    public String getHeader() {
       return getText(header);
    }
}
