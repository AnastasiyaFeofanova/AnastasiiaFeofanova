package hw6;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pageObjects.HomePageForHW3;
import pageObjects.HomePageSelenide;
import pageObjects.DifferentElementsPageSelenideForHW4;
import pageObjects.LoginHomePageSelenideForHW4;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageLoginVerify {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'password']")
    private SelenideElement password;

    @FindBy(css = "[id = 'login-button']")
    private SelenideElement submit;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;
    private WebDriver driver;

    public HomePageLoginVerify() {
        page(this);
    }

    public DifferentElementsPageSelenideForHW4 homePageForHW4;
    public HomePageForHW3 homePageForHW3;

    @Step("Open JDI Test Application - HomePage")
    @Given("^1. I open EPAM JDI site$")
    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @When("^3. I login as user epam with password 1234$")
    public void iPerformLogin() {
        new LoginHomePageSelenideForHW4().login(Users.PITER);
    }

    @Then("^2. Browser's title must be Home Page$")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Then("^4. User name should be '([^\"]*)'")
    public void userNameShouldBe(String expectedUsername) {
        new HomePageSelenide().getUserName().shouldBe(text(expectedUsername));
    }

    @And("^5. Check interface on Home page, it contains all needed elements.$")
    @Step("check 4 - pictures, 4 texts under them, 2 texts above (headline and description)")
    public void checkElementsOnHomePage() {
        new HomePageForHW3().checkIconsIsDisplayed();
        new HomePageForHW3().checkUnderIconsTextOnIndexPage(TextUnderIconsOnIndexPage.getTextUnderIconsOnIndexPage());
        new HomePageForHW3().checkMainContent();
    }

    @And("^6. Click on \"Service\" subcategory in the header and check that drop down contains options$")
    @Step("Support, Dates, Complex Table, Simple Table, User Table, Tables With Pages, Different Elements, Perfomance")
    public void checkHeaderOptions() {
        new DifferentElementsPageSelenideForHW4().checkHeaderOptions();
    }

    @And("^7. Click on Service subcategory in the left section and check that drop down contains options$")
    @Step("Support, Dates, Complex Table, Simple Table, User Table, Tables With Pages, Different Elements, Perfomance")
    public void checkSidebarOptions() {
        new DifferentElementsPageSelenideForHW4().checkSidebarOptions();
    }

    @When("^8. Open through the header menu Service -> Different Elements Page$")
    public void goLinkDifferentElementsInHeader() {
        new DifferentElementsPageSelenideForHW4().linkDifferentElementsInHeader("Different Elements");
    }

    @Then("^9. Check interface on Different elements page, it contains all needed elements$")
    @Step("4 checkboxes, 4 radios, 1 dropdown, 2 buttons should be there")
    public void checkDifferentElementsPageElements() {
        new DifferentElementsPageSelenideForHW4().checkDifferentElementsPageElements();
    }

    @And("^10. Assert that there is Right Section$")
    public void checkRightPanelOnDifferentElementsPage() {
        new DifferentElementsPageSelenideForHW4().checkRightPanelOnDifferentElementsPage();
    }

    @And("^11. Assert that there is Left Section$")
    public void checkLeftPanelOnDifferentElementsPage() {
        new DifferentElementsPageSelenideForHW4().checkLeftPanelOnDifferentElementsPage();
    }

    @When("^12. Select checkboxes$")
    @Step("Select checkboxes Water, Wind")
    public void selectCheckBoxes() {
        new DifferentElementsPageSelenideForHW4().selectCheckBoxes(CheckBoxes.CHECK_BOXES.water);
        new DifferentElementsPageSelenideForHW4().selectCheckBoxes(CheckBoxes.CHECK_BOXES.wind);
    }

    @Then("^13. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox$")
    @Step("Log rows are displayed, checkbox name and its status is corresponding to selected")
    public void validateCheckBoxStateOn() {
        new DifferentElementsPageSelenideForHW4().validateLogState(LogCheckAndRadioBoxes.WATER_ON.parameter);
        new DifferentElementsPageSelenideForHW4().validateLogState(LogCheckAndRadioBoxes.WIND_ON.parameter);
    }

    @When("^14. Select radio$")
    @Step("Select Selen")
    public void selectRadioBoxes() {
        new DifferentElementsPageSelenideForHW4().selectRadioBoxes(RadioButtons.RADIO_BOXES.selen);
    }

    @Then("^15. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton$")
    @Step("Log row is displayed, radiobutton name and its status is corresponding to selected")
    public void validateRadioButtonsStateOn() {
        new DifferentElementsPageSelenideForHW4().validateLogState(LogCheckAndRadioBoxes.SELEN_ON.parameter);
    }

    @When("^16. Select in dropdown$")
    @Step("Yellow is selected")
    public void selectYellowInDropdown() {
        new DifferentElementsPageSelenideForHW4().selectYellowInDropdown(Colours.Yellow);
    }

    @Then("^17. Assert that for dropdown there is a log row and value is corresponded to the selected value$")
    @Step("Log row is displayed, dropdown name and selected value is corresponding to selected")
    public void validateColorsParam() {
        new DifferentElementsPageSelenideForHW4().validateLogState(LogCheckAndRadioBoxes.YELOW_ON.parameter);
    }

    @When("^18. Unselect and assert checkboxes$")
    @Step("Water, Wind -> unselected")
    public void unselectCheckBoxes() {
        new DifferentElementsPageSelenideForHW4().selectCheckBoxes(CheckBoxes.CHECK_BOXES.water);
        new DifferentElementsPageSelenideForHW4().selectCheckBoxes(CheckBoxes.CHECK_BOXES.wind);
    }

    @Then("^19. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox$")
    @Step("Log rows are displayed, checkbox name and its status is corresponding to selected")
    public void validateCheckBoxStateOff() {
        new DifferentElementsPageSelenideForHW4().validateLogState(LogCheckAndRadioBoxes.WATER_OFF.parameter);
        new DifferentElementsPageSelenideForHW4().validateLogState(LogCheckAndRadioBoxes.WIND_OFF.parameter);
    }
}
