package com.dataart.serenitybdd.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class AjaxWebPage extends PageObject {

    @FindBy(xpath = "//input[@id='x']")
    WebElement xInputField;
    @FindBy(xpath = "//input[@id='y']")
    WebElement yInputField;
    @FindBy(xpath = "//button[@id='calc']")
    WebElement sumButton;
    @FindBy(id = "clear")
    private WebElement clearButton;


    public void enterValuesAndPressSum (String X_INPUT, String Y_INPUT) {
        xInputField.clear();
        xInputField.sendKeys(X_INPUT);
        yInputField.clear();
        yInputField.sendKeys(Y_INPUT);
    }

    public void waitForResults (String result) {
        waitForTextToAppear(result, 30000);
    }


}
