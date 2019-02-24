package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

// TODO Pay attention on code convention, reformat it via IDEA
public abstract class SeleniumBase {

    private long time;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver",
                "src\\main\\resources\\chromedriver.exe");
        time = currentTimeMillis();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("Test framework worked: " + (currentTimeMillis() - time) / 60 + " c");

    }
}