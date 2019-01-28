package lesson2;


import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SimpleTestInvocationCount extends SeleniumBase {

    @Test (invocationCount = 3, threadPoolSize = 3)
    public void simpleTest() {
        // Open WB
       WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        // Check PageTitle
        assertEquals(driver.getTitle(),"Home Page");

//        //login
        driver.findElement (By.cssSelector("[id = 'user-icon']")).click();
        driver.findElement (By.cssSelector("[id = 'name']")).sendKeys("epam");
        driver.findElement (By.cssSelector("[id = 'password']")).sendKeys("1234");
        driver.findElement (By.cssSelector("[id = 'login-button']")).click();

//        // Connect and check MainTitle
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));

        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        SoftAssert softAssert = new SoftAssert();
//        WebElement element = driver.findElement (By.id("submit-id"));
//        softAssert.assertTrue(element.isDisplayed());
//
        // Close WB
        driver.close();
    }

}

