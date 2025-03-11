package Pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;

public class RegistrationPage {
    private final Driver driver;
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
    public RegistrationPage(Driver driver) {
        this.driver = driver;
    }

    //Assertions
    public RegistrationPage checkEnterAccountInformationTextIsDisplayed() {
        Assert.assertEquals(driver.element().getTextOf(EnterAccountInfoText), EnterAccountInformation);
        return this;
    }

    public RegistrationPage checkAddressInformationTextIsDisplayed() {
        Assert.assertEquals(driver.element().getTextOf(AddressInfoText), AddressInformation);
        return this;
    }

    //Actions
    public RegistrationPage clickMrRadioButton() {
        driver.element().click(Mr_radio_button);
        return this;
    }

    public RegistrationPage clickMrsRadioButton() {
        driver.element().click(Mrs_radio_button);
        return this;
    }

    public RegistrationPage fillNameField(String Name) {
        driver.element().type(Name_field, Name);
        return this;
    }

    public RegistrationPage fillEmailField(String Email) {
        driver.element().type(Email_field, Email);
        return this;
    }

    public RegistrationPage fillPasswordField(String Password) {
        driver.element().type(Password_field, Password);
        return this;
    }

    public RegistrationPage useDropDownDays() {
        driver.element().selectByValue(Days_drop_down, driver.element().getTextOf(day));
        return this;
    }

    public RegistrationPage useDropDownMonths() {
        driver.element().selectByValue(Months_drop_down, driver.element().getTextOf(month));
        return this;
    }

    public RegistrationPage useDropDownYears() {
        driver.element().selectByValue(Years_drop_down, driver.element().getTextOf(year));
        return this;
    }

    public RegistrationPage clickSignUpForNewsLetterCheckBox() {
        driver.element().click(SignUpForNewsLetter_CheckBox);
        return this;
    }

    public RegistrationPage clickSpecialOffers_CheckBox() {
        driver.element().click(SpecialOffers_CheckBox);
        return this;
    }

    public RegistrationPage fillFirstNameField(String FirstName) {
        driver.element().type(firstName_field, FirstName);
        return this;
    }

    public RegistrationPage fillLastNameField(String LastName) {
        driver.element().type(lastName_field, LastName);
        return this;

    }

    public RegistrationPage fillAddress1Field(String Address) {
        driver.element().type(address1_field, Address);
        return this;
    }

    public RegistrationPage fillAddress2Field(String Address2) {
        driver.element().type(address2_field, Address2);
        return this;
    }

    public RegistrationPage useDropDownCountry() {
        driver.element().selectByValue(country_dropdown, driver.element().getTextOf(country));
        return this;
    }

    public RegistrationPage fillStateField(String State) {
        Assert.assertEquals(driver.get().findElement(AddressInfoText).getText(), AddressInformation);
        driver.element().type(state_field, State);
        return this;
    }

    public RegistrationPage fillCityField(String City) {
        driver.element().type(city_field, City);
        return this;
    }

    public RegistrationPage fillZipCodeFiled(String ZipCode) {
        driver.element().type(zipcode_field, ZipCode);
        return this;
    }

    public RegistrationPage fillMobileNumberField(String MobileNumber) {
        driver.element().type(mobile_number_field, MobileNumber);
        return this;
    }

    public RegistrationSuccessPage clickCreateAccountButton() {
        driver.element().click(create_account_button);
        return new RegistrationSuccessPage(driver);
    }

}
