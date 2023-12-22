package pageObject.ProductStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {

    WebDriver driver;

    public Header (WebDriver driver){
        this.driver = driver;
    }
    //Locators
    private final By homeLink = By.xpath("//a[text()='Home ']");
    private final By contactLink = By.xpath("//a[text()='Contact']");
    private final By cartLink = By.xpath("//a[text()='Cart']");
    private final By loginLink = By.xpath("//a[text()='Log in']");
    private final By signUpLink = By.xpath("//a[text()='Sign up']");
    private final By userAccLink = By.id("nameofuser");
    private final By logoutLink = By.id("logout2");

    //Action methods
    public void clickOnHomeLink(){
        driver.findElement(homeLink).click();
    }
    public void clickOnContactLink(){
        driver.findElement(contactLink).click();
    }
    public void clickOnCartLink(){
        driver.findElement(cartLink).click();
    }
    public void clickOnLoginLink(){
        driver.findElement(loginLink).click();
    }
    public boolean isLoginLinkDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
        return driver.findElement(loginLink).isDisplayed();
    }

    public void clickOnSignUpLink(){
        driver.findElement(signUpLink).click();
    }
    public void clickOnSingUpLink(){
        driver.findElement(userAccLink).click();
    }
    public boolean isUserWelcomeLinkDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userAccLink));
        return driver.findElement(userAccLink).isDisplayed();
    }
    public void clickOnWelcomeUsernameLink(){
        driver.findElement(userAccLink).click();
    }
    public void clickOnLogOutLink(){
        driver.findElement(logoutLink).click();
    }
}
