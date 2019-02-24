package hw6;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "classpath:hw6",
        glue = "classpath:hw6"
)
public class RunAcceptance extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void driverSetup(){
        Configuration.browser = "Chrome";
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }
}
