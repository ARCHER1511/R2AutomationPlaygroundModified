package ElementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementActions
{
    private final WebDriver driver;
    private final JavascriptExecutor javascriptExecutor;



    public ElementActions(WebDriver driver)
    {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) this.driver; //vip
    }
    public void click(By locator)
    {
        System.out.println("Click on: " + locator.toString());
        driver.findElement(locator).click();
    }
    public void type(By locator, String text)
    {
        clearField(locator);
        System.out.println("fill field " + locator.toString() + "with" + text);
        driver.findElement(locator).sendKeys(text);
    }
    public void clearField(By locator)
    {
        System.out.println("Clear field with locator: " + locator.toString());
        driver.findElement(locator).clear();
    }
    public ElementActions selectByIndex(By locator, int index)
    {
        System.out.println("Selecting option "+ index + "from dropdown: "+ locator.toString());
        new Select(driver.findElement(locator)).selectByIndex(index);
        return this;
    }
    public void selectByValue(By locator, String value)
    {
        System.out.println("Selecting value "+ value + "from dropdown: "+ locator.toString());
        new Select(driver.findElement(locator)).selectByValue(value);
    }
    public void selectByText(By locator, String text)
    {
        System.out.println("Select element with text: "+ text + "from dropdown: " + locator);
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }
    public String getTextOf(By locator)
    {
        System.out.println("Getting text from locator: " + locator.toString());
        return  driver.findElement(locator).getText();

    }
    public Boolean IsDisplayed(By locator)
    {
        System.out.println("Checking" + locator.toString().split(":",2)[1] + "if Displayed");
        return driver.findElement(locator).isDisplayed();
    }
    public Boolean IsSelected(By locator)
    {
        System.out.println("Checking" + locator.toString().split(":",2)[1] + "if Selected");
        return driver.findElement(locator).isSelected();
    }
    public Boolean IsClickable(By locator)
    {
        System.out.println("Checking" + locator.toString().split(":",2)[1] + "if Clicked");
        return driver.findElement(locator).isEnabled();
    }
    //actions
    public ElementActions scrollToElement(By locator)
    {
        System.out.println("Scrolling to element : " + locator.toString());
        new Actions(driver).scrollToElement(driver.findElement(locator)).build().perform();
        return this;
    }
//    public ElementActions selectByIndex(By locator, int index)
//    {
//        System.out.println("Selecting options " + index + "from dropdown" + locator.toString());
//        new Select(driver.findElement(locator)).selectByIndex(index);
//        return this;
//    }

    public ElementActions clickUsingJavascript(By locator)
    {
        javascriptExecutor.executeScript("arguments[0].click();", driver.findElement(locator));
        return this;
    }


}
