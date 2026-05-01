package com.theinternet.tests;

import com.theinternet.core.TestBase;
import com.theinternet.pages.AddRemoveElementsPage;
import com.theinternet.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddRemoveElementsTests extends TestBase {
    @BeforeEach
    public void preconditions() {
        new HomePage().getAddRemoveElements();
    }

    @Test
    public void addNewElementTest() {
        AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage();
        addRemovePage.addNewElement();
        Assertions.assertTrue(addRemovePage.isNewElementAdded());
    }

    @Test
    public void removeElementTest() {
        AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage();
        addRemovePage.addNewElement()
                .removeElement();
        Assertions.assertTrue(addRemovePage.isElementRemoved());
    }

}
