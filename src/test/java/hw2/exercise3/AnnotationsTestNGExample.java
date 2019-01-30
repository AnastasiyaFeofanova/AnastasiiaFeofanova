package hw2.exercise3;

import base.SeleniumBase;
import dataProviders.Exercise1DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

public class AnnotationsTestNGExample extends SeleniumBase {

    private WebDriver driver;
    private long time;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver",
                "src\\main\\resources\\chromedriver.exe");
        time = currentTimeMillis();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println(driver.getTitle());
        driver.close();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("Test framework worked: " + (currentTimeMillis() - time) / 60 + " c");
    }

    @Test(dataProvider = "exercise1DataProvider", dataProviderClass = Exercise1DataProvider.class, groups = "Ex3")
    public void annotationsTestNGExample(int i, String s) {

        // Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

/*1.	Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page
 -https://epam.github.io/JDI/index.html. The test must be developed with help of the DataProvider.
 Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.*/
        List<WebElement> benefitText = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(benefitText.size(), 4);
        Assert.assertEquals(benefitText.get(i).getText(), s);
    }
}
