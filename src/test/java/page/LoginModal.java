package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginModal extends BasePage {

    By usernameInputText = By.id("loginusername");
    By passwordInputText = By.id("loginpassword");
    By loginButton = By.cssSelector("button[onclick='logIn()']");


    public LoginModal(WebDriver driver) {
        super(driver);
    }

    public void openLoginModal() {
        HeaderPage header = new HeaderPage(this.driver);
        header.openLoginModal();
    }

    public void inputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputText));
        driver.findElement(usernameInputText).sendKeys(username);
    }

    public void inputPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputText));
        driver.findElement(passwordInputText).sendKeys(pass);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public void validateErrorMessage(String expectedMsg) {
        try {
            // Tunggu alert muncul maksimal 5 detik
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            // Ambil dan validasi isi alert
            Assert.assertEquals(alert.getText(), expectedMsg);
            // tutup alert
            alert.accept();

        } catch (NoAlertPresentException e) {
            Assert.fail("Alert tidak muncul padahal seharusnya muncul");
        } catch (Exception e) {
            Assert.fail("Gagal memverifikasi alert: " + e.getMessage());
        }
    }
}
