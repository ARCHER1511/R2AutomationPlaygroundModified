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
    private Driver driver;


    @BeforeClass
    public void setup()
    {
        driver = new Driver("Chrome");
        driver.get().navigate().to("https://www.automationexercise.com/");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get().manage().window().maximize();
    }
    @Test(priority = 1)
    public void checkThatProductsPageIsLoaded()
    {
        new HomePage(driver).clickOnProductsIcon().checkThatAllProductsTitleIsDisplayed();
    }
    @Test(priority = 2,dependsOnMethods ="checkThatProductsPageIsLoaded")
    public void checkThatTheProductsIsSearched()
    {
        new ProductsPage(driver).fillSearchBar("TShirts").clickSearchIcon().checkThatSearchResultsIsDisplayed();
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
