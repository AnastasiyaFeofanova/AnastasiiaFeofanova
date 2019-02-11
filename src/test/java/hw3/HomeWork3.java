package hw3;

import base.SeleniumBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePageForHW3;

import java.util.Arrays;
import java.util.List;

@Feature("Smoke tests")
@Story("Home Page Testing")
@Listeners(AllureAttachmentListener.class)
public class HomeWork3 extends SeleniumBase {

    public static final String INDEX_HTML_URL = "https://epam.github.io/JDI/";
    public static final String HOME_PAGE_TITLE = "Home Page";
    public static final String USER_NAME = "PITER CHAILOVSKII";
    public static final String SUB_HEADER_TEXT = "JDI GITHUB";
    public static final String GITHUB_URL = "https://github.com/epam/JDI";
    public static final String LINK_ATTRIBUTE = "href";

    List<String> loginData = Arrays.asList("epam", "1234");

    List<String> homePageHeaderNavigationItems = Arrays.asList(
            "HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS"
    );

    List<String> textIndexPageUnderIcons = Arrays.asList(
            "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM project",
            "To be flexible and\n" +
                    "customizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
    );

    List<String> mainContentTexts = Arrays.asList(
            "EPAM FRAMEWORK WISHES…",
            "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT "+
                    "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT "+
                    "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."
    );

    private WebDriver driver;
    private HomePageForHW3 homePage;

    @BeforeClass
    public  void beforeClass() {
        driver = new ChromeDriver();
    }

    @Flaky
    @Test()
    public void pageObjectExample() {
        homePage= PageFactory.initElements(driver, HomePageForHW3.class);
        // open page
        homePage.openHomePage(INDEX_HTML_URL);

        //3 login
        homePage.login(loginData);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName(USER_NAME);

        //5 Assert Browser title
        homePage.checkTitle(driver, HOME_PAGE_TITLE);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkHeader(homePageHeaderNavigationItems);
//
        //7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkImagesIsDisplayed();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkIndexPage(textIndexPageUnderIcons);

        //9 Assert a text of the main header
        homePage.checkMainContent(mainContentTexts);

//        //10 Assert that there is the iframe in the center of page
        homePage.checkIframe();

//        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.checkIFrameLogo(driver);

        //12 Switch to original window back
        homePage.openHomePage(INDEX_HTML_URL);

//        //13 Assert a text of the sub header
         homePage.checkSubHeaderText(SUB_HEADER_TEXT);

//        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkLink(LINK_ATTRIBUTE, GITHUB_URL);

//        //15 Assert that there is Left Section
        homePage.checkleftSection();

//        //16 Assert that there is Footer
        homePage.checkfooter();

        //17 close
        homePage.close();
    }
}

