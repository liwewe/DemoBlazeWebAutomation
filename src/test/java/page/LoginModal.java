package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginModal extends BasePage {

    By usernameInputText = By.id("loginusername");
    By passwordInputText = By.id("loginpassword");
    By loginButton = By.cssSelector("button[onclick='logIn()']");

    HeaderPage header = new HeaderPage(driver);

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    public void openLoginModal() {
        driver.get("https://demoblaze.com/");
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public void waitLoggedIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(header.logoutLink));
    }

    public boolean isLoggedIn() {
        try {
            return driver.findElement(header.logoutLink).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
