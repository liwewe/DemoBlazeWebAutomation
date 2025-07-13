package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/web",           // Lokasi file .feature
        glue = "stepdef/web",                     // Package berisi Step Definitions
        plugin = {
                "pretty",
                "html:reports/web/web-report.html",        // Output HTML
                "json:reports/web/web-report.json" //,                // Output JSON
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Untuk Allure report
        },
//        monochrome = true,
        tags = "@web"                                     // Bisa disesuaikan
)

@Test
public class TestRunnerWeb extends AbstractTestNGCucumberTests {

}
