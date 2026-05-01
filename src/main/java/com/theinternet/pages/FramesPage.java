package com.theinternet.pages;

import com.theinternet.core.BasePage;
import com.theinternet.core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FramesPage extends BasePage {
    public FramesPage() {
        super();
    }

    @FindBy(css = "a[href='/nested_frames']")
    WebElement nestedFrames;
    @FindBy(css = "a[href='/iframe']")
    WebElement iframe;
    @FindBy(css = "frame[name='frame-top']")
    WebElement topFrame;
    @FindBy(css = "body")
    WebElement body;
    @FindBy(css = "div[role='alert'] .tox-icon")
    WebElement closeAlert;
    @FindBy(id = "mce_0_ifr")
    WebElement iframeElem;

    public FramesPage openNestedFrames() {
        click(nestedFrames);
        return this;
    }

    public FramesPage switchToNestedFrame(String frameName) {
        DriverManager.getDriver().switchTo().defaultContent();
        DriverManager.getDriver().switchTo().frame(topFrame);
        DriverManager.getDriver().switchTo().frame(frameName);
        return this;
    }
    public FramesPage switchToFrame(String frameName) {
        DriverManager.getDriver().switchTo().defaultContent();
        DriverManager.getDriver().switchTo().frame(frameName);
        return this;
    }

    public String getFrameTitle() {
       return getText(body);
    }

    public FramesPage openIframes() {
        click(iframe);
        return this;
    }
    public FramesPage closeAlert() {
        click(closeAlert);
        return this;
    }
    public FramesPage switchToIframe() {
        DriverManager.getDriver().switchTo().frame(iframeElem);
        return this;
    }
}
