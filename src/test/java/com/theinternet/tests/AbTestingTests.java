package com.theinternet.tests;

import com.theinternet.core.TestBase;
import com.theinternet.pages.HomePage;
import com.theinternet.pages.abTesting.AbTestingPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AbTestingTests extends TestBase {

    @BeforeEach
    public void preconditions(){
        new HomePage(driver).getAbTesting();
    }

    @Test
    public void abTestingTest(){
        new AbTestingPage(driver).verifyHeader("A/B");
    }

}
