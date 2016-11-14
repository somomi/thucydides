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
    public void openMyApplicationsPage() {
        applicationSteps.openMyApplicationsPage();
    }

    @When ("user open new application page")
    public void openNewApplicationPage() {
        applicationSteps.openNewApplicationsPage();
    }

    @Then("user see text '$title'")
    public void shouldSeeNewApplicationText(String title) {
        applicationSteps.checkNewApplicationText(title);
    }

    @Then ("my application link should exist = '$exist'")
    public void isMyAppLinkExist(Boolean exist) {
        applicationSteps.isMyAppLinkExist(exist);
    }

    @When ("user create new application without images")
    public void createNewApplicationWithoutImages() {
        appNewNoImages = ApplicationBuilder.newAppNoImages();
        applicationSteps.openNewApplicationsPage();
        applicationSteps.createNewApplication(appNewNoImages);
    }

    @Then ("user can see application '$title' on home page")
    public void seeApplicationByTitle(String title) {
        navigationSteps.openHomePage();
        applicationSteps.validateApplicationByTitle(title);
    }

    @When ("user open application '$string' details")
    public void openApplicationDetails(String title) {
        applicationSteps.openApplicationDetails(title);
    }

    @When ("user download application")
    public void openDownloadPage() throws ParseException {
        applicationSteps.openDownloadPage();
        tempApp = applicationSteps.getDataFromDownloadPage();
    }

    @Then ("user see correct application with title '$title', description '$description', category '$category', downloads '$downloads'")
    public void validateDownloadedApplicationData(String title, String description, String category, String downloads) {
        assertThat ("Application title matched", tempApp.getTitle(), is(title));
        assertThat ("Application description matched", tempApp.getDescription(), is(description));
        assertThat ("Application category matched", tempApp.getCategory(), is(category));
        if (!downloads.isEmpty()) {
            assertThat ("Application downloads matched", tempApp.getDownloads(), is(downloads));
        }
    }

    @When ("user open edit applications page")
    public void openEditApplicationsPage() {
        applicationSteps.openEditApplicationPage();
    }

    @When ("user edit application without images")
    public void editApplicationWithoutImages() {
        appEditNoImages = ApplicationBuilder.editAppNoImages();
        applicationSteps.editApplication(appEditNoImages);
    }

    @When ("user create new application with images")
    public void createNewApplicationWithImages() {
        appNewImages = ApplicationBuilder.newAppWithImages();
        applicationSteps.openNewApplicationsPage();
        applicationSteps.createNewApplication(appNewImages);
    }

    @When ("user create new popular application")
    public void createNewApplicationPopular() {
        appNewPopular = ApplicationBuilder.newPopularApp();
        applicationSteps.openNewApplicationsPage();
        applicationSteps.createNewApplication(appNewPopular);
    }

    @When ("user download application '$app', '$num' times")
    public void downloadAppNTimes(String title, Integer num) throws ParseException {

        for(int x = 1; x < num; x = x+1) {
            navigationSteps.openHomePage();
            applicationSteps.openApplicationDetails(title);
            applicationSteps.openDownloadPage();
            navigationSteps.opensTheLoginPage();
            navigationSteps.enterTheUsernameAndPassword("admin", "admin");
        }
        applicationSteps.openMyPopularApplicationDetails(title);
        applicationSteps.openDownloadPage();
        tempApp = applicationSteps.getDataFromDownloadPage();
    }

    @When ("user delete application '$app'")
    public void deleteApplication(String app) {
        applicationSteps.openApplicationDetails(app);
        applicationSteps.deleteApplication();
    }

    @Then ("user can't see application '$title' on home page")
    public void notSeeApplicationByTitle(String title) {
        navigationSteps.openHomePage();
        applicationSteps.validateThatApplicationRemovedByTitle(title);
    }
}
