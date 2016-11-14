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
    public void open_my_applications_page () {
        homePage.openMyApplications();
    }

    @Step
    public void open_new_applications_page () {
        myApplicationPage.openNewApplications();
    }

    @Step
    public void check_new_application_text (String title) {
        assertThat(newApplicationPage.getNewApplicationText(), is(title));
    }

    @Step
    public void is_my_app_link_exist (Boolean exist) {
        assertThat(homePage.myApplicationsLink.isCurrentlyVisible(), is(exist));
    }

    @Step
    public void create_new_application (Application app) {
        newApplicationPage.createNewApplication(app);
    }

    @Step
    public void validate_application_by_title (String title) {
        assertThat(homePage.getAppByTitle(title), is(true));
    }

    @Step
    public void open_application_details (String title) {
        homePage.openApplicationDetails(title);
    }

    @Step
    public void open_download_page () {
        myApplicationPage.openDownloadPage();
    }

    @Step
    public Application get_data_from_download_page () throws ParseException {
        return myApplicationPage.getDataFromApplicationDownloadPage();
    }

    @Step
    public void open_edit_application_page () {
        myApplicationPage.openEditApplicationPage();
    }

    @Step
    public void edit_application (Application app) {
        editApplicationPage.editApplication(app);
    }

    @Step
    public void open_my_popular_application_details (String title) {
        homePage.openMyPopularApplication(title);
    }

    @Step
    public void delete_application () {
        myApplicationPage.deleteApplicationPage(true);
    }

    @Step
    public void validate_that_application_removed_by_title (String title) {
        homePage.validateThatAppRemoved(title);
    }

}
