package com.dataart.serenitybdd.ui.behaves;


import com.dataart.serenitybdd.models.Application;
import com.dataart.serenitybdd.steps.RegistrationSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class RegistrationBehavies {
    private Application appNewNoImages;
    private Application appEditNoImages;
    private Application appNewImages;
    private Application appNewPopular;
    private Application tempApp;

    @Steps
    RegistrationSteps registrationSteps;

    @When("user register a simple user")
    public void register_new_user ()
    {

        registrationSteps.register_new_user();
    }

    @When ("user register a developer user")
    public void register_new_dev ()
    {
        registrationSteps.register_new_dev();
    }

}