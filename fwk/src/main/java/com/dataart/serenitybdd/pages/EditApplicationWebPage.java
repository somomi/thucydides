package com.dataart.serenitybdd.pages;


import com.dataart.serenitybdd.models.Application;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class EditApplicationWebPage extends PageObject {

    @FindBy(xpath = "//textarea[@name='description']")
    WebElementFacade descriptionTextField;
    @FindBy(xpath = "//textarea[@name='description']")
    WebElementFacade categorySelectField;
    @FindBy(xpath = "//textarea[@name='description']")
    WebElementFacade updateButton;


    public void editApplication (Application app) {

        descriptionTextField.type(app.getDescription());
        categorySelectField.selectByVisibleText(app.getCategory());
        updateButton.click();
    }

}
