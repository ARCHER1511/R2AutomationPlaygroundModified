package TestCassesPackage;

import Pages.HomePage;
import Pages.LoginSignUpPage;
import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginSignUpTests
{
    private Driver driver;

    @BeforeMethod
    public void setup()
    {
        driver = new Driver("Chrome");
        driver.get().navigate().to("https://www.automationexercise.com/");
    }

    @Test
    public void registerWithExistingEmail()
    {
        new HomePage(driver).clickOnLoginSignUpPage().
                checkThatSignUpFormTitleShouldBeDisplayed().
                fillSignUpForm("Test","test@test.com").
                clickSignUpButton();
        new LoginSignUpPage(driver).checkThatExitingEmailErrorShouldBeDisplayed();
    }
    @Test
    public void loginWithIncorrectCredentials()
    {
        new HomePage(driver).clickOnLoginSignUpPage().
                checkThatLoginFormTitleShouldBeDisplayed().
                fillLoginEmailField("test@test.com").
                fillInPasswordField("1234567899").
                clickOnLoginButton();
        new LoginSignUpPage(driver).checkThatIncorrectCredentialsMessageIsDisplayed();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
