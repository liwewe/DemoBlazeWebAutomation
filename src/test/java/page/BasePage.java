package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        driver.get("https://demoblaze.com/");
    }

    public void handleAlertIfExists() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("ALERT FOUND: " + alert.getText());
            alert.accept(); // atau dismiss() jika perlu
        } catch (TimeoutException e) {
            System.out.println("Tidak ada alert setelah login.");
            System.out.println("Page setelah login: " + driver.getCurrentUrl());
        }
    }

}
