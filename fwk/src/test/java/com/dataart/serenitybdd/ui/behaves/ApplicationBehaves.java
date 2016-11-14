package com.dataart.serenitybdd.ui.behaves;


import com.dataart.serenitybdd.models.Application;
import com.dataart.serenitybdd.models.ApplicationBuilder;
import com.dataart.serenitybdd.steps.ApplicationSteps;
import com.dataart.serenitybdd.steps.NavigationSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.json.simple.parser.ParseException;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ApplicationBehaves {

    private Application appNewNoImages;
    private Application appEditNoImages;
    private Application appNewImages;
    private Application appNewPopular;
    private Application tempApp;

    @Steps
    ApplicationSteps applicationSteps;
    @Steps
    NavigationSteps navigationSteps;

    @When("user open my applications page")
    public void open_my_applications_page () {
        applicationSteps.open_my_applications_page();
    }

    @When ("user open new application page")
    public void open_new_application_page () {
        applicationSteps.open_new_applications_page();
    }

    @Then("user see text '$title'")
    public void should_see_new_application_text (String title) {
        applicationSteps.check_new_application_text(title);
    }

    @Then ("my application link should exist = '$exist'")
    public void is_my_app_link_exist (Boolean exist) {
        applicationSteps.is_my_app_link_exist(exist);
    }

    @When ("user create new application without images")
    public void create_new_application_without_images () {
        appNewNoImages = ApplicationBuilder.newAppNoImages();
        applicationSteps.open_new_applications_page();
        applicationSteps.create_new_application(appNewNoImages);
    }

    @Then ("user can see application '$title' on home page")
    public void see_application_by_title (String title) {
        navigationSteps.open_home_page();
        applicationSteps.validate_application_by_title(title);
    }

    @When ("user open application '$string' details")
    public void open_application_details (String title) {
        applicationSteps.open_application_details(title);
    }

    @When ("user download application")
    public void open_download_page () throws ParseException {
        applicationSteps.open_download_page();
        tempApp = applicationSteps.get_data_from_download_page();
    }

    @Then ("user see correct application with title '$title', description '$description', category '$category', downloads '$downloads'")
    public void validate_downloaded_application_data (String title, String description, String category, String downloads) {
        assertThat ("Application title matched", tempApp.getTitle(), is(title));
        assertThat ("Application description matched", tempApp.getDescription(), is(description));
        assertThat ("Application category matched", tempApp.getCategory(), is(category));
        if (!downloads.isEmpty()) {
            assertThat ("Application downloads matched", tempApp.getDownloads(), is(downloads));
        }
    }

    @When ("user open edit applications page")
    public void open_edit_applications_page () {
        applicationSteps.open_edit_application_page();
    }

    @When ("user edit application without images")
    public void edit_application_without_images () {
        appEditNoImages = ApplicationBuilder.editAppNoImages();
        applicationSteps.edit_application(appEditNoImages);
    }

    @When ("user create new application with images")
    public void create_new_application_with_images () {
        appNewImages = ApplicationBuilder.newAppWithImages();
        applicationSteps.open_new_applications_page();
        applicationSteps.create_new_application(appNewImages);
    }

    @When ("user create new popular application")
    public void create_new_application_popular () {
        appNewPopular = ApplicationBuilder.newPopularApp();
        applicationSteps.open_new_applications_page();
        applicationSteps.create_new_application(appNewPopular);
    }

    @When ("user download application '$app', '$num' times")
    public void download_app_n_times (String title, Integer num) throws ParseException {

        for(int x = 1; x < num; x = x+1) {
            navigationSteps.open_home_page();
            applicationSteps.open_application_details(title);
            applicationSteps.open_download_page();
            navigationSteps.opens_the_login_page ();
            navigationSteps.enter_the_username_and_password("admin", "admin");
        }
        applicationSteps.open_my_popular_application_details(title);
        applicationSteps.open_download_page();
        tempApp = applicationSteps.get_data_from_download_page();
    }

    @When ("user delete application '$app'")
    public void delete_application (String app) {
        applicationSteps.open_application_details(app);
        applicationSteps.delete_application();
    }

    @Then ("user can't see application '$title' on home page")
    public void not_see_application_by_title (String title) {
        navigationSteps.open_home_page();
        applicationSteps.validate_that_application_removed_by_title(title);
    }
}
