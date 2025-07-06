package page.web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(7));
    }

    public void handleAlert(String expectedMsg) {
        String actualMsg = getAlertTextIfExists();
        Assert.assertNotNull(actualMsg, "Alert tidak muncul");
        Assert.assertEquals(actualMsg, expectedMsg, "Pesan alert tidak sesuai");
        acceptAlertIfExists(); // baru ditutup setelah dicek
//        try {
//            // Tunggu alert muncul
//            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//            // Ambil dan validasi isi alert
//            Assert.assertEquals(alert.getText(), expectedMsg);
//            // tutup alert
//            alert.accept();
//        } catch (NoAlertPresentException e) {
//            Assert.fail("Alert tidak muncul padahal seharusnya muncul");
//        } catch (Exception e) {
//            Assert.fail("Gagal memverifikasi alert: " + e.getMessage());
//        }
    }

    public String getAlertTextIfExists() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            return alert.getText();
        } catch (TimeoutException e) {
            return null;
        }
    }

    public void acceptAlertIfExists() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (TimeoutException ignored) {
            // tidak ada alert
        }
    }

    public void handleAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("ALERT FOUND: " + alert.getText());
            alert.accept(); // atau dismiss() jika perlu
        } catch (TimeoutException e) {
//            System.out.println("Tidak ada alert setelah login.");
            System.out.println("Page setelah login: " + driver.getCurrentUrl());
        }
    }
}
