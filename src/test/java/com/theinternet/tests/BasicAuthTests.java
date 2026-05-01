package com.theinternet.tests;

import com.theinternet.core.TestBase;
import com.theinternet.pages.BasicAuthPage;
import com.theinternet.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicAuthTests extends TestBase {

    @BeforeEach
    public void preconditions() {
        new HomePage().openBasicAuth();
    }

    @Test
    public void userLoginWithValidCredentialsTest() {
        BasicAuthPage authPage = new BasicAuthPage();
        authPage.fillInAuthForm();
        Assertions.assertTrue(authPage.isSuccessMessageDisplayed());
    }
}
