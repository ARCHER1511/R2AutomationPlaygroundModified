package TestCassesPackage;

import Pages.HomePage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class ProductsPageTest
{
    private WebDriver driver;


    @BeforeClass
    public void setup()
    {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
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
