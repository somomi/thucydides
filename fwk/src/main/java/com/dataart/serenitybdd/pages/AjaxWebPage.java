package com.dataart.serenitybdd.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class AjaxWebPage extends PageObject {

    @FindBy(id = "x")
    WebElement xInputField;
    @FindBy(id = "y")
    WebElement yInputField;
    @FindBy(id = "r")
    private WebElement resultPlaceholder;
    @FindBy(id = "calc")
    WebElement sumButton;
    @FindBy(id = "clear")
    private WebElement clearButton;


    public void enterValuesAndPressSum (String X_INPUT, String Y_INPUT) {
        xInputField.clear();
        xInputField.sendKeys(X_INPUT);
        yInputField.clear();
        yInputField.sendKeys(Y_INPUT);
        sumButton.click();
    }

    public void waitForResults (final String Result) {
        WebDriver driver = new ChromeDriver();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wD) {
                return resultPlaceholder.getText().trim().matches(Result);
            }
        });
        driver.quit();
    }

}
