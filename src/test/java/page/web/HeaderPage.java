package page.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {

    protected HeaderPage(WebDriver driver) {
        super(driver);
    }

    By signupLink = By.id("signin2");
    By loginLink = By.id("login2");
    By logoutLink = By.id("logout2");
    By welcomeMessage = By.id("nameofuser");

    protected void openSignupModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupLink));
        driver.findElement(signupLink).click();
    }

    protected void openLoginModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
        driver.findElement(loginLink).click();
    }

    protected void waitLoggedIn(){
        handleAlert();
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutLink));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
    }
}
