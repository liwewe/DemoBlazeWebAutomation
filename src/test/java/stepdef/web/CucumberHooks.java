package stepdef.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BaseTestWeb;

public class CucumberHooks extends BaseTestWeb {

    @Before
    public void beforeTest() {
        getDriver();
    }

    @After
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

}
