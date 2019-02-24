package lesson4;

import base.SelenideTestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.HomePageSelenide;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.console;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenide extends SelenideTestBase {
    @BeforeSuite
    public void beforeSuite(){
//        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }

    @Test
    public void simpleTest(){

        // Open BR
//        WebDriver driver  = new ChromeDriver();
//        driver.manage().window().maximize(); //open window in max format
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Navigate

        open("https://epam.github.io/JDI/index.html");
//        driver.navigate().to("https://epam.github.io/JDI/index.html");

        // Check PageTitle
        assertEquals(getWebDriver().getTitle(),"Home Page");
//        assertEquals(driver.getTitle(),"Home Page");

//        //login
        $(".profile-photo").click();
        $("[id = 'Name']").sendKeys("epam");
        $("[id = 'Password']").sendKeys("1234");
        $("[id = 'login-button']").click();

        $("$user-name").shouldHave(Condition.text("PITER CHAILOVSKII"));

//        // Connect and check MainTitle
        SelenideElement mainTitle = $("h3.main-title");
        mainTitle.shouldHave(Condition.text("EPAM FRAMEWORK WISHES…"));

        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

//      driver.close();
        close();
    }
}
