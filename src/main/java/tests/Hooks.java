package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pageobjects.BaseObjectPage;



public class Hooks {

    @Parameters({"selenium.browser","selenium.url"})
    @BeforeSuite(alwaysRun = true)
    public void setup(String browser, String url)  {
        System.setProperty("browser",browser);
        System.setProperty("BASE_URL",url.endsWith("/") ? url : url + "/");

    }



    @AfterSuite(alwaysRun = true)
    public void after() {
        BaseObjectPage.closeTheDriver();
    }
}
