package com.theinternet.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    
    protected WebDriver driver;
    
    @BeforeEach
    public void init(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }
    
    @AfterEach
    @Disabled("Tests are not finished yet")
    public void tearDown(){
        if(driver != null) driver.quit();
    }
}
