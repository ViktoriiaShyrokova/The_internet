package com.theinternet.utils;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String take(WebDriver driver){
        File dir = new File("screenshots");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen-"
                + System.currentTimeMillis()
                + ".png");
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }
}
