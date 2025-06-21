package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    By signupLink = By.id("signin2");
    By loginLink = By.id("login2");
    By logoutLink = By.id("logout2");
    By welcomeMessage = By.id("nameofuser");

    public void openSignupModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupLink));
        driver.findElement(signupLink).click();
    }

    public void openLoginModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
        driver.findElement(loginLink).click();
    }

    public void validateLoggedIn(String expectedMsg) {
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutLink));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));


        Assert.assertTrue(driver.findElement(logoutLink).isDisplayed(), "Logout Link tidak terlihat");
        WebElement welcomeUser = driver.findElement(welcomeMessage);
        Assert.assertEquals(welcomeUser.getText(), expectedMsg);
    }
}
