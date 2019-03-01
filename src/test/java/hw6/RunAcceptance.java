package hw6;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.close;

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
    @After
    public void after(){
        close();
    }
}
