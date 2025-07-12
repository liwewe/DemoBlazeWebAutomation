package page.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.regex.Pattern;

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

    public void validateTotalCheckout(int expectedValue) {
        By total = By.id("totalm");
        wait.until(ExpectedConditions.textMatches(total, Pattern.compile("\\d+")));
        WebElement totalObj = driver.findElement(total);
        Assert.assertEquals(totalObj.getText(), "Total: " + expectedValue);
    }

    public void fillUserDetails() {
        By nameLocator = By.id("name");
        By ccLocator = By.id("card");
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ccLocator));
        driver.findElement(nameLocator).sendKeys("linjoo");
        driver.findElement(ccLocator).sendKeys("321");
    }

    public void isThankyouModalOpen() {
        By modalLocator = By.className("sweet-alert");
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalLocator));
        WebElement modal = driver.findElement(modalLocator);
        Assert.assertTrue(modal.isDisplayed());
        clickButton("OK");
    }
}
