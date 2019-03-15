package hw8;

import com.epam.jdi.light.ui.html.PageFactory;
import hw8.entities.HeaderMenuNavigation;
import hw8.entities.Results;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.epam.jdi.light.driver.WebDriverFactory.close;
import static hw8.entities.User.PITER;

public class MetalsAndColorsFormFill {
    public MetalsAndColorsFormFill() throws FileNotFoundException {
    }

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(Site.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test(dataProvider = "HW8DP", dataProviderClass = HW8DataProvider.class)
    public void metalsAndColorsFormFill(String key, MetalsColors parameters) {

        // 1. Login on JDI site as User
        Site.indexPage.open();
        Site.indexPage.login(PITER);
        Site.indexPage.checkUserName(PITER);

        //2. Open Metals & Colors page by Header menu
        Site.indexPage.linkMetalsAndColors(HeaderMenuNavigation.metalsAndColors);

        //3 Fill form Metals & Colors by data
        Site.metalsAndColorsPage.fillForm(parameters);

        //4. Submit form Metals & Colors
        Site.metalsAndColorsPage.submit();

        //5. Result sections should contains data
        Results results = new Results();
        Site.metalsAndColorsPage.checkResults(parameters);
    }
}
