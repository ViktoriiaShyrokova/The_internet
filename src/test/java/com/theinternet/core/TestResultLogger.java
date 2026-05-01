package com.theinternet.core;

import com.theinternet.utils.ScreenshotUtil;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestResultLogger implements TestWatcher {
    private static final Logger logger = LoggerFactory.getLogger(TestResultLogger.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        logger.error("TEST FAILED: {}", context.getDisplayName());

        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            // 1. Делаем скриншот, пока драйвер живой
            String path = ScreenshotUtil.take(driver);
            logger.error("Screenshot: {}", path);

            // 2. Закрываем браузер
            driver.quit();

            // 3. ОБЯЗАТЕЛЬНО чистим ThreadLocal для этого потока
            DriverManager.removeDriver();
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        logger.info("TEST PASSED: {}", context.getDisplayName());
        closeDriver();
    }

    private void closeDriver() {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
            DriverManager.removeDriver();
        }
    }
}