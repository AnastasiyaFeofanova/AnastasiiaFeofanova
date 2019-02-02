package lesson3;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SimpleTestPageObject extends SeleniumBase {

        private WebDriver driver;
        private HomePage homePage;
//        private HomePageLocal homePage;

        @BeforeClass
        public  void beforeClass(){
            driver=new ChromeDriver();
            homePage = PageFactory.initElements(driver, HomePage.class);
        }

        @BeforeMethod(alwaysRun = true)
        public  void beforeMethod() {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//            homePage = new HomePageLocal(driver);
        }

        @AfterMethod(alwaysRun = true)
        public void afterMethod() {
            driver.close();
        }

        @Test
        public void simpleTest() {

            // Navigate
            homePage.open("https://epam.github.io/JDI/index.html");

            // Check PageTitle
            assertEquals(driver.getTitle(),"Home Page");

//        //login
            homePage.login("epam", "1234");

//        // Connect and check MainTitle
            WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
            assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        }
    }
