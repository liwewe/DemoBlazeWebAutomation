package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    By atcButton = By.cssSelector("a.btn.btn-success.btn-lg");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void openProduct(String productId) {
        driver.get("https://demoblaze.com/prod.html?idp_=" + productId);
    }

    public void addProductToCart() {
        wait.until(ExpectedConditions.presenceOfElementLocated(atcButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(atcButton));
        driver.findElement(atcButton).click();
    }

}
