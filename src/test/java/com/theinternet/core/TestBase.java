package com.theinternet.core;

import com.theinternet.utils.ScreenshotUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

@ExtendWith(TestResultLogger.class)
public class TestBase {

    protected WebDriver driver;
    protected boolean testFailed;

    @BeforeEach
    public void init() {

        String browser = System.getProperty("browser", "chrome");

        switch (browser) {
            case "firefox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            default -> driver = new ChromeDriver();
        }

        DriverManager.setDriver(driver);

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }



    }
