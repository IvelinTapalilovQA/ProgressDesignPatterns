package pageObjectTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.PracticeAutomationBookStore.*;
import java.time.Duration;

public class BookStoreBaseEighteen {

    static WebDriver driver;
    static Header header;
    static HomePage homePage;
    static PersonalDataModal personalDataModal;
    static ProductPage productPage;
    static ShopPage shopPage;
    static BasketPage basketPage;
    static CheckoutPage checkoutPage;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        header = new Header(driver);
        homePage = new HomePage(driver);
        personalDataModal = new PersonalDataModal(driver);
        productPage = new ProductPage(driver);
        shopPage = new ShopPage(driver);
        basketPage = new BasketPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

//    Test case 18 - Homepage - Arrivals - Add to basket - Items - Check out - Payment Gateway - Place order
//    1) Open the browser
//    2) Enter the URL “http://practice.automationtesting.in/”
//    3) Click on Shop Menu
//    4) Now click on Home menu button
//    5) Test whether the Home page has Three Arrivals only
//    6) The Home page must contain only three Arrivals
//    7) Now click the image in the Arrivals
//    8) Test whether it is navigating to next page where the user can add that book into his basket.
//    9) Image should be clickable and should navigate to next page where user can add that book to his basket
//    10) Click on the Add To Basket button which adds that book to your basket
//    11) User can view that Book in the Menu item with price.
//    12) Now click on Item link which navigates to proceed to check out page.
//    13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//    14) The total always < subtotal because taxes are added in the subtotal
//    15) Now click on Proceed to Check out button which navigates to payment gateway page.
//    16) User can view Billing Details,Order Details,Additional details and Payment gateway details.
//    17) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or PayPal.
//    18) Now click on Place Order button to complete process
//    19) On clicking place-order button user completes the process where the page navigates to Order confirmation page
//    with order details,bank details,customer details and billing details.

    @Test
    public void testCheckOutPaymentPlaceOrder() {

        homePage.loadPage();
        personalDataModal.clickOnCancelButton();
        header.clickOnShopButton();
        shopPage.clickOnHomeButton();
        Assertions.assertEquals(3, homePage.getCountNewArrivals());
        homePage.clickOnArrivalImage(0);
        Assertions.assertEquals("https://practice.automationtesting.in/product/selenium-ruby/", driver.getCurrentUrl());
        Assertions.assertTrue(productPage.isAddToBasketButtonDisplayed());
        productPage.clickOnAddToBasketButton();
        Assertions.assertTrue(header.isItemPriceMenuDisplayed());
        Assertions.assertEquals("1 Item₹500.00", header.getItemPriceMenuText());
        header.clickOnItemPriceMenu();
        Assertions.assertEquals("https://practice.automationtesting.in/basket/", driver.getCurrentUrl());
        Assertions.assertTrue(basketPage.isCheckOutButtonDisplayed());
        Assertions.assertTrue(basketPage.getTotalAmount() > basketPage.getSubtotalAmount());
        basketPage.clickOnCheckOutButton();
        Assertions.assertEquals("https://practice.automationtesting.in/checkout/", driver.getCurrentUrl());
        Assertions.assertEquals("Billing Details", checkoutPage.getCheckoutPageTitle());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        checkoutPage.enterFirstName("test");
        checkoutPage.enterLastName("test");
        checkoutPage.enterCompanyName("test");
        String randomEmail = generateRandomEmail(6, 10);
        checkoutPage.enterEmail(randomEmail);
        checkoutPage.enterPhone("1234567");
        checkoutPage.clickOnCountryInput();
        checkoutPage.enterCountryInSearchInput("United Kingdom");
        checkoutPage.clickOnCountryOption(0);
        checkoutPage.enterStreetAddress("test 1");
        checkoutPage.enterAddressInputTwo("test");
        checkoutPage.enterCity("test");
        checkoutPage.enterState("test");
        checkoutPage.enterPostCode("JH1 12HT");
        checkoutPage.clickOnCheckBoxCreateAccount();
        Assertions.assertTrue(checkoutPage.isCheckBoxSelected());
        checkoutPage.enterAccountPassword("Test12test");
        Assertions.assertEquals("""
                Product Total
                Selenium Ruby  × 1 ₹500.00
                Subtotal ₹500.00
                Roaming Tax ₹25.00
                Total ₹525.00""", checkoutPage.getOrderInformationText());

        checkoutPage.clickOnCashPaymentMethod();
        Assertions.assertTrue(checkoutPage.isCashPaymentMethodSelected());

        JavascriptExecutor jsTwo = (JavascriptExecutor) driver;
        jsTwo.executeScript("window.scrollBy(0,400)", "");

        checkoutPage.clickOnPlaceOrderButton();
    }


//    @AfterAll
//    public static void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    public String generateRandomEmail(int minLengthInclusive, int maxLengthInclusive) {
        return generateRandomAlphanumericString(minLengthInclusive, maxLengthInclusive) + "@gmail.com";
    }

    public String generateRandomAlphanumericString(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }

}




