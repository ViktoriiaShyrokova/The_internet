package com.theinternet.tests;

import com.theinternet.core.TestBase;
import com.theinternet.pages.HomePage;
import com.theinternet.pages.MultipeWindowsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultipleWindowsTests extends TestBase {

    @BeforeEach
    public void preconditions() {
        new HomePage().openMultipleWindows();
    }

    @Test
    public void multipleWindowsTest() {
        MultipeWindowsPage windowsPage = new MultipeWindowsPage();
        windowsPage.openNewWindow()
                .switchToNewWindow();
        Assertions.assertEquals("New Window", windowsPage.getHeader());
    }
}
