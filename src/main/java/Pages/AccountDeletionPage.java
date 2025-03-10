package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeletionPage
{
    private WebDriver driver;
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");
    By AccountDeletedHeader = By.xpath("//h2[@data-qa=\"account-deleted\"]/b");
    String AccountDeletedText = "Account Deleted!".toUpperCase();


    //Constructor
    public AccountDeletionPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //Assertion
    public AccountDeletionPage checkThatAccountShouldBeDeletedSuccessfully()
    {
        Assert.assertEquals(driver.findElement(AccountDeletedHeader).getText(),AccountDeletedText);
        return this;
    }
    //Action
    public HomePage clickOnContinueButton()
    {
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }
}
