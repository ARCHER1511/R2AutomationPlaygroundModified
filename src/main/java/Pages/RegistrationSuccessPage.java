package Pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationSuccessPage
{
    private final Driver driver;
    private final WebDriverWait wait;

    By successMessage = By.xpath("//h2[@data-qa=\"account-created\"]/b");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");


    public RegistrationSuccessPage(Driver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(this.driver.get(), Duration.ofSeconds(30));
    }
    //Assertions
    @Step("checkThatSuccessMessageShouldBeDisplayed")
    public RegistrationSuccessPage checkThatSuccessMessageShouldBeDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOf(driver.get().findElement(successMessage)));

        Assert.assertTrue(driver.element().IsDisplayed(successMessage));
        Assert.assertEquals(driver.element().getTextOf(successMessage),"ACCOUNT CREATED!");
        return this;
    }
    //Action
    @Step("clickOnContinueButton")
    public HomePage clickOnContinueButton()
    {
        driver.element().click(continueButton);
        return new HomePage(driver);
    }
}

