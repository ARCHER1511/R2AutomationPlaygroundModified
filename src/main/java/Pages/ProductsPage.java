package Pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage
{
    private final Driver driver;

    By AllProductsTitle = By.xpath("//h2[@class=\"title text-center\"]");
    String AllProductsText = "All Products".toUpperCase();
    By SearchBar = By.id("search_product");
    By SearchIcon = By.id("submit_search");
    By SearchedProductsTitle = By.xpath("//h2[@class=\"title text-center\"]");
    String SearchedProductsText = "Searched Products".toUpperCase();
    public ProductsPage(Driver driver)
    {
        this.driver = driver;
    }

    public ProductsPage checkThatAllProductsTitleIsDisplayed()
    {
        Assert.assertEquals(driver.element().getTextOf(AllProductsTitle),AllProductsText);
        return this;
    }
    public ProductsPage fillSearchBar(String search)
    {
        driver.element().type(SearchBar,search);
        return this;
    }
    public ProductsPage clickSearchIcon()
    {
        driver.element().click(SearchIcon);
        return this;
    }
    public ProductsPage checkThatSearchResultsIsDisplayed()
    {
        Assert.assertEquals(driver.element().getTextOf(SearchedProductsTitle),SearchedProductsText);
        return this;
    }


}
