package hw4;

import base.SelenideTestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenideForHW4;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomeWork4 extends SelenideTestBase {

    private HomePageSelenideForHW4 homePage;
    private WebDriver driver;
    List<String> text = Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLES WITH WAGES", "DIFFERENT ELEMENTS");


    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenideForHW4.class);
    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @AfterMethod
    public void afterMethod() {
    }

    @Test
    public void homeWork4Test() {
        //1 Open site
        open("https://epam.github.io/JDI/");

        //2 assert  Browser Title
        assertEquals(getWebDriver().getTitle(), "Home Page");
        homePage.checkBrowserTitle("Home Page");

        //3 Perform Login
        homePage.login("epam", "1234");

        //4 Assert User Name

        homePage.CheckUserName("Piter Chailovskii".toUpperCase());

        //5 Click on Service subcategory in the header and check that drop down contains options

//        homePage.CheckHeaderOptions("SUPPORT");

        //6 Click on Service subcategory in the left section and check that drop down contains options

//        homePage.CheckLeftMenuOptions();

        //7 Open through the header menu Service -> Different El Page
        homePage.LinkDifferentElementsInHeader();

        //8 Check interface on Different elements Page, it contains all needed elements



    }
}
