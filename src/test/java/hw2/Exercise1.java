package hw2;

import base.SeleniumBase;
import dataProviders.Exercise1DataProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class Exercise1 extends SeleniumBase {

    private WebDriver driver;
    @BeforeMethod
    public  void beforeMethod() {
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
       if (driver != null) {driver.quit();}
    }

    @Test(dataProvider = "exersise1DataProvider", dataProviderClass = Exercise1DataProvider.class)
    //----------------------------------------------------------------------------------------------------------------
    public void exersise1(int i, String s) {

//1.	Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page
// -https://epam.github.io/JDI/index.html. The test must be developed with help of the DataProvider.
// Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.
        List<WebElement> benefitText = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(benefitText.size(), 4);
        Assert.assertEquals(benefitText.get(i).getText(), s);
    }
}
