package com.dataart.serenitybdd.models;

import java.io.File;


/**
 * Created by achernyshev on 11.11.2016.
 */

public class ApplicationBuilder {

    public static Application newAppNoImages() {
        Application app = new Application("TestApp", "Test Description");
        app.setCategory("Maps");
        return app;
    }

    public static Application editAppNoImages() {
        Application app = new Application("TestApp", "Changed Test Description");
        app.setCategory("Information");
        return app;
    }

    public static Application newAppWithImages() {
        Application app = new Application("TestImages", "Test Description");
        app.setCategory("Fun");
        File image = new File("./src/test/resources/images/image.jpg");
        File icon = new File("./src/test/resources/images/icon.jpg");
        app.setImage(image.getAbsolutePath());
        app.setIcon(icon.getAbsolutePath());
        return app;
    }

    public static Application newPopularApp() {
        Application app = new Application("TestPopular", "Test Description");
        app.setCategory("Information");
        app.setDownloads("10");
        return app;
    }
}
