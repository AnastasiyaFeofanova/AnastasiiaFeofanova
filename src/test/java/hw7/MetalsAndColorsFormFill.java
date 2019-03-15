package hw7;

import com.epam.jdi.light.ui.html.PageFactory;
import hw7.entities.HeaderMenuNavigation;
import hw7.entities.Results;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.close;
import static hw7.entities.MetalsColorsData.*;
import static hw7.entities.User.PITER;

public class MetalsAndColorsFormFill {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(Site.class);
    }

    @AfterSuite
    public void afterSuite() {
        close();
    }

    @Test
    public void metalsAndColorsFormFill() {
        // 1. Login on JDI site as User
        Site.indexPage.open();
        Site.indexPage.login(PITER);
        Site.indexPage.checkUserName(PITER);

        //2. Open Metals & Colors page by Header menu
        Site.indexPage.linkMetalsAndColors(HeaderMenuNavigation.METALS_AND_COLORS);

        //3 Fill form Metals & Colors by data
        Site.metalsAndColorsPage.fillForm(DATA);

        //4. Submit form Metals & Colors
        Site.metalsAndColorsPage.submit();

        //5. Result sections should contains data
        Site.metalsAndColorsPage.checkResults(Results.getResults());
    }
}
