package pageObject.ProductStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginModal {

    WebDriver driver;

    public LoginModal(WebDriver driver){
        this.driver = driver;
    }
    //Locators

    private final By loginModalTitle = By.id("logInModalLabel");
    private final By usernameField = By.id("loginusername");
    private final By passwordField = By.id("loginpassword");
    private final By loginButton = By.xpath("//button[text()='Log in']");

    //Actions methods

    public boolean isLoginTitleDisplayed(){
        return driver.findElement(loginModalTitle).isDisplayed();
    }
    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }
}
