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

    @FindBy(id = "coupon_code")
    WebElement couponInput;

    @FindBy(name = "apply_coupon")
    WebElement applyCouponButton;

    @FindBy(css = "tr.cart-discount")
    WebElement couponDiscountSection;

    @FindBy(css = "div.woocommerce-message")
    WebElement couponAppliedMessage;

    public boolean isCheckOutButtonDisplayed(){
        return checkOutButton.isDisplayed();
    }

    public void enterCouponCode(String couponCode){
        couponInput.sendKeys(couponCode);
    }

    public void clickOnApplyCouponButton(){
        applyCouponButton.click();
    }

    public String getCouponDiscountSectionText() {
       return couponDiscountSection.getText();
    }

    public String getCouponAppliedMessage(){
        return couponAppliedMessage.getText();
    }
}
