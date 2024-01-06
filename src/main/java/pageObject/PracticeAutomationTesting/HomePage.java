package pageObject.PracticeAutomationTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;

    private static final String PAGE_URL = "https://practice.automationtesting.in/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Locators
    @FindBy(xpath = "//div[@class='n2-ss-slider-3']/div/div/img")
    List<WebElement> sliderImages;

    @FindBy(css = "div.themify_builder_sub_row div.col3-1")
    List<WebElement> newArrivals;

    @FindBy(css = "a.woocommerce-LoopProduct-link")
    List <WebElement> arrivalLinks;

    //Action Methods
    public void loadPage(){
        driver.get(PAGE_URL);
    }

    public int getCountSliderImages(){
        return  sliderImages.size();
    }

    public int getCountNewArrivals(){
        return newArrivals.size();
    }

    public void clickOnArrivalImage(int arrivalIndex){
        arrivalLinks.get(arrivalIndex).click();
    }
}
