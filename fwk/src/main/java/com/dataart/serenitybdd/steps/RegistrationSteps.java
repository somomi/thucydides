package com.dataart.serenitybdd.steps;


import com.dataart.serenitybdd.models.User;
import com.dataart.serenitybdd.pages.RegisterWebPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.dataart.serenitybdd.models.UserBuilder.getDeveloper;
import static com.dataart.serenitybdd.models.UserBuilder.getUser;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class RegistrationSteps extends ScenarioSteps {
    private User user;
    RegisterWebPage registerPage;


    @Step
    public void register_new_user () {
        user = getUser();
        registerPage.registerNewUser(user);
    }

    @Step
    public void register_new_dev () {
        user = getDeveloper();
        registerPage.registerNewUser(user);
    }

}
