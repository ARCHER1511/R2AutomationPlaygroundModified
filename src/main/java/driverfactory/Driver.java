package driverfactory;

import ElementActions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Driver
{
    private final WebDriver driver;

    public Driver(String driver)
    {
        this.driver = getDriver(driver).startDriver();
        System.out.println("We started with " + driver);
        this.driver.manage().window().maximize();
    }

    private DriverAbstract getDriver(String driver)
    {
        switch(driver.toUpperCase())
        {
            case "CHROME" :
            {
                return new ChromeDriverFactory();
            }
            case "FIREFOX":
            {
                return new FirefoxDriverFactory();
            }
            case "EDGE":
            {
                return new EdgeDriverFactory();
            }
            default:
            {
                throw new IllegalStateException("Unexpected value" + driver);
            }
        }
    }
    public WebDriver get()
    {
        return this.driver;
    }
    public void quit()
    {
        driver.quit();
    }
    public ElementActions element()
    {
        return new ElementActions(driver);
    }
}
