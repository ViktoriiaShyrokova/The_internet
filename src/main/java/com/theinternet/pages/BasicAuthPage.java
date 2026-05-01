package com.theinternet.pages;

import com.theinternet.core.BasePage;
import com.theinternet.core.DriverManager;

public class BasicAuthPage extends BasePage {

    public BasicAuthPage() {
        super();
    }
    public BasicAuthPage fillInAuthForm() {
        DriverManager.getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        return this;
    }


    public boolean isSuccessMessageDisplayed() {
        return DriverManager.getDriver().getPageSource()
                .contains("Congratulations! You must have the proper credentials.");

    }
}
