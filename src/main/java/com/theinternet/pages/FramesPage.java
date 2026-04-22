package com.theinternet.pages;

import com.theinternet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/nested_frames']")
    WebElement nestedFrames;
    @FindBy(css = "a[href='/iframe']")
    WebElement iframe;
    @FindBy(css = "frame[name='frame-top']")
    WebElement topFrame;
    @FindBy(xpath = "//frameset[@name='frameset-middle']//frame")
    List<WebElement> frameset;
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
        driver.switchTo().defaultContent();
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(frameName);
        return this;
    }
    public FramesPage switchToFrame(String frameName) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameName);
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
        driver.switchTo().frame(iframeElem);
        return this;
    }
}
