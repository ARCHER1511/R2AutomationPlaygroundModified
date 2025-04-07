package Pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AccountDeletionPage
{
    private final Driver driver;
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");
    By AccountDeletedHeader = By.xpath("//h2[@data-qa=\"account-deleted\"]/b");
    String AccountDeletedText = "Account Deleted!".toUpperCase();


    //Constructor
    public AccountDeletionPage(Driver driver)
    {
        this.driver = driver;
    }
    //Assertion
    public AccountDeletionPage checkThatAccountShouldBeDeletedSuccessfully()
    {
        Assert.assertEquals(driver.element().getTextOf(AccountDeletedHeader),AccountDeletedText);
        return this;
    }
    //Action
    public HomePage clickOnContinueButton()
    {
        driver.element().click(continueButton);
        return new HomePage(driver);
    }
}
