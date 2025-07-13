package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/api",           // Lokasi file .feature
        glue = "stepdef/api",                     // Package berisi Step Definitions
        plugin = {
                "pretty",
                "html:reports/api-report.html",        // Output HTML
                "json:reports/api-report.json" //,                // Output JSON
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Untuk Allure report
        },
//        monochrome = true,
        tags = "@api"                                     // Bisa disesuaikan
)

@Test
public class TestRunnerApi extends AbstractTestNGCucumberTests{

}
