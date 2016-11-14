package com.dataart.serenitybdd.steps;

import com.dataart.serenitybdd.models.User;
import com.dataart.serenitybdd.pages.AjaxWebPage;
import com.dataart.serenitybdd.pages.HomeWebPage;
import com.dataart.serenitybdd.pages.JSWebPage;
import com.dataart.serenitybdd.pages.LoginWebPage;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.dataart.serenitybdd.models.UserBuilder.admin;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class NavigationSteps extends ScenarioSteps {

    private User user;
    LoginWebPage loginPage;
    HomeWebPage homePage;
    AjaxWebPage ajaxPage;
    JSWebPage jsPage;

    @Step
    public void logoutFromApp() {
        loginPage.logoutFromHomePage();
    }

    @Step
    public void opensTheLoginPage() {
        loginPage.openLoginPage();
        loginPage.logoutFromHomePage();
    }

    @Step
    @Screenshots(onlyOnFailures=true)
    public void enterTheUsernameAndPassword(String username, String password) {
        user = admin();
        user.setUsername(username);
        user.setPassword(password);
        loginPage.loginAs(user);
    }

    @Step
    public void seeWelcomePage(String msg) {
        assertThat(homePage.getWelcomeMessage(), is(msg));
    }

    @Step
    public void seeMessageOnTheLoginPage(String msg) {
        loginPage.waitForMessage(msg);
    }

    @Step
    public void opensTheRegisterUserPage() {
        loginPage.registerNewUserLink();
    }

    @Step
    public void openHomePage() {
        homePage.openHomePage();
    }

    @Step
    public void openJsPage() {
        homePage.openJSPage();
    }

    @Step
    public void enterCoordinatesOnJsPage() {
        jsPage.enterCoordinates(jsPage.getTopCoordinates(), jsPage.getLeftCoordinates());
    }

    @Step
    public void waitForAlertOnJsPage(String result) {
        assertThat(jsPage.getAlertMessage(), is(result));
    }

    @Step
    public void openAjaxPage() {
        homePage.openAjaxPage();
    }

    @Step
    public void enterValuesOnAjaxPage(String first, String second) {
        ajaxPage.enterValuesAndPressSum(first, second);
    }

    @Step
    public void waitForResultsOnAjaxPage(String result) {
        ajaxPage.waitForResults (result);
    }

    public void enterCoordinatesOnJsPageAndWaitForAlert(String result) {
        String alert = jsPage.enterCoordinatesAndWaitForAlert(jsPage.getTopCoordinates(), jsPage.getLeftCoordinates());
        assertThat(result, is(alert));
    }
}
