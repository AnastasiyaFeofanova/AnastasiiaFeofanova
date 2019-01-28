package lesson2;


import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTest extends SeleniumBase {

    private WebDriver driver;

//    @BeforeClass
//    public void beforeClass(){
//        setProperty("webdriver.chrome.driver",
//                "src\\main\\resources\\chromedriver.exe");
//    }

    @BeforeMethod(alwaysRun = true)
    public  void beforeMethod() {
            driver  = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }


    @Test (invocationCount = 2, groups = "Group1")
    public void simpleTest() {

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

        assertEquals(mainTitle.getAttribute("innerHTML"), "EPAM framework Wishes…");

//        SoftAssert softAssert = new SoftAssert();
//        WebElement element = driver.findElement (By.cssSelector("[id = 'submit-id']"));
//        softAssert.assertTrue(element.isDisplayed());
    }

}

