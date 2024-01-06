package pageObject.PracticeAutomationTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(id = "tab-description")
    WebElement productDescription;

    @FindBy(xpath = "//a[contains(text(), 'Reviews')]")
    WebElement reviewsTab;

    @FindBy(xpath = "//a[contains(text(), 'Description')]")
    WebElement descriptionTab;

    @FindBy(css = "div#comments")
    WebElement reviewSection;

    //Action Methods
    public String getProductDescription(){
        return productDescription.getText();
    }

    public void clickOnReviewsTab(){
        reviewsTab.click();
    }

    public void clickOnDescriptionTab(){
        descriptionTab.click();
    }

    public String getReviewSectionText(){
        return reviewSection.getText();
    }
}
