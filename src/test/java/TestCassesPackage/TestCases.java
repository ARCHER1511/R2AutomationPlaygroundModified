package TestCassesPackage;

import Pages.HomePage;
import Pages.LoginSignUpPage;
import driverfactory.Driver;
import org.testng.annotations.*;
import java.util.Random;

public class TestCases
{
   // public Driver driver;
    public ThreadLocal<Driver> driver;
    Random rand = new Random();
    int random = rand.nextInt();
    String random_string = Integer.toString(random);


    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setup(@Optional("CHROME") String browserName)
    {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
        //driver = new Driver("Chrome");
        driver.get().browser().getToURL("https://www.automationexercise.com/");

    }
    @Test(priority = 1)
    public void UserShouldRegisterSuccessfully()
    {
        new HomePage(driver.get()).CheckThatHomePageLoaded()
                .clickOnLoginSignUpPage()
                .checkThatSignUpFormTitleShouldBeDisplayed()
                .fillSignUpForm("Test"+random_string,"test"+random_string+"@test.com")
                .clickSignUpButton()
                .checkEnterAccountInformationTextIsDisplayed()
                .checkAddressInformationTextIsDisplayed()
                .clickMrRadioButton()
                .fillNameField("Test"+random_string)
                .fillPasswordField(random_string+"@#$%&*")
                .useDropDownDays()
                .useDropDownMonths()
                .useDropDownYears()
                .clickSignUpForNewsLetterCheckBox()
                .clickSpecialOffers_CheckBox()
                .fillFirstNameField("Test")
                .fillLastNameField("Tester")
                .fillAddress1Field("21th street house number 10")
                .fillAddress2Field("near 55th road")
                .useDropDownCountry()
                .fillStateField("British Columbia")
                .fillCityField("Vancouver")
                .fillZipCodeFiled("V6Z 0G5")
                .fillMobileNumberField("+13445343433")
                .clickCreateAccountButton()
                .checkThatSuccessMessageShouldBeDisplayed().clickOnContinueButton();
    }
    @Test(priority = 2,dependsOnMethods = {"UserShouldRegisterSuccessfully"})
    public void userCanLogoutSuccessfully()
    {
        new HomePage(driver.get()).clickOnLogoutLink().checkThatLoginFormTitleShouldBeDisplayed();
    }
    @Test(priority = 3,dependsOnMethods = "userCanLogoutSuccessfully")
    public void userCanLoginSuccessfully()
    {
        new LoginSignUpPage(driver.get()).fillLoginEmailField("test"+random_string+"@test.com")
                .fillInPasswordField(random_string+"@#$%&*")
                .clickOnLoginButton()
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .checkThatLogoutLinkShouldBeDisplayed()
                .checkThatDeleteAccountLinkShouldBeDisplayed();
    }
    @Test(priority = 4,dependsOnMethods = "userCanLoginSuccessfully")
    public void userCanDeleteAccountSuccessfully()
    {
        new HomePage(driver.get()).clickOnDeleteAccountPage()
                .checkThatAccountShouldBeDeletedSuccessfully()
                .clickOnContinueButton()
                .checkThatLoginLinkShouldBeDisplyed();
    }
//    @AfterMethod
//    public void screenShotAndFailure(ITestResult testResult)
//    {
//
//        if(testResult.getStatus() == ITestResult.FAILURE)
//        {
//
//
//            ScreenshotManager.captureScreenShot(driver.get(),testResult.getName());
//
//
//        }
//    }

    @AfterClass
    public void tearDown()
    {
        driver.get().quit();
    }


}
