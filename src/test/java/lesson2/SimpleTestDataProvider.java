package lesson2;


import base.SeleniumBase;
import dataProviders.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestDataProvider extends SeleniumBase {


        @Test(dataProvider = "simpleDataProvider", dataProviderClass = DataProvider.class)
        public void simpleTest(String s, int i){


            // Open BR
            WebDriver driver  = new ChromeDriver();
            driver.manage().window().maximize(); //open window in max format
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            // Navigate
            driver.navigate().to("https://epam.github.io/JDI/index.html");

            // Check PageTitle
            assertEquals(driver.getTitle(),"Home Page");

       //login
        driver.findElement (By.cssSelector("[id = 'user-icon']")).click();
        driver.findElement (By.cssSelector("[id = 'name']")).sendKeys("epam");
        driver.findElement (By.cssSelector("[id = 'password']")).sendKeys("1234");
        driver.findElement (By.cssSelector("[id = 'login-button']")).click();

//        // Connect and check MainTitle
            WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));

            assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

            driver.close();
            System.out.println("String: "+ s + ", int: "+ i);
        }

}

