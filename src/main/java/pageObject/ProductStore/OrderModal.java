package pageObject.ProductStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderModal {

    WebDriver driver;

    public OrderModal(WebDriver driver){
        this.driver = driver;
    }
    //locator
    private final By orderModalTitle = By.id("orderModalLabel");
    private final By nameField = By.id("name");
    private final By countryField = By.id("country");
    private final By cityField = By.id("city");
    private final By creditCardField = By.id("card");
    private final By monthField = By.id("month");
    private final By yearField = By.id("year");
    private final By purchaseButton = By.xpath("//button[@onclick='purchaseOrder()']");

    private final By finishedOrderWindowButton = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");
    private final By finishOrderWindowTitle = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/h2");
    //Action Method

    public boolean isOrderModalTitleDisplayed(){
        return driver.findElement(orderModalTitle).isDisplayed();
    }
    public void enterName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void enterCountry(String country){
        driver.findElement(countryField).sendKeys(country);
    }
    public void enterCity(String city){
        driver.findElement(cityField).sendKeys(city);
    }
    public void enterCreditCardInfo(String info){
        driver.findElement(creditCardField).sendKeys(info);
    }
    public void enterMonth(String month){
        driver.findElement(monthField).sendKeys(month);
    }
    public void enterYear(String year){
        driver.findElement(yearField).sendKeys(year);
    }
    public void clickOnPurchase(){
        driver.findElement(purchaseButton).click();
    }
    public String getOrderAlertText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishOrderWindowTitle));
        return driver.findElement(finishOrderWindowTitle).getText();
    }
    public void clickOnFinishedOrderWindowButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishedOrderWindowButton));
        driver.findElement(finishedOrderWindowButton).click();
    }
}
