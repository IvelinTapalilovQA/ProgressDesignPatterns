package pageObject.ProductStore;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;

    private final String PAGE_URL = "https://www.demoblaze.com/index.html";
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By categoriesLocator = By.id("itemc");

    private final By nextPageButton = By.id("next2");
    private final By previusPageButton = By.id("prev2");
    private final By itemLocator = By.xpath("//a[@class='hrefch']");

    private final By addToCardLocator = By.xpath("//a[@class='btn btn-success btn-lg']");
    public void loadPage(){
        driver.get(PAGE_URL);
    }

    public boolean isPageLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void choiceCategory(String targetCategory){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesLocator));
        List<WebElement> categories = driver.findElements(categoriesLocator);
        for (WebElement category : categories){
            if(targetCategory.equals(category.getText())){
                category.click();
            }
        }
    }

    public void choiceItem(int index){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
        List<WebElement> itemsList = driver.findElements(itemLocator);
        WebElement item = itemsList.get(index);
        item.click();
    }

    public void addToCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCardLocator));
        driver.findElement(addToCardLocator).click();
    }
}
