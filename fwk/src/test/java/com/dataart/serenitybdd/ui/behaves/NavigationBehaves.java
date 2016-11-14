package com.dataart.serenitybdd.ui.behaves;

import com.dataart.serenitybdd.steps.NavigationSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class NavigationBehaves {

    @Steps
    NavigationSteps navigationSteps;

    @Given("user is on login page")
    @When("user is on login page")
    public void openLoginPage() {
        navigationSteps.opensTheLoginPage();
    }

    @When("user enter login '$username' and password '$password'")
    @Given("user enter login '$username' and password '$password'")
    public void loginWithUsernameAndPassword(String username, String password) {
        navigationSteps.enterTheUsernameAndPassword(username, password);
    }

    @Then("user see correct welcome message '$msg' on home page")
    public void isCorrectHomePage(String msg) {
        navigationSteps.seeWelcomePage(msg);
    }

    @Then("user see message '$msg'")
    public void isSeeMessageOnTheLoginPage(String msg) {
        navigationSteps.seeMessageOnTheLoginPage(msg);
    }

    @Given ("user opens user registration")
    public void openRegisterUser()
    {
        navigationSteps.opensTheRegisterUserPage();
    }

    @When ("user open js page")
    public void openJsPage() {
        navigationSteps.openJsPage();
    }

    @When ("user enter coordinates of div")
    public void enterCoordinatesOnJsPage() {
        navigationSteps.enterCoordinatesOnJsPage();
    }

    @Then ("user enter coordinates of div and wait for alert with text '$result'")
    public void enterCoordinatesOnJsPageAndWaitForAlert(String result){
        navigationSteps.enterCoordinatesOnJsPageAndWaitForAlert(result);
    }

    @Then ("user waiting alert with text '$result'")
    public void waitForAlertOnJsPage(String result) {
        navigationSteps.waitForAlertOnJsPage(result);
    }

    @When ("user open ajax page")
    public void openAjaxPage() {
        navigationSteps.openAjaxPage();
    }

    @When ("user enter to first field '$first' and to second field '$second'")
    public void enterValuesOnAjaxPage(String first, String second) {
        navigationSteps.enterValuesOnAjaxPage(first, second);
    }

    @Then ("user waiting for result text '$result'")
    public void waitForResultsOnAjaxPage(String result) {
        navigationSteps.waitForResultsOnAjaxPage(result);
    }

}
