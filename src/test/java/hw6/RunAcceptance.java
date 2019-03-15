package hw6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(
        features = "classpath:hw6", tags = {"@ServicePagInterfaceBDD, @UserTablePageTest"},
        glue = "classpath:hw6"
)
public class RunAcceptance extends AbstractTestNGCucumberTests {
    @BeforeMethod
        public void driverSetup(){
        Configuration.browserPosition = "C:\\SeleniumDrivers";
        Configuration.browserVersion ="2.42";
        Configuration.browser = "Chrome";
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }
    @AfterMethod
    public void afterMethod(){
        close();
    }
}
