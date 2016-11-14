package com.dataart.serenitybdd.pages;

import com.dataart.serenitybdd.models.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class RegisterWebPage extends PageObject {

    @FindBy(xpath = "//input[@name='name']")
    WebElementFacade userNameTextField;
    @FindBy(xpath = "//input[@name='fname']")
    WebElementFacade firstNameTextField;
    @FindBy(xpath = "//input[@name='lname']")
    WebElementFacade lastNameTextField;
    @FindBy(xpath = "//input[@name='password']")
    WebElementFacade passwordTextField;
    @FindBy(xpath = "//input[@name='passwordConfirm']")
    WebElementFacade confirmPasswordTextField;
    @FindBy(xpath = "//select[@name='role']")
    WebElementFacade roleBoxField;
    @FindBy(xpath = "//input[@type='submit']")
    WebElementFacade registerButton;

    public void registerNewUser (User user) {
        userNameTextField.sendKeys(user.getUsername());
        firstNameTextField.sendKeys(user.getFname());
        lastNameTextField.sendKeys(user.getLname());
        passwordTextField.sendKeys(user.getPassword());
        confirmPasswordTextField.sendKeys(user.getPassword());
        roleBoxField.sendKeys (user.getRole());
        registerButton.click();
    }

}
