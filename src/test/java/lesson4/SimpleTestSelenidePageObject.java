package lesson4;

import base.SelenideTestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenidePageObject extends SelenideTestBase {
//    private HomePageSelenide homePageSelenide;
//
//    @BeforeClass
//    public  void beforeClass(){
//        homePageSelenide = page(HomePageSelenide.class);
//    }
//
//    @AfterMethod
//    public void afterMethod(){
//        close();
//    }
//
//    @Flaky
//    @Issue("id of the task")
//    @Test
//    public void simpleTest(){
//
//        // Navigate
//        homePageSelenide.openPage();
//
//        // Check PageTitle
//        homePageSelenide.checkTitle();
////        //login
//        homePageSelenide.login("epam","1234");
////        $(".profile-photo").click();
////        $("[id = 'Name']").sendKeys("epam");
////        $("[id = 'Password']").sendKeys("1234");
////        $(".login [type = 'submit']").click();
//
////        // Connect and check MainTitle
////        SelenideElement mainTitle = $("h3.main-title");
////        mainTitle.shouldHave(Condition.text("EPAM FRAMEWORK WISHES…"));
//        homePageSelenide.checkMainText();
//
//    }
}
