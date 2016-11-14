package com.dataart.serenitybdd.steps;


import com.dataart.serenitybdd.pages.EditApplicationWebPage;
import com.dataart.serenitybdd.pages.HomeWebPage;
import com.dataart.serenitybdd.pages.MyApplicationWebPage;
import com.dataart.serenitybdd.pages.NewApplicationWebPage;
import com.dataart.serenitybdd.models.Application;
import com.dataart.serenitybdd.pages.EditApplicationWebPage;
import com.dataart.serenitybdd.pages.HomeWebPage;
import com.dataart.serenitybdd.pages.MyApplicationWebPage;
import com.dataart.serenitybdd.pages.NewApplicationWebPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.json.simple.parser.ParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class ApplicationSteps extends ScenarioSteps {

    HomeWebPage homePage;
    MyApplicationWebPage myApplicationPage;
    NewApplicationWebPage newApplicationPage;
    EditApplicationWebPage editApplicationPage;

    @Step
    public void openMyApplicationsPage() {
        homePage.openMyApplications();
    }

    @Step
    public void openNewApplicationsPage() {
        myApplicationPage.openNewApplications();
    }

    @Step
    public void checkNewApplicationText(String title) {
        assertThat(newApplicationPage.getNewApplicationText(), is(title));
    }

    @Step
    public void isMyAppLinkExist(Boolean exist) {
        assertThat(homePage.myApplicationsLink.isCurrentlyVisible(), is(exist));
    }

    @Step
    public void createNewApplication(Application app) {
        newApplicationPage.createNewApplication(app);
    }

    @Step
    public void validateApplicationByTitle(String title) {
        assertThat(homePage.getAppByTitle(title), is(true));
    }

    @Step
    public void openApplicationDetails(String title) {
        homePage.openApplicationDetails(title);
    }

    @Step
    public void openDownloadPage() {
        myApplicationPage.openDownloadPage();
    }

    @Step
    public Application getDataFromDownloadPage() throws ParseException {
        return myApplicationPage.getDataFromApplicationDownloadPage();
    }

    @Step
    public void openEditApplicationPage() {
        myApplicationPage.openEditApplicationPage();
    }

    @Step
    public void editApplication(Application app) {
        editApplicationPage.editApplication(app);
    }

    @Step
    public void openMyPopularApplicationDetails(String title) {
        homePage.openMyPopularApplication(title);
    }

    @Step
    public void deleteApplication() {
        myApplicationPage.deleteApplicationPage(true);
    }

    @Step
    public void validateThatApplicationRemovedByTitle(String title) {
        homePage.validateThatAppRemoved(title);
    }

}
