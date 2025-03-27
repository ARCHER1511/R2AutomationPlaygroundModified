package Pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage
{
    private final Driver driver;
    By loginSignUpLink = By.xpath("//a[@href=\"/login\"]");
    By featuresItemsText = By.xpath("//div[@class=\"features_items\"]/h2");
    String FeaturesItemsTitle = "Features Items".toUpperCase();
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    String homePageUrl ="https://www.automationexercise.com/";
    By ProductsLink = By.xpath("//a[@href=\"/products\"]");

    //Constructor
    public HomePage(Driver driver)
    {
        this.driver = driver;
    }

    //Actions
    @Step("clickOnLoginSignUpPage")
    public LoginSignUpPage clickOnLoginSignUpPage()
    {
        driver.element().click(loginSignUpLink);
        return new LoginSignUpPage(driver);
    }
    @Step("clickOnLogoutLink")
    public LoginSignUpPage clickOnLogoutLink()
    {
        driver.element().click(logoutLink);
        return new LoginSignUpPage(driver);
    }
    @Step("clickOnDeleteAccountPage")
    public AccountDeletionPage clickOnDeleteAccountPage()
    {
        driver.element().click(deleteAccountLink);
        return new AccountDeletionPage(driver);
    }


    //Assertions
    @Step("CheckThatHomePageLoaded")
    public HomePage CheckThatHomePageLoaded()
    {
        Assert.assertEquals(driver.element().getTextOf(featuresItemsText),FeaturesItemsTitle);
        return this;
    }
    @Step("checkThatUserShouldBeNavigatedToHomePageSuccessfully")
    public HomePage checkThatUserShouldBeNavigatedToHomePageSuccessfully()
    {
        Assert.assertEquals(driver.get().getCurrentUrl(),homePageUrl);
        return this;
    }
    @Step("checkThatLogoutLinkShouldBeDisplayed")
    public HomePage checkThatLogoutLinkShouldBeDisplayed()
    {
        Assert.assertTrue(driver.element().IsDisplayed(logoutLink));
        return this;
    }
    @Step("checkThatDeleteAccountLinkShouldBeDisplayed")
    public HomePage checkThatDeleteAccountLinkShouldBeDisplayed()
    {
        Assert.assertTrue(driver.element().IsDisplayed(deleteAccountLink));
        return this;
    }
    @Step("checkThatLoginLinkShouldBeDisplyed")
    public HomePage checkThatLoginLinkShouldBeDisplyed()
    {
        Assert.assertTrue(driver.element().IsDisplayed(loginSignUpLink));
        return this;
    }
    @Step("clickOnProductsIcon")
    public ProductsPage clickOnProductsIcon()
    {
        driver.element().click(ProductsLink);
        return new ProductsPage(driver);
    }
}
