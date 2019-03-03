package jdi.lesson1;

import base.jdi.JDISite;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static base.jdi.entities.User.PETER;

public class JdiSimpleExample {
    //    WebDriver driver;
//    IndexPage indexPageJdi;
    @BeforeSuite
    public void beforeSuite() {
        //LogLevels.
        PageFactory.initElements((JDISite.class));
        //indexPageJdi = PageFactory.initElements(driver, IndexPage.class);
        // WebSettings.SEARCH_CONDITION = e

        //ActionHelper.BEFORE_JDI_ACTION = jp -> {};

//        ActionHelper.AFTER_JDI_ACTION = (jp, o) -> {
//                return ActionHelper.AFTER_JDI_ACTION =
//
//        };
    }

    @Test
    public void simpleJdiTest() {
        JDISite.indexPageJdi.open();
        JDISite.indexPageJdi.login(PETER);
        //indexPageJdi.login("epam", "1234");
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

}