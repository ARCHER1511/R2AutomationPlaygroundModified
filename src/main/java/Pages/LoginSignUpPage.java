package Pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSignUpPage
{
    private Driver driver;

    By signUpFormHeader = By.xpath("//div[@class=\"signup-form\"]/h2");
    String signUpFormTitle = "New User Signup!";
    By registrationName = By.xpath("//input[@name=\"name\"]");
    By registrationEmail = By.xpath("//input[@data-qa=\"signup-email\"]");
    By SignUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    By loginFormHeader = By.xpath("//div[@class=\"login-form\"]/h2");
    String loginFormTitle = "Login to your account";
    By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    By loginIncorrectCredentialsMessage = By.xpath("//form[@action='/login']/p");
    By signUpExitingEmailMessage = By.xpath("//form[@action=\"/signup\"]/p");

    String AlreadyExitsMailMessageText = "Email Address already exist!";
    String IncorrectCredentialsMessageText = "Your email or password is incorrect!";
    //Constructor
    public LoginSignUpPage(Driver driver)
    {
        this.driver = driver;
    }

    //Actions
    public LoginSignUpPage fillSignUpForm(String name, String Email)
    {
        driver.element().type(registrationName,name);
        driver.element().type(registrationEmail,Email);
        return this;
    }
    public RegistrationPage clickSignUpButton()
    {
        driver.element().click(SignUpButton);
        return new RegistrationPage(driver);
    }

    public LoginSignUpPage fillLoginEmailField(String Email)
    {
        driver.element().type(loginEmail,Email);
        return this;
    }

    public LoginSignUpPage fillInPasswordField(String Password)
    {
        driver.element().type(loginPassword,Password);
        return this;
    }

    public HomePage clickOnLoginButton()
    {
        driver.element().click(loginButton);
        return new HomePage(driver);
    }

    //Assertions
    public LoginSignUpPage checkThatSignUpFormTitleShouldBeDisplayed()
    {
        Assert.assertEquals(driver.element().getTextOf(signUpFormHeader),signUpFormTitle);
        return this;
    }
    public LoginSignUpPage checkThatLoginFormTitleShouldBeDisplayed()
    {
        Assert.assertEquals(driver.element().getTextOf(loginFormHeader),loginFormTitle);
        return this;
    }
    public LoginSignUpPage checkThatExitingEmailErrorShouldBeDisplayed()
    {
        Assert.assertEquals(driver.element().getTextOf(signUpExitingEmailMessage),AlreadyExitsMailMessageText);
        return this;
    }
    public LoginSignUpPage checkThatIncorrectCredentialsMessageIsDisplayed()
    {
        Assert.assertEquals(driver.element().getTextOf(loginIncorrectCredentialsMessage),IncorrectCredentialsMessageText);
        return this;
    }
}

