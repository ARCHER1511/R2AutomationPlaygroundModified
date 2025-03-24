package TestCassesPackage;

import Pages.HomePage;
import Pages.ProductsPage;
import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class ProductsPageTest
{
    public ThreadLocal<Driver> driver;


    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName)
    {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
        driver.get().browser().getToURL("https://www.automationexercise.com/");
        driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get().get().manage().window().maximize();
    }
    @Test(priority = 1)
    public void checkThatProductsPageIsLoaded()
    {
        new HomePage(driver.get()).clickOnProductsIcon().checkThatAllProductsTitleIsDisplayed();
    }
    @Test(priority = 2,dependsOnMethods ="checkThatProductsPageIsLoaded")
    public void checkThatTheProductsIsSearched()
    {
        new ProductsPage(driver.get()).fillSearchBar("TShirts").clickSearchIcon().checkThatSearchResultsIsDisplayed();
    }

    @AfterClass
    public void tearDown()
    {
        driver.get().quit();
    }
}
