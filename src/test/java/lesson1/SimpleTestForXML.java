package lesson1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestForXML {

    @BeforeClass
    public void beforeClass(){
        setProperty("webdriver.chrome.driver",
                "src\\main\\resources\\chromedriver.exe");
    }
    @Test(groups = "Group1")
    public void simpleTest(){

        // Open BR
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize(); //open window in max format
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        String handler = driver.getWindowHandle();
        driver.switchTo().window(handler);

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

//        SoftAssert softAssert = new SoftAssert();
//        WebElement element = driver.findElement (By.id("submit-id"));
//        softAssert.assertTrue(element.isDisplayed());

        driver.close();
    }

    @Test(groups = "Group1")
    public void simpleTest1(){

        // Open BR
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize(); //open window in max format
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        String handler = driver.getWindowHandle();
        driver.switchTo().window(handler);

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

//        SoftAssert softAssert = new SoftAssert();
//        WebElement element = driver.findElement (By.id("submit-id"));
//        softAssert.assertTrue(element.isDisplayed());

        driver.close();
    }
    @Test(groups = "Group1")
    public void simpleTest2(){

        // Open BR
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize(); //open window in max format
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        String handler = driver.getWindowHandle();
        driver.switchTo().window(handler);

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

//        SoftAssert softAssert = new SoftAssert();
//        WebElement element = driver.findElement (By.id("submit-id"));
//        softAssert.assertTrue(element.isDisplayed());

        driver.close();
    }

}
