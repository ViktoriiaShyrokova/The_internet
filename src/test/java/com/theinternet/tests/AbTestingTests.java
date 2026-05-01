package com.theinternet.tests;

import com.theinternet.core.TestBase;
import com.theinternet.pages.HomePage;
import com.theinternet.pages.AbTestingPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AbTestingTests extends TestBase {

    @BeforeEach
    public void preconditions(){
        new HomePage().getAbTesting();
    }

    @Test
    public void abTestingTest(){
        new AbTestingPage().verifyHeader("A/B");
    }

}
