package com.theinternet.pages;

import com.theinternet.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

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
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new MultipeWindowsPage(driver);
    }

    public String getHeader() {
       return getText(header);
    }
}
