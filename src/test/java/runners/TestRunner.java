package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",           // Lokasi file .feature
        glue = "stepdef",                     // Package berisi Step Definitions
        plugin = {
                "pretty",
                "html:reports/test-report.html",        // Output HTML
                "json:reports/test-report.json",                // Output JSON
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Untuk Allure report
        } //,
//        monochrome = true,
//        tags = "@smoke"                                     // Bisa disesuaikan
)

@Test
public class TestRunner extends AbstractTestNGCucumberTests {

}
