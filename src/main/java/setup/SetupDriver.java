package setup;

import exceptions.InvalidBrowserException;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SetupDriver {


    public static WebDriver setup() {
        return getDriver(System.getProperty("browser"));
    }


    private static WebDriver getDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "opera":
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            default:
                throw new InvalidBrowserException(String.format("The `%s` browser is not supported", browser));
        }
    }
}