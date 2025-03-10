package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationSuccessPage
{
    private WebDriver driver;
    private WebDriverWait wait;

    By successMessage = By.xpath("//h2[@data-qa=\"account-created\"]/b");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");


    public RegistrationSuccessPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }
    //Assertions
    public RegistrationSuccessPage checkThatSuccessMessageShouldBeDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(successMessage)));

        Assert.assertTrue(driver.getCurrentUrl().contains("/account_created"));
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        Assert.assertEquals(driver.findElement(successMessage).getText(),"ACCOUNT CREATED!");
        return this;
    }
    //Action
    public HomePage clickOnContinueButton()
    {
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }
}

