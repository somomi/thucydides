package com.dataart.serenitybdd.ui.test;


import net.serenitybdd.jbehave.SerenityStory;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;

public class JBehaveTestSuit extends SerenityStory {
    public JBehaveTestSuit() {
        System.setProperty("webdriver.ie.driver", "./src/test/resources/drivers/IEDriverServer.exe");
        Configuration configuration = new MostUsefulConfiguration()
                .useStoryControls(new StoryControls().doResetStateBeforeScenario(false));
        findStoriesCalled("**/stories/**");
    }
}
