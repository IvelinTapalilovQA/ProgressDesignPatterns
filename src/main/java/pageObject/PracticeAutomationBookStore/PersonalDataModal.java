package pageObject.PracticeAutomationBookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDataModal {

    WebDriver driver;

    public PersonalDataModal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//button[@class='fc-button fc-cta-do-not-consent fc-secondary-button']")
    WebElement cancelButton;

    //Action Methods
    public void clickOnCancelButton(){
        cancelButton.click();
    }
}
