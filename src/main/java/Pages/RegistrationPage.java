package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;

public class RegistrationPage
{
    private WebDriver driver;
    By EnterAccountInfoText = By.xpath("(//h2/b)[1]");
    String EnterAccountInformation = "Enter Account Information".toUpperCase();
    By AddressInfoText = By.xpath("(//h2/b)[2]");
    String AddressInformation = "Address Information".toUpperCase();
    //for registration
    By Mr_radio_button = By.xpath("//input[@id=\"id_gender1\"]"); //Required
    By Mrs_radio_button = By.xpath("//input[@id=\"id_gender2\"]");  //Required
    By Name_field = By.xpath("//input[@data-qa=\"name\"]");//Required
    By Email_field = By.xpath("//input[@data-qa=\"email\"]");//Required
    By Password_field = By.xpath("//input[@id=\"password\"]");//Required
    By Days_drop_down = By.xpath("//select[@id=\"days\"]");//Required
    By Months_drop_down = By.xpath("//select[@id=\"months\"]");//Required
    By Years_drop_down = By.xpath("//select[@id=\"years\"]");//Required
    By SignUpForNewsLetter_CheckBox = By.xpath("//input[@id=\"newsletter\"]");
    By SpecialOffers_CheckBox = By.xpath("//input[@id=\"optin\"]");
    By firstName_field = By.xpath("//input[@id=\"first_name\"]");//Required
    By lastName_field = By.xpath("//input[@id=\"last_name\"]");//Required
    By address1_field = By.xpath("//input[@id=\"address1\"]");//Required
    By address2_field = By.xpath("//input[@id=\"address2\"]");
    By country_dropdown = By.xpath("//select[@id=\"country\"]");//Required
    By state_field = By.xpath("//input[@id=\"state\"]");//Required
    By city_field = By.xpath("//input[@id=\"city\"]");//Required
    By zipcode_field = By.xpath("//input[@id=\"zipcode\"]");//Required
    By mobile_number_field = By.xpath("//input[@id=\"mobile_number\"]");//Required
    By create_account_button = By.xpath("//button[@data-qa=\"create-account\"]");

    //for drop down menus
    By day = By.xpath("//select[@data-qa=\"days\"]/option[@value=\"1\"]");
    By month = By.xpath("//select[@data-qa=\"months\"]/option[@value=\"1\"]");
    By year = By.xpath("//select[@data-qa=\"years\"]/option[@value=\"2021\"]");
    By country = By.xpath("//select[@data-qa=\"country\"]/option[@value=\"Canada\"]");
    //Constructor
    public RegistrationPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //Assertions
    public RegistrationPage checkEnterAccountInformationTextIsDisplayed()
    {
        Assert.assertEquals(driver.findElement(EnterAccountInfoText).getText(),EnterAccountInformation);
        return  this;
    }
    public RegistrationPage checkAddressInformationTextIsDisplayed()
    {
        Assert.assertEquals(driver.findElement(AddressInfoText).getText(),AddressInformation);
        return this;
    }
    //Actions
    public RegistrationPage clickMrRadioButton()
    {
        driver.findElement(Mr_radio_button).click();
        return this;
    }
    public RegistrationPage clickMrsRadioButton()
    {
        driver.findElement(Mrs_radio_button).click();
        return this;
    }
    public RegistrationPage fillNameField(String Name)
    {
        driver.findElement(Name_field).sendKeys(Name);
        return this;
    }
    public RegistrationPage fillEmailField(String Email)
    {
        driver.findElement(Email_field).sendKeys(Email);
        return this;
    }
    public RegistrationPage fillPasswordField(String Password)
    {
        driver.findElement(Password_field).sendKeys(Password);
        return this;
    }
    public RegistrationPage useDropDownDays()
    {
        new Select(driver.findElement(Days_drop_down)).selectByVisibleText(driver.findElement(day).getText());
        return this;
    }
    public RegistrationPage useDropDownMonths()
    {
        new Select(driver.findElement(Months_drop_down)).selectByVisibleText(driver.findElement(month).getText());
        return this;
    }
    public RegistrationPage useDropDownYears()
    {
        new Select(driver.findElement(Years_drop_down)).selectByVisibleText(driver.findElement(year).getText());
        return this;
    }
    public RegistrationPage clickSignUpForNewsLetterCheckBox()
    {
        driver.findElement(SignUpForNewsLetter_CheckBox).click();
        return this;
    }
    public RegistrationPage clickSpecialOffers_CheckBox()
    {
        driver.findElement(SpecialOffers_CheckBox).click();
        return this;
    }
    public RegistrationPage fillFirstNameField(String FirstName)
    {
        driver.findElement(firstName_field).sendKeys(FirstName);
        return this;
    }
    public RegistrationPage fillLastNameField(String LastName)
    {
        driver.findElement(lastName_field).sendKeys(LastName);
        return this;

    }
    public RegistrationPage fillAddress1Field(String Address)
    {
        driver.findElement(address1_field).sendKeys(Address);
        return this;
    }
    public RegistrationPage fillAddress2Field(String Address2)
    {
        driver.findElement(address2_field).sendKeys(Address2);
        return this;
    }
    public RegistrationPage useDropDownCountry()
    {
        new Select(driver.findElement(country_dropdown)).selectByVisibleText(driver.findElement(country).getText());
        return this;
    }
    public RegistrationPage fillStateField(String State)
    {
        driver.findElement(state_field).sendKeys(State);
        return this;
    }
    public RegistrationPage fillCityField(String City)
    {
        driver.findElement(city_field).sendKeys(City);
        return this;
    }
    public RegistrationPage fillZipCodeFiled(String ZipCode)
    {
        driver.findElement(zipcode_field).sendKeys(ZipCode);
        return this;
    }
    public RegistrationPage fillMobileNumberField(String MobileNumber)
    {
        driver.findElement(mobile_number_field).sendKeys(MobileNumber);
        return this;
    }
    public RegistrationSuccessPage clickCreateAccountButton()
    {
        driver.findElement(create_account_button).click();
        return new RegistrationSuccessPage(driver);
    }

}
