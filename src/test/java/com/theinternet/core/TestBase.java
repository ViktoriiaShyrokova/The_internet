package com.theinternet.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {
    
    protected WebDriver driver;
    WebDriverWait wait;
    
    @BeforeEach
    public void init(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    
    @AfterEach
    @Disabled("Tests are not finished yet")
    public void tearDown(){
        if(driver != null) driver.quit();
    }
}
