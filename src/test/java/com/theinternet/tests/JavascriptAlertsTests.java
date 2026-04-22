package com.theinternet.tests;

import com.theinternet.core.TestBase;
import com.theinternet.pages.HomePage;
import com.theinternet.pages.JavascriptAlertsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JavascriptAlertsTests extends TestBase {

    @BeforeEach
    public void preconditions() {
        new HomePage(driver).openJavascriptAlerts();

    }

    @Test
    public void simpleAlertTest() {
        JavascriptAlertsPage alertsPage = new JavascriptAlertsPage(driver);
        alertsPage.openSimpleAlert();
        Assertions.assertEquals("I am a JS Alert", alertsPage.getAlertText());
        alertsPage.acceptAlert();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ok", "Cancel"})
    public void confirmAlertTest(String action) {
        JavascriptAlertsPage alertsPage = new JavascriptAlertsPage(driver);
        alertsPage.openConfirmAlert();
        Assertions.assertEquals("I am a JS Confirm", alertsPage.getAlertText());

        if ("Ok".equals(action)) {
            alertsPage.acceptAlert();
        } else {
            alertsPage.dismissAlert();
        }
        Assertions.assertEquals("You clicked: " + action,
                alertsPage.getResultText());

    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello"})
    public void promptAlertTest(String input) {
        JavascriptAlertsPage alertsPage = new JavascriptAlertsPage(driver);
        alertsPage.openPromptAlert();
        Assertions.assertEquals("I am a JS prompt", alertsPage.getAlertText());
        alertsPage.typeToAlert(input);
        alertsPage.acceptAlert();
        Assertions.assertEquals("You entered: " + input, alertsPage.getResultText());
    }
}

