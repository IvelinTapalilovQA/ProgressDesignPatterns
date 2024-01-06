package pageObjectTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.PracticeAutomationBookStore.*;

import java.time.Duration;

public class BookStoreBaseSixEight {

    static WebDriver driver;
    static Header header;
    static HomePage homePage;
    static PersonalDataModal personalDataModal;
    static ProductPage productPage;
    static ShopPage shopPage;
    static BasketPage basketPage;

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
    }

//    Test case 6&8 - Homepage - Arrivals - Add to basket - Item
//    1) Open the browser
//    2) Enter the URL “http://practice.automationtesting.in/”
//    3) Click on Shop Menu
//    4) Now click on Home menu button
//    5) Test whether the Home page has Three Arrivals only
//    6) The Home page must contain only three Arrivals
//    7) Now click the image in the Arrivals
//    8) Test whether it is navigating to next page where the user can add that book into his basket.
//    9) Image should be clickable and should navigate to next page where user can add that book to his basket
//    10)Click on the Add To Basket button which adds that book to your basket
//    11) User can view that Book in the Menu item with price.
//    12) Now click on Item link which navigates to proceed to check out page.
//    13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check-out page

    @Test
    public void testArrivalsAddToBasketItem() {

        homePage.loadPage();
        personalDataModal.clickOnCancelButton();
        header.clickOnShopButton();
        shopPage.clickOnHomeButton();
        Assertions.assertEquals(3, homePage.getCountNewArrivals());
        homePage.clickOnArrivalImage(0);
        Assertions.assertEquals(driver.getCurrentUrl(), ("https://practice.automationtesting.in/product/selenium-ruby/"));
        Assertions.assertTrue(productPage.isAddToBasketButtonDisplayed());
        productPage.clickOnAddToBasketButton();
        Assertions.assertTrue(header.isItemPriceMenuDisplayed());
        Assertions.assertEquals("1 Item₹500.00", header.getItemPriceMenuText());
        header.clickOnItemPriceMenu();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://practice.automationtesting.in/basket/");
        Assertions.assertTrue(basketPage.isCheckOutButtonDisplayed());
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}