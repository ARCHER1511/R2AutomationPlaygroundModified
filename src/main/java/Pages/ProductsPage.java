package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage
{
    private WebDriver driver;

    By AllProductsTitle = By.xpath("//h2[@class=\"title text-center\"]");
    String AllProductsText = "All Products".toUpperCase();
    By SearchBar = By.id("search_product");
    By SearchIcon = By.id("submit_search");
    By SearchedProductsTitle = By.xpath("//h2[@class=\"title text-center\"]");
    String SearchedProductsText = "Searched Products".toUpperCase();
    public ProductsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public ProductsPage checkThatAllProductsTitleIsDisplayed()
    {
        Assert.assertEquals(driver.findElement(AllProductsTitle).getText(),AllProductsText);
        return this;
    }
    public ProductsPage fillSearchBar(String search)
    {
        driver.findElement(SearchBar).sendKeys(search);
        return this;
    }
    public ProductsPage clickSearchIcon()
    {
        driver.findElement(SearchIcon).click();
        return this;
    }
    public ProductsPage checkThatSearchResultsIsDisplayed()
    {
        Assert.assertEquals(driver.findElement(SearchedProductsTitle).getText(),SearchedProductsText);
        return this;
    }


}
