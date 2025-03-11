package BrowserActions;

import ElementActions.ElementActions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserActions {

    private final WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    /******************************* URL Controlling and Navigation *********************************/
    public BrowserActions navigateToURL(String url) {
        System.out.println("navigate to : " + url);
        driver.navigate().to(url);
        return this;
    }

    public BrowserActions getToURL(String url) {
        System.out.println("getting url of the website");
        driver.get(url);
        return this;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public BrowserActions navigateForward() {
        System.out.println("navigate forward");
        driver.navigate().forward();
        return this;
    }

    public BrowserActions navigateBack() {
        System.out.println("navigate back");
        driver.navigate().back();
        return this;
    }

    public BrowserActions refreshCurrentPage() {
        System.out.println("refresh the page");
        driver.navigate().refresh();
        return this;
    }

    public BrowserActions scrollToBottom() {
        System.out.println("scrolling to the end");
        new Actions(driver).scrollByAmount(0, 2500).build().perform();
        return this;
    }

    public BrowserActions scrollToAmount(int width, int height) {
        System.out.println("scroll with " + width + " and " + height);
        new Actions(driver).scrollByAmount(width, height).build().perform();
        return this;
    }

    /****************************************** Cookies ****************************************/

    public BrowserActions addCookie(Cookie cookie) {
        System.out.println("getting the cookie " + cookie);
        driver.manage().addCookie(cookie);
        return this;
    }


    public BrowserActions deleteCookie(Cookie cookie) {
        System.out.println("delete the cookie " + cookie);
        driver.manage().deleteCookie(cookie);
        return this;
    }

    public BrowserActions deleteCookieWithName(String name) {
        System.out.println("delete the cookie " + name);
        driver.manage().deleteCookieNamed(name);
        return this;
    }

    public BrowserActions deleteAllCookies() {
        System.out.println("delete all the cookies");
        driver.manage().deleteAllCookies();
        return this;
    }

}
