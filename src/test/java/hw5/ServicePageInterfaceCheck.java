package hw5;

import base.SelenideTestBase;
import enums.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.DifferentElementsPageSelenideForHW4;

import static com.codeborne.selenide.Selenide.*;

@Feature("Smoke tests")
@Story("Home Page and Service Page Testing - HW5")
@Listeners(AllureAttachmentListener.class)
public class ServicePageInterfaceCheck extends SelenideTestBase {

    public static final String HOME_PAGE_TITLE = "Home Page";
    public static final String DIFFERENT_ELEMENTS_PAGE_NAME = "Different Elements";
    public static final String HOME_PAGE_URL = "https://epam.github.io/JDI/";
    private DifferentElementsPageSelenideForHW4 homePage;
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        homePage = page(DifferentElementsPageSelenideForHW4.class);
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

    @Flaky
    @Test
    public void homeWork4Test() {
        //2 assert  Browser Title
        homePage.checkMainTitle(HOME_PAGE_TITLE);

        //3 Perform Login
        homePage.login(Users.PITER);

        //4 Assert User Name
        homePage.checkUserName(Users.PITER);

//        5 Click on Service subcategory in the header and check that drop down contains options
        homePage.checkHeaderOptions();

//        6 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkSidebarOptions();

        //7 Open through the header menu Service -> Different El Page
        homePage.linkDifferentElementsInHeader(DIFFERENT_ELEMENTS_PAGE_NAME);

        //8 Check interface on Different elements Page, it contains all needed elements
        homePage.checkDifferentElementsPageElements();

        //9 Assert that there is Right Section
        homePage.checkRightPanelOnDifferentElementsPage();
//
        //10 Assert that there is Left Section
        homePage.checkLeftPanelOnDifferentElementsPage();

        //11 Select checkboxes
        homePage.selectCheckBoxes(CheckBoxes.CHECK_BOXES.water);
        homePage.selectCheckBoxes(CheckBoxes.CHECK_BOXES.wind);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        homePage.validateLogState(LogCheckAndRadioBoxes.WATER_ON.parameter);
        homePage.validateLogState(LogCheckAndRadioBoxes.WIND_ON.parameter);

        //13 Select radio
        homePage.selectRadioBoxes(RadioButtons.RADIO_BOXES.selen);
//
//      //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        homePage.validateLogState(LogCheckAndRadioBoxes.SELEN_ON.parameter);
//
        //15 Select in dropdown
        homePage.selectYellowInDropdown(Colours.Yellow);
//
//      //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        homePage.validateLogState(LogCheckAndRadioBoxes.YELLOW_ON.parameter);
//
//        //17 Unselect and assert checkboxes
        homePage.selectCheckBoxes(CheckBoxes.CHECK_BOXES.water);
        homePage.selectCheckBoxes(CheckBoxes.CHECK_BOXES.wind);
//
//        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        homePage.validateLogState(LogCheckAndRadioBoxes.WATER_OFF.parameter);
        homePage.validateLogState(LogCheckAndRadioBoxes.WIND_ON.parameter);
    }
}
