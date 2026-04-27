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
    public void testSuccessful(ExtensionContext context) {
        logger.info("TEST PASSED: {}", context.getDisplayName());
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
            DriverManager.removeDriver();
        }
        logger.info("=".repeat(50));
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        logger.error("TEST FAILED: {}", context.getDisplayName());
        logger.error("Reason: {}", cause.toString());

        WebDriver driver = DriverManager.getDriver();

        if (driver != null) {
            try {
                String screenshotPath = ScreenshotUtil.take(driver);
                logger.error("Screenshot saved: {}", screenshotPath);
            } catch (Exception e) {
                logger.error("Screenshot failed: {}", e.getMessage());
            } finally {
                driver.quit();
                DriverManager.removeDriver();
            }
        }

        logger.info("=".repeat(50));
    }
}
