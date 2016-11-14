package com.dataart.serenitybdd.pages;

import com.dataart.serenitybdd.models.Application;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class MyApplicationWebPage extends PageObject {

    @FindBy(xpath = "//div[@class='new-app-link']/a[@href='/new']")
    public WebElementFacade newApplication;
    @FindBy(xpath = "//div[@class='name']")
    WebElementFacade titleText;
    @FindBy(xpath = "//div[@class='description' and contains(., 'Description')]")
    WebElementFacade descriptionText;
    @FindBy(xpath = "//div[@class='description' and contains(., 'Category')]")
    WebElementFacade categoryText;
    @FindBy(xpath = "//div[@class='download-button']/a")
    WebElementFacade downloadButton;
    @FindBy(xpath = "//div[@class='edit-app-button']/a[contains(@href,'edit')]")
    WebElementFacade editButton;
    @FindBy(xpath = "//div[@class='edit-app-button']/a[contains(@href,'delete')]")
    WebElementFacade deleteButton;
    @FindBy(xpath = "//body")
    WebElementFacade jsonText;

    public void openNewApplications () {
        newApplication.click();
    }

    public void openEditApplicationPage () {
        editButton.click();
    }

    public void deleteApplicationPage (boolean confirm) {
        deleteButton.click();
        if (confirm) {
            getDriver().switchTo().alert().accept();
        } else {
            getDriver().switchTo().alert().dismiss();
        }
    }

    public void openDownloadPage () {
        downloadButton.click();
    }

    public Application getDataFromApplicationDownloadPage () throws ParseException {
        Application app = new Application (null, null);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonText.getText());
        app.setTitle((String) jsonObject.get("title"));
        app.setDescription ((String) jsonObject.get("description"));
        app.setCategory((String) ((JSONObject) jsonObject.get("category")).get("title"));
        app.setImage ((String) jsonObject.get("imageData"));
        app.setIcon ((String) jsonObject.get("iconData"));
        app.setDownloads(jsonObject.get("numberOfDownloads").toString());
        return app;
    }


}
