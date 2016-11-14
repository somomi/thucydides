package com.dataart.serenitybdd.steps;


import com.dataart.serenitybdd.models.User;
import com.dataart.serenitybdd.models.UserBuilder;
import com.dataart.serenitybdd.pages.HomeWebPage;
import com.dataart.serenitybdd.pages.RegisterWebPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class RegistrationSteps extends ScenarioSteps {
    private User user;
    RegisterWebPage registerPage;
    HomeWebPage homeWebPage;


    @Step
    public void registerNewUser() {
        user = UserBuilder.getUser();
        registerPage.registerNewUser(user);
    }

    @Step
    public void registerNewDeveloper() {
        user = UserBuilder.getDeveloper();
        registerPage.registerNewUser(user);
    }

}
