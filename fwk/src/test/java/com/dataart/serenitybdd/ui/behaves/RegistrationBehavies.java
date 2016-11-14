package com.dataart.serenitybdd.ui.behaves;


import com.dataart.serenitybdd.steps.RegistrationSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class RegistrationBehavies {

    @Steps
    RegistrationSteps registrationSteps;

    @When("user register a simple user")
    public void registerNewUser()
    {
        registrationSteps.registerNewUser();
    }


    @When ("user register a developer user")
    public void registerNewDev()
    {
        registrationSteps.registerNewDeveloper();
    }

}
