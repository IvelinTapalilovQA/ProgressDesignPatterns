package pageObject.PracticeAutomationBookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {

    WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a.checkout-button")
    WebElement checkOutButton;

    public boolean isCheckOutButtonDisplayed(){
        return checkOutButton.isDisplayed();
    }


}
