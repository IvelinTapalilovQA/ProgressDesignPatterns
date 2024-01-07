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
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class BookStoreBaseFourFive {

    static WebDriver driver;
    static Header header;
    static HomePage homePage;
    static PersonalDataModal personalDataModal;
    static ProductPage productPage;
    static ShopPage shopPage;

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
    }

//    Test case 4&5 - Homepage - Arrivals - Images - Reviews - Description
//    1) Open the browser
//    2) Enter the URL “http://practice.automationtesting.in/”
//    3) Click on Shop Menu
//    4) Now click on Home menu button
//    5) Test whether the Home page has Three Arrivals only
//    6) The Home page must contain only three Arrivals
//    7) Now click the image in the Arrivals
//    8) Test whether it is navigating to next page where the user can add that book into his basket.
//    9) Image should be clickable and should navigate to next page where user can add that book to his basket
//    10) Now clock on Reviews tab for the book you clicked on.
//    11) There should be a Reviews regarding that book the user clicked on
//    12) Click on Description tab for the book you clicked on.
//    13) There should be a description regarding that book the user clicked on

    @Test
    public void testArrivalsReviewsDescription() {

        homePage.loadPage();
        personalDataModal.clickOnCancelButton();
        header.clickOnShopButton();
        shopPage.clickOnHomeButton();
        Assertions.assertEquals(3, homePage.getCountNewArrivals());
        homePage.clickOnArrivalImage(0);
        Assertions.assertEquals("https://practice.automationtesting.in/product/selenium-ruby/", driver.getCurrentUrl());
        Assertions.assertTrue(productPage.isAddToBasketButtonDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");

        productPage.clickOnReviewsTab();
        Assertions.assertEquals("Reviews\n" +
                "There are no reviews yet." ,productPage.getReviewsSectionText());
        productPage.clickOnDescriptionTab();
        Assertions.assertEquals("Product Description\n" +
                "The Selenium WebDriver Recipes book is a quick " +
                "problem-solving guide to automated testing web " +
                "applications with Selenium WebDriver. It contains " +
                "hundreds of solutions to real-world problems, with clear" +
                " explanations and ready-to-run test scripts you can use " +
                "in your own projects.", productPage.getProductDescription());
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
