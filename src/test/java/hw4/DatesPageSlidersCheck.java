package hw4;

import base.SelenideTestBase;
import enums.Users;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.DatesPageSelenideForHW4;
import pageObjects.HomePageSelenideForHW4;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

    @Feature("Smoke tests")
    @Story("Dates Page Testing - HW4")
    @Listeners(AllureAttachmentListener.class)
    public class DatesPageSlidersCheck extends SelenideTestBase {

    public static final String HOME_PAGE_TITLE = "Home Page";
    public static final String USER_NAME = "Piter Chailovskii";
    public static final String DIFFERENT_ELEMENTS_PAGE_NAME = "Different Elements";
    public static final String HOME_PAGE_URL = "https://epam.github.io/JDI/";
    private DatesPageSelenideForHW4 datesPage;
    private WebDriver driver;
    List<String> login = Arrays.asList("epam", "1234");

    @BeforeClass
    public void beforeClass() {
        datesPage = page(DatesPageSelenideForHW4.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        //1 Open site
        open(HOME_PAGE_URL);
    }

//    @AfterMethod
//    public void afterMethod() {
//     //   close();
//    }

    @Test
    public void homeWork4Test() {
        //2 assert  Browser Title
        datesPage.checkMainTitle(HOME_PAGE_TITLE);

        //3 Perform Login
        datesPage.login(Users.PITER);

        //4 Assert User Name
        datesPage.CheckUserName(Users.PITER);
//        5 Open through the header menu Service -> Dates Page
        datesPage.openDatesPage();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position

        datesPage.moveSlider(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.ValidateSliderLog("0", "100");

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.moveSlider(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.ValidateSliderLog("0", "0");

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.moveSlider(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.ValidateSliderLog("100", "100");

        //12 Using drag-and-drop set Range sliders.
        datesPage.moveSlider(30, 70);
    }
}
