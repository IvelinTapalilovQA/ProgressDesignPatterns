package pageObject.PracticeAutomationTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    WebDriver driver;

    public Header(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(linkText = "Shop")
    WebElement shopButton;

    //Action Methods
    public void clickOnShopButton(){
        shopButton.click();
    }
}
