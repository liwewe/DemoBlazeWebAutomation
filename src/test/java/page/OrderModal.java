package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class OrderModal extends BasePage {

    public OrderModal(WebDriver driver) {
        super(driver);
    }

    public void validateIsOpen() {
        By form = By.id("orderModalLabel");
        wait.until(ExpectedConditions.visibilityOfElementLocated(form));
        Assert.assertTrue(driver.findElement(form).isDisplayed(), "Form order seharusnya muncul");
    }
}
