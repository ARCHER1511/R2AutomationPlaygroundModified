package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage
{
    private WebDriver driver;
    By loginSignUpLink = By.xpath("//a[@href=\"/login\"]");
    By featuresItemsText = By.xpath("//div[@class=\"features_items\"]/h2");
    String FeaturesItemsTitle = "Features Items".toUpperCase();
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    String homePageUrl ="https://www.automationexercise.com/";
    By ProductsLink = By.xpath("//a[@href=\"/products\"]");

    //Constructor
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Actions
    public LoginSignUpPage clickOnLoginSignUpPage()
    {
        driver.findElement(loginSignUpLink).click();
        return new LoginSignUpPage(driver);
    }
    public LoginSignUpPage clickOnLogoutLink()
    {
        driver.findElement(logoutLink).click();
        return new LoginSignUpPage(driver);
    }
    public AccountDeletionPage clickOnDeleteAccountPage()
    {
        driver.findElement(deleteAccountLink).click();
        return new AccountDeletionPage(driver);
    }


    //Assertions
    public HomePage CheckThatHomePageLoaded()
    {
        Assert.assertEquals(driver.findElement(featuresItemsText).getText(),FeaturesItemsTitle);
        return this;
    }
    public HomePage checkThatUserShouldBeNavigatedToHomePageSuccessfully()
    {
        Assert.assertEquals(driver.getCurrentUrl(),homePageUrl);
        return this;
    }

    public HomePage checkThatLogoutLinkShouldBeDisplayed()
    {
        Assert.assertTrue(driver.findElement(logoutLink).isDisplayed());
        return this;
    }

    public HomePage checkThatDeleteAccountLinkShouldBeDisplayed()
    {
        Assert.assertTrue(driver.findElement(deleteAccountLink).isDisplayed());
        return this;
    }

    public HomePage checkThatLoginLinkShouldBeDisplyed()
    {
        Assert.assertTrue(driver.findElement(loginSignUpLink).isDisplayed());
        return this;
    }
    public ProductsPage clickOnProductsIcon()
    {
        driver.findElement(ProductsLink).click();
        return new ProductsPage(driver);
    }
}
