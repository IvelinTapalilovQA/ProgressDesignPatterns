package pageObject.ProductStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By addedProduct = By.xpath("//tr[@class='success']/td[2]");
    private final By placeOrderButton = By.xpath("//button[@class='btn btn-success']");

    public String getAddedProductByIndex(int index){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedProduct));
        List<WebElement> addedProducts = driver.findElements(addedProduct);
        return addedProducts.get(index).getText();
    }
    public void clickOnPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
    }
}
