package pageObject.ProductStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpModal {

    WebDriver driver;

    public SignUpModal(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private final By signUpTitle = By.id("signInModalLabel");
    private final By usernameField = By.id("sign-username");
    private final By passwordField = By.id("sign-password");
    private final By signUpButton = By.xpath("//button[text()='Sign up']");

    //Action Methods

    public boolean isSignUpTitleDisplayed(){
        return driver.findElement(signUpTitle).isDisplayed();
    }
    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickOnSignUpButton(){
        driver.findElement(signUpButton).click();
    }

}
