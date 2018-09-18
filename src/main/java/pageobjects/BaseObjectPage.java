package pageobjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.SetupDriver;



public abstract class BaseObjectPage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    private String endUrl;
    static WebDriver driver;

    public BaseObjectPage(String endUrl) {
        this.endUrl = endUrl;
        if (driver == null) {
            driver = SetupDriver.setup();
        }

        PageFactory.initElements(driver, this);
    }

    @Override
    protected void isLoaded() throws Error {
        waitUntilPageLoads();
        if (!isUrlCorrect()) throw new Error();
    }

    @Override
    protected void load() {
        driver.get(getExpectedUrl());

    }

    public void waitUntilPageLoads() {
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public boolean isUrlCorrect() {
        System.out.println(getCurrentUrl());
        System.out.println(getExpectedUrl());
        return (getCurrentUrl().endsWith(endUrl) || getCurrentUrl().endsWith(endUrl + "/"));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl().toLowerCase();
    }

    public String getExpectedUrl() {
        return System.getProperty("BASE_URL") + endUrl;
    }

    public double getBrowserWidth() {
        return driver.manage().window().getSize().width;
    }

    public double getBrowserHeight() {
        return driver.manage().window().getSize().height;
    }


    public void changeBrowserSize(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void maximizeBrowserSize() {
        driver.manage().window().maximize();
    }

    public static void closeTheDriver() {
        driver.close();
    }


    boolean checkElementText(WebElement element, String expectedText) {
        return element.getText().equals(expectedText);
    }

    void navigateBack() {
        driver.navigate().back();
    }

    boolean isElementExist(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    void fillField(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }
}
