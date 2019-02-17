package hw4;

import base.SelenideTestBase;
import com.codeborne.selenide.commands.Click;
import enums.CheckBoxes;
import enums.Colours;
import enums.RadioButtons;
import enums.Users;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePageSelenideForHW4;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
@Feature("Smoke tests")
@Story("Home Page and Service Page Testing - HW4")
@Listeners(AllureAttachmentListener.class)
public class ServicePageInterfaceCheck extends SelenideTestBase {

    public static final String HOME_PAGE_TITLE = "Home Page";
    public static final String DIFFERENT_ELEMENTS_PAGE_NAME = "Different Elements";
    public static final String HOME_PAGE_URL = "https://epam.github.io/JDI/";
    private HomePageSelenideForHW4 homePage;

    // TODO ???
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenideForHW4.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        //1 Open site
        open(HOME_PAGE_URL);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void homeWork4Test() {
        //2 assert  Browser Title
        homePage.checkMainTitle(HOME_PAGE_TITLE);

        //3 Perform Login
        homePage.login(Users.PITER);

        //4 Assert User Name
        homePage.CheckUserName(Users.PITER);

//        5 Click on Service subcategory in the header and check that drop down contains options
        homePage.CheckHeaderOptions();

//        6 Click on Service subcategory in the left section and check that drop down contains options
        homePage.CheckSidebarOptions();

        //7 Open through the header menu Service -> Different El Page
        homePage.LinkDifferentElementsInHeader(DIFFERENT_ELEMENTS_PAGE_NAME);

        //8 Check interface on Different elements Page, it contains all needed elements
        homePage.CheckDifferentElementsPageElements();

        //9 Assert that there is Right Section
        homePage.CheckRightPanelOnDifferentElementsPage();
//
        //10 Assert that there is Left Section
        homePage.CheckLeftPanelOnDifferentElementsPage();

        //11 Select checkboxes
        homePage.SelectCheckBoxes();

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        //homePage.ValidateCheckBoxStateOn();
        homePage.ValidateCheckBoxStateOnParam(CheckBoxes.Water);
        homePage.ValidateCheckBoxStateOnParam(CheckBoxes.Wind);

        //13 Select radio
        homePage.SelectRadioBoxes();

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        homePage.ValidateRadioButtonsStateOn(RadioButtons.Selen);
        homePage.ValidateRadioButtonsStateOn(RadioButtons.Silver);

        //15 Select in dropdown
        homePage.SelectYellowInDropdown();

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        homePage.ValidateColorsParam(Colours.Yellow);

        //17 Unselect and assert checkboxes
        homePage.SelectCheckBoxes();

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        homePage.ValidateCheckBoxStateOff(CheckBoxes.Water);
        homePage.ValidateCheckBoxStateOff(CheckBoxes.Wind);
    }
}
