package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

public abstract class SeleniumBaseOtherBrows {

    private long time;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver",
                "src\\main\\resources\\chromedriver.exe");
//        setProperty("webdriver.gecko.driver",
//                "src\\main\\resources\\geckodriver.exe");
//        setProperty("webdriver.edge.driver",
//                "src\\main\\resources\\MicrosoftWebDriver.exe");
        time = currentTimeMillis();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("Test framework worked: " + (currentTimeMillis() - time) / 60 + " c");

    }
}