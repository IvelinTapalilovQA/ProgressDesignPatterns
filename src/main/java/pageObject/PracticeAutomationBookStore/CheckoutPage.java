package pageObject.PracticeAutomationBookStore;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Locators
    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']/h3")
    WebElement checkoutPageTitle;

    @FindBy(id = "billing_first_name")
    WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    WebElement lastNameInput;

    @FindBy(id = "billing_company")
    WebElement companyInput;

    @FindBy(id = "billing_email")
    WebElement emailInput;

    @FindBy(id = "billing_phone")
    WebElement phoneInput;

    @FindBy(xpath = "//ul[@class='select2-results']/li/div")
    List<WebElement> countryOptions;

    @FindBy(id = "s2id_autogen1_search")
    WebElement countrySearchInput;

    @FindBy(id = "select2-chosen-1")
    WebElement countryInput;

    @FindBy(id = "billing_address_1")
    WebElement streetAddressInput;

    @FindBy(id = "billing_address_2")
    WebElement addressInputTwo;

    @FindBy(id = "billing_city")
    WebElement cityInput;

    @FindBy(id = "billing_state")
    WebElement stateInput;

    @FindBy(id = "billing_postcode")
    WebElement postCodeInput;

    @FindBy(id = "createaccount")
    WebElement checkBoxCreateAccount;

    @FindBy(id = "account_password")
    WebElement accountPasswordInput;

    @FindBy(css = "table.shop_table.woocommerce-checkout-review-order-table")
    WebElement orderInfo;

    @FindBy(id = "payment_method_cod")
    WebElement cashPaymentMethod;

    //Action Methods
    @FindBy(id = "place_order")
    WebElement placeOrderButton;

    public String getCheckoutPageTitle() {
        return checkoutPageTitle.getText();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterCompanyName(String companyName) {
        companyInput.sendKeys(companyName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void clickOnCountryOption(int index) {
        countryOptions.get(index).click();
    }

    public void enterCountryInSearchInput(String country) {
        countrySearchInput.sendKeys(country);
    }

    public void clickOnCountryInput() {
        countryInput.click();
    }

    public void enterStreetAddress(String streetAddress) {
        streetAddressInput.sendKeys(streetAddress);
    }

    public void enterAddressInputTwo(String addressInfo) {
        addressInputTwo.sendKeys(addressInfo);
    }

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    public void enterState(String state) {
        stateInput.sendKeys(state);
    }

    public void enterPostCode(String postCode) {
        postCodeInput.sendKeys(postCode);
    }

    public void clickOnCheckBoxCreateAccount() {
        checkBoxCreateAccount.click();
    }

    public boolean isCheckBoxSelected() {
        return checkBoxCreateAccount.isSelected();
    }

    public String getOrderInformationText() {
        return orderInfo.getText();
    }

    public void enterAccountPassword(String password) {
        accountPasswordInput.sendKeys(password);
    }

    public void clickOnCashPaymentMethod() {
        cashPaymentMethod.click();
    }

    public boolean isCashPaymentMethodSelected() {
        return cashPaymentMethod.isSelected();
    }

    public void clickOnPlaceOrderButton() {
        placeOrderButton.click();
    }
}
