package com.theinternet.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

@ExtendWith(TestResultLogger.class)
public class TestBase {


    @BeforeEach
    public void init() {
        String browser = System.getProperty("browser", "chrome");
        WebDriver localDriver; // создаем временную локальную переменную

        switch (browser) {
            case "firefox" -> localDriver = new FirefoxDriver();
            case "safari" -> localDriver = new SafariDriver();
            default -> localDriver = new ChromeDriver();
        }

        // Сохраняем в ThreadLocal
        DriverManager.setDriver(localDriver);

        // Используем драйвер из менеджера
        DriverManager.getDriver().get("https://the-internet.herokuapp.com/");
        DriverManager.getDriver().manage().window().maximize();
    }



    }
