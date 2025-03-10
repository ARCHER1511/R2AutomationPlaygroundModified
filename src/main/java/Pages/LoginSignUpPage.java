package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSignUpPage
{
    private WebDriver driver;

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
    public LoginSignUpPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Actions
    public LoginSignUpPage fillSignUpForm(String name, String Email)
    {
        driver.findElement(registrationName).sendKeys(name);
        driver.findElement(registrationEmail).sendKeys(Email);
        return this;
    }
    public RegistrationPage clickSignUpButton()
    {
        driver.findElement(SignUpButton).click();
        return new RegistrationPage(driver);
    }

    public LoginSignUpPage fillLoginEmailField(String Email)
    {
        driver.findElement(loginEmail).sendKeys(Email);
        return this;
    }

    public LoginSignUpPage fillInPasswordField(String Password)
    {
        driver.findElement(loginPassword).sendKeys(Password);
        return this;
    }

    public HomePage clickOnLoginButton()
    {
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    //Assertions
    public LoginSignUpPage checkThatSignUpFormTitleShouldBeDisplayed()
    {
        Assert.assertEquals(driver.findElement(signUpFormHeader).getText(),signUpFormTitle);
        return this;
    }
    public LoginSignUpPage checkThatLoginFormTitleShouldBeDisplayed()
    {
        Assert.assertEquals(driver.findElement(loginFormHeader).getText(),loginFormTitle);
        return this;
    }
    public LoginSignUpPage checkThatExitingEmailErrorShouldBeDisplayed()
    {
        Assert.assertEquals(driver.findElement(signUpExitingEmailMessage).getText(),AlreadyExitsMailMessageText);
        return this;
    }
    public LoginSignUpPage checkThatIncorrectCredentialsMessageIsDisplayed()
    {
        Assert.assertEquals(driver.findElement(loginIncorrectCredentialsMessage).getText(),IncorrectCredentialsMessageText);
        return this;
    }
}

