package com.dataart.serenitybdd.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.concurrent.TimeUnit;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class HomeWebPage extends PageObject {

    @FindBy(xpath = "//a[@href='/my']")
    public WebElementFacade myApplicationsLink;
    @FindBy(xpath = "//a[@href='/js/']")
    WebElementFacade jsPageLink;
    @FindBy(xpath = "//a[@href='/calc/']")
    WebElementFacade ajaxPageLink;
    @FindBy(xpath = "//a[@href='/']")
    WebElementFacade homePageLink;
    @FindBy(xpath = "//div[@class='header']/div[@class='welcome']")
    WebElementFacade welcomeText;

    public String getWelcomeMessage() {
     return welcomeText.getText();
    }

    public void openMyApplications () {
        myApplicationsLink.click();
    }

    public void openMyPopularApplication (String title) {
        element(By.xpath((String.format("//div[@class='popular-app']/a[@href='/app?title=%s']", title)))).click();
    }


    public void openApplicationDetails (String title) {
        element (By.xpath((String.format("//a[@href='/app?title=%s']", title)))).click();
    }

    public Boolean getAppByTitle (String title) {
        return element (By.xpath((String.format("//a[@href='/app?title=%s']", title)))).isCurrentlyVisible();
    }

    public void validateThatAppRemoved (String title) {
        setImplicitTimeout(1, TimeUnit.MILLISECONDS);
        shouldNotBeVisible(By.xpath(String.format("//a[@href='/app?title=%s']", title)));
        resetImplicitTimeout();
     }

    public void openJSPage () {
        jsPageLink.click();
    }

    public void openAjaxPage () {
        ajaxPageLink.click();
    }

    public void openHomePage () {
        homePageLink.click();
    }


}
