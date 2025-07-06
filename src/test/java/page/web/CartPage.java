package page.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCartPage() {
        driver.get("https://demoblaze.com/cart.html");
    }

    public void deleteAllItem() {
        By tbody = By.id("tbodyid");
        By deleteLink = By.xpath("//tbody[@id='tbodyid']//a[text()='Delete']");

        // Tunggu hingga tabel siap ditampilkan
        wait.until(ExpectedConditions.visibilityOfElementLocated(tbody));
        // Ambil semua elemen "Delete" di dalam table
        List<WebElement> deleteLinks = driver.findElements(deleteLink);

        while (!deleteLinks.isEmpty()) {
            // Klik "Delete" pertama
            deleteLinks.get(0).click();
            // Tunggu sampai jumlah tombol Delete berkurang
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(deleteLink, deleteLinks.size()));
            // Ambil ulang elemen "Delete"
            deleteLinks = driver.findElements(deleteLink);
        }
    }

    int countItem(String productName){
        By item = By.xpath("//tbody[@id='tbodyid']//td[contains(text(),'" + productName + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(item));
        wait.until(ExpectedConditions.visibilityOfElementLocated(item));
        List<WebElement> items = driver.findElements(item);
        return items.size();
    }

    public void clickButton(String buttonText) {
        By targetButton = By.xpath("//button[text()='" + buttonText + "']");
        wait.until(ExpectedConditions.elementToBeClickable(targetButton));
        driver.findElement(targetButton).click();
    }

    public void validateItemInCart(String productName) {
        int jumlahItem = countItem(productName);
        Assert.assertTrue(jumlahItem > 0, "Tidak ada item " + productName + " di cart");
    }

}
