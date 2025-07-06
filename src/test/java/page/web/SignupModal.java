package page.web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SignupModal extends BasePage {

    By usernameInputText = By.id("sign-username");
    By passwordInputText = By.id("sign-password");
    By signupButton = By.cssSelector("button[onclick='register()']");

    public SignupModal(WebDriver driver) {
        super(driver);
    }

    public void openSignupModal() {
        driver.get("https://demoblaze.com/");
        HeaderPage header = new HeaderPage(this.driver);
        header.openSignupModal();
    }

    public void inputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputText));
        driver.findElement(usernameInputText).sendKeys(username);
    }

    public void inputPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputText));
        driver.findElement(passwordInputText).sendKeys(pass);
    }

    public void clickSignupButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupButton));
        driver.findElement(signupButton).click();
    }

    public void validateErrorMessage(String expectedMsg) {
        try {
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