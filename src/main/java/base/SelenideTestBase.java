package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class SelenideTestBase {
    @BeforeSuite
    public void beforeSuite(){
        Configuration.browser = "Chrome";
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }
}
