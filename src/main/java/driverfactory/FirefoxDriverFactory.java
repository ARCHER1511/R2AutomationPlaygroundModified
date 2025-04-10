package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static utilties.PropertiesManager.webConfig;

public class FirefoxDriverFactory extends DriverAbstract
{

    @Override
    public WebDriver startDriver()
    {
        FirefoxOptions options = new FirefoxOptions();
        if(webConfig.getProperty("HeadlessMode").equalsIgnoreCase("true")) {
            options.addArguments("--headless");
        }
        driver = new FirefoxDriver(options);
        return driver;
    }
}
