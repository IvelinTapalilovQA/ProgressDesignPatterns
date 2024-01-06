package pageObject.PracticeAutomationBookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

    WebDriver driver;

    public ShopPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(linkText = "Home")
    WebElement homeButton;

    //Action Methods
    public void clickOnHomeButton(){
        homeButton.click();
    }
}
