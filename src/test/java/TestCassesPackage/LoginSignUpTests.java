package TestCassesPackage;

import Pages.HomePage;
import Pages.LoginSignUpPage;
import driverfactory.Driver;
import org.testng.annotations.*;



public class LoginSignUpTests
{
    public ThreadLocal<Driver> driver;

    //@BeforeMethod
    //@Parameters(value = {"browserName"})
    //@Optional("CHROME") String browserName
    //browserName

    @BeforeMethod
    public void setup()
    {
        driver = new ThreadLocal<>();
        driver.set(new Driver());
        //driver.get().browser().getToURL("https://www.automationexercise.com/");
    }

    @Test
    public void registerWithExistingEmail()
    {
        new HomePage(driver.get()).clickOnLoginSignUpPage().
                checkThatSignUpFormTitleShouldBeDisplayed().
                fillSignUpForm("Test","test@test.com").
                clickSignUpButton();
        new LoginSignUpPage(driver.get()).checkThatExitingEmailErrorShouldBeDisplayed();
    }
    @Test
    public void loginWithIncorrectCredentials()
    {
        new HomePage(driver.get()).clickOnLoginSignUpPage().
                checkThatLoginFormTitleShouldBeDisplayed().
                fillLoginEmailField("test@test.com").
                fillInPasswordField("1234567899").
                clickOnLoginButton();
        new LoginSignUpPage(driver.get()).checkThatIncorrectCredentialsMessageIsDisplayed();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.get().quit();
    }
}
