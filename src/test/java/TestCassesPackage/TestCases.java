package TestCassesPackage;

import Pages.HomePage;
import Pages.LoginSignUpPage;
import driverfactory.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class TestCases
{
    private Driver driver;
    Random rand = new Random();
    int random = rand.nextInt();
    String random_string = Integer.toString(random);

    @BeforeClass
    public void setup()
    {
        driver = new Driver("Chrome");
        driver.get().navigate().to("https://www.automationexercise.com/");
    }
    @Test(priority = 1)
    public void UserShouldRegisterSuccessfully()
    {
        new HomePage(driver).CheckThatHomePageLoaded()
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
        new HomePage(driver).clickOnLogoutLink().checkThatLoginFormTitleShouldBeDisplayed();
    }
    @Test(priority = 3,dependsOnMethods = "userCanLogoutSuccessfully")
    public void userCanLoginSuccessfully()
    {
        new LoginSignUpPage(driver).fillLoginEmailField("test"+random_string+"@test.com")
                .fillInPasswordField(random_string+"@#$%&*")
                .clickOnLoginButton()
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .checkThatLogoutLinkShouldBeDisplayed()
                .checkThatDeleteAccountLinkShouldBeDisplayed();
    }
    @Test(priority = 4,dependsOnMethods = "userCanLoginSuccessfully")
    public void userCanDeleteAccountSuccessfully()
    {
        new HomePage(driver).clickOnDeleteAccountPage()
                .checkThatAccountShouldBeDeletedSuccessfully()
                .clickOnContinueButton()
                .checkThatLoginLinkShouldBeDisplyed();
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }


}
