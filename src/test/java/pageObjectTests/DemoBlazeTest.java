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
import pageObject.ProductStore.*;

public class DemoBlazeTest {

    static WebDriver driver;
    static HomePage homePage;
    static Header header;
    static SignUpModal signUpModal;
    static AlertsPage alertsPage;
    static LoginModal loginModal;
    static CartPage cartPage;
    static OrderModal orderModal;
    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        header = new Header(driver);
        signUpModal = new SignUpModal(driver);
        alertsPage = new AlertsPage(driver);
        loginModal = new LoginModal(driver);
        cartPage = new CartPage(driver);
        orderModal = new OrderModal(driver);
    }

    @Test
    public void testMakeOrder() {

        homePage.loadPage();
        homePage.isPageLoaded();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        homePage.choiceCategory("Monitors");
        js.executeScript("window.scrollBy(0,250)", "");
        homePage.choiceItem(0);
        homePage.addToCartButton();
        Assertions.assertEquals(alertsPage.getAlertText(), "Product added");
        alertsPage.acceptAlert();

        header.clickOnCartLink();

        Assertions.assertEquals("Apple monitor 24", cartPage.getAddedProductByIndex(0));
        cartPage.clickOnPlaceOrderButton();

        orderModal.enterName("User");
        orderModal.enterCountry("UK");
        orderModal.enterCity("London");
        orderModal.enterCreditCardInfo("123456789");
        orderModal.enterMonth("06");
        orderModal.enterYear("2023");
        orderModal.clickOnPurchase();
        Assertions.assertEquals("Thank you for your purchase!", orderModal.getOrderAlertText());
        orderModal.clickOnFinishedOrderWindowButton();
    }

    @Test
    public void testSignUp(){

        homePage.loadPage();
        Assertions.assertTrue(homePage.isPageLoaded());

        header.clickOnSignUpLink();

        Assertions.assertTrue(signUpModal.isSignUpTitleDisplayed());
        String username = generateRandomString(6, 10);
        signUpModal.enterUsername(username);
        String randomPassword = generateRandomString(6,10);
        signUpModal.enterPassword(randomPassword);
        signUpModal.clickOnSignUpButton();

        Assertions.assertEquals(alertsPage.getAlertText(), "Sign up successful.");
        alertsPage.acceptAlert();
    }

    @Test
    public void testLogin(){

        homePage.loadPage();
        Assertions.assertTrue(homePage.isPageLoaded());

        header.clickOnLoginLink();

        Assertions.assertTrue(loginModal.isLoginTitleDisplayed());
        loginModal.enterUsername("testacc143");
        loginModal.enterPassword("Testacc143");
        loginModal.clickOnLoginButton();

        Assertions.assertTrue(header.isUserWelcomeLinkDisplayed());
    }
    public String generateRandomString(int minLengthInclusive, int maxLengthInclusive){
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }
}