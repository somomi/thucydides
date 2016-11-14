package com.dataart.serenitybdd.pages;

import com.dataart.serenitybdd.models.Application;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class NewApplicationWebPage extends PageObject {

    @FindBy(xpath = "//div[@class='content']/h1")
    WebElementFacade newApplicationText;
    @FindBy(xpath = "//input[@name='title']")
    WebElementFacade titleTextField;
    @FindBy(xpath = "//textarea[@name='description']")
    WebElementFacade descriptionTextField;
    @FindBy(xpath = "//select[@name='category']")
    WebElementFacade categorySelectField;
    @FindBy(xpath = "//input[@name='image']")
    WebElementFacade createButton;
    @FindBy(xpath = "//input[@name='icon']")
    WebElementFacade imageButton;
    @FindBy(xpath = "//input[@type='submit']")
    WebElementFacade iconButton;

    public String getNewApplicationText () {
        return newApplicationText.getText();
    }

    public void createNewApplication (Application app) {
        titleTextField.type(app.getTitle());
        descriptionTextField.type(app.getDescription());
        categorySelectField.selectByVisibleText(app.getCategory());
        if (app.getImage() != null) {
            imageButton.sendKeys(app.getImage());
        }
        if (app.getIcon() != null) {
            iconButton.sendKeys(app.getIcon());
        }
        createButton.click();
    }

}
