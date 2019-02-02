package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenide {
    @Test
    public void simpleTest(){
        setProperty("webdriver.chrome.driver",
                "src\\main\\resources\\chromedriver.exe");

        // Open BR
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize(); //open window in max format
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        // Check PageTitle
        assertEquals(driver.getTitle(),"Home Page");

//        //login
        driver.findElement (By.cssSelector(".profile-photo")).click();
        driver.findElement (By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement (By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement (By.cssSelector(".login [type = 'submit']")).click();

//        // Connect and check MainTitle
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));

        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

//        SoftAssert softAssert = new SoftAssert();
//        WebElement element = driver.findElement (By.id("submit-id"));
//        softAssert.assertTrue(element.isDisplayed());

        driver.close();
    }
}
