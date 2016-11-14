package com.dataart.serenitybdd.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class JSWebPage extends PageObject {

    @FindBy(xpath = "//input[@id='top']")
    WebElementFacade topInput;
    @FindBy(xpath = "//input[@id='left']")
    WebElementFacade leftInput;
    @FindBy(xpath = "//button[@id='process']")
    WebElementFacade processButton;


    private Long top;
    private Long left;

    public void enterCoordinates(Integer top, Integer left) {
        topInput.sendKeys (Integer.toString (top));
        leftInput.sendKeys (Integer.toString (left));
        processButton.click();
    }


    public String getAlertMessage() {
        Alert alert = getDriver().switchTo().alert();
        String AlertText = alert.getText();
        alert.accept();
        return AlertText;
    }


    public Integer getTopCoordinates () {
        top = Math.round((Double) evaluateJavascript("return $('.flash').position().top"));
        return top.intValue();
    }

    public Integer getLeftCoordinates () {
        left = Math.round((Double) evaluateJavascript("return $('.flash').position().left"));
        return left.intValue();
    }


    public String enterCoordinatesAndWaitForAlert(Integer top, Integer left) {
        topInput.sendKeys (Integer.toString (top));
        leftInput.sendKeys (Integer.toString (left));
        processButton.click();
        Alert alert = getDriver().switchTo().alert();
        String AlertText = alert.getText();
        alert.accept();
        return AlertText;
    }
}
