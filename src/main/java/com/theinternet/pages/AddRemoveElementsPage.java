package com.theinternet.pages;

import com.theinternet.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {
    public AddRemoveElementsPage() {
        super();
    }

    @FindBy(xpath = "//button[.='Add Element']")
    WebElement addButton;
    @FindBy(css = ".added-manually")
    WebElement removeButton;
    @FindBy(css = "#elements button")
    List<WebElement> elements;

    public AddRemoveElementsPage addNewElement() {
        click(addButton);
        return this;
    }

    public boolean isNewElementAdded() {
        boolean isAdded = isElementShown(removeButton);
        click(removeButton);
        return isAdded;
    }

    public boolean isElementRemoved() {
        return elements.isEmpty();
    }

    public AddRemoveElementsPage removeElement() {
        click(removeButton);
        return this;
    }
}
