package page.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.Constants;

public class HomePage extends BasePage{

    HeaderPage header;

    By categoryHeader = By.id("cat");

    public HomePage(WebDriver driver) {
        super(driver);
        header = new HeaderPage(driver);
        driver.get(Constants.BASE_DEMOBLAZE);
    }

    public void openHomePage() {
        driver.get(Constants.BASE_DEMOBLAZE);
    }

    public void clickProduct(String productName) {
        By productLink = By.xpath("//a[text()='" + productName + "']");
        wait.until(ExpectedConditions.presenceOfElementLocated(productLink));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLink));
        driver.findElement(productLink).click();
    }

    public void logout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(header.logoutLink));
        driver.findElement(header.logoutLink).click();
        handleAlert();
    }

    public void validateLoggedOut() {
        wait.until(ExpectedConditions.presenceOfElementLocated(header.loginLink));
        wait.until(ExpectedConditions.visibilityOfElementLocated(header.loginLink));
        Assert.assertFalse(driver.findElement(header.logoutLink).isDisplayed(), "Logout Link msh terlihat");
        Assert.assertTrue(driver.findElement(header.loginLink).isDisplayed(), "Login link tidak terlihat");
    }

    public void validateLoggedIn(String expectedMsg) {
        wait.until(ExpectedConditions.presenceOfElementLocated(header.logoutLink));
        wait.until(ExpectedConditions.visibilityOfElementLocated(header.logoutLink));

        Assert.assertTrue(driver.findElement(header.logoutLink).isDisplayed(), "Logout Link tidak terlihat");
        WebElement welcomeUser = driver.findElement(header.welcomeMessage);
        Assert.assertEquals(welcomeUser.getText(), expectedMsg);
    }

    public void validateInHomepage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(categoryHeader));
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryHeader));
        Assert.assertTrue(driver.findElement(categoryHeader).isDisplayed(), "Category tidak terlihat");
    }
}
