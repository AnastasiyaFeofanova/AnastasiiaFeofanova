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

public class ServicePageInterfaceBDD {

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

    public ServicePageInterfaceBDD() {
        page(this);
    }

    public DifferentElementsPageSelenideForHW4 homePageForHW4;
    public HomePageForHW3 homePageForHW3;

    @Step("Open JDI Test Application - HomePage")
    @Given("^I open EPAM JDI site$")
    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @When("I login as user Users.([^\"]*)")
    public void iPerformLogin(String user) {
        new LoginHomePageSelenideForHW4().login(Users.valueOf(user));
    }

    @Then("^Browser's title must be ([^\"]*)$")
    public void checkTitle(String s) {
        assertEquals(getWebDriver().getTitle(), s);
    }

    @Then("User name should be Users.([^\"]*).userName")
    public void userNameShouldBe(String userName) {
        new HomePageSelenide().getUserName().shouldBe(text(Users.valueOf(userName).userName));
    }

    @And("^Check interface on Home page, it contains all needed elements.$")
    @Step("check 4 - pictures, 4 texts under them, 2 texts above (headline and description)")
    public void checkElementsOnHomePage() {
        new HomePageForHW3().checkIconsIsDisplayed();
        new HomePageForHW3().checkUnderIconsTextOnIndexPage(TextUnderIconsOnIndexPage.getTextUnderIconsOnIndexPage());
        new HomePageForHW3().checkMainContent();
    }

    @And("^Click on ([^\"]*) subcategory in the header and check that drop down contains options$")
    @Step("Support, Dates, Complex Table, Simple Table, User Table, Tables With Pages, Different Elements, Perfomance")
    public void checkHeaderOptions(String s) {
        new DifferentElementsPageSelenideForHW4().checkHeaderOptions(s);
    }

    @And("^Click on ([^\"]*) subcategory in the left section and check that drop down contains options$")
    @Step("Support, Dates, Complex Table, Simple Table, User Table, Tables With Pages, Different Elements, Perfomance")
    public void checkSidebarOptions(String s) {
        new DifferentElementsPageSelenideForHW4().checkSidebarOptions(s);
    }

    @When("^Open through the header menu ([^\"]*) -> ([^\"]*) Page$")
    public void goLinkDifferentElementsInHeader(String service, String diffel) {
        new DifferentElementsPageSelenideForHW4().linkDifferentElementsInHeader(service, diffel);
    }

    @Then("^Check interface on Different elements page, it contains all needed elements$")
    @Step("4 checkboxes, 4 radios, 1 dropdown, 2 buttons should be there")
    public void checkDifferentElementsPageElements() {
        new DifferentElementsPageSelenideForHW4().checkDifferentElementsPageElements();
    }

    @And("^Assert that there is Right Section$")
    public void checkRightPanelOnDifferentElementsPage() {
        new DifferentElementsPageSelenideForHW4().checkRightPanelOnDifferentElementsPage();
    }

    @And("^Assert that there is Left Section$")
    public void checkLeftPanelOnDifferentElementsPage() {
        new DifferentElementsPageSelenideForHW4().checkLeftPanelOnDifferentElementsPage();
    }

    @When("^Select checkboxes ([^\"]*) and ([^\"]*)$")
    @Step("Select checkboxes Water, Wind")
    public void selectCheckBoxes(String i, String j) {
        new DifferentElementsPageSelenideForHW4().selectCheckBoxes(CheckBox.valueOf(i));
        new DifferentElementsPageSelenideForHW4().selectCheckBoxes(CheckBox.valueOf(j));
    }

    @Then("Assert that there are an individual log row and ([^\"]*)")
    @Step("check log row for checkboxes")
    public void validateCheckBoxState(String boxLog) {
        new DifferentElementsPageSelenideForHW4().validateLogState(LogCheckAndRadioBoxes.valueOf(boxLog).parameter);
    }

    @When("Select radiobutton ([^\"]*)")
    @Step("Select Selen")
    public void selectRadioBoxes(String radioButton) {
        new DifferentElementsPageSelenideForHW4().selectRadioBoxes(RadioButton.valueOf(radioButton).toString());
    }

    @Then("Assert that for radiobutton there are a log row and ([^\"]*)")
    @Step("Log row for radiobuttons is displayed, and Selen is checked")
    public void validateRadioButtonsStateOn(String radioBoxLog) {
        new DifferentElementsPageSelenideForHW4().validateLogState(LogCheckAndRadioBoxes.valueOf(radioBoxLog).parameter);
    }

    @When("Select ([^\"]*) color in dropdown$")
    @Step("Yellow is selected")
    public void selectYellowInDropdown(String color) {
        new DifferentElementsPageSelenideForHW4().selectYellowInDropdown(Colours.valueOf(color));
    }

    @Then("Assert that for dropdown there are a log rows and ([^\"]*)")
    @Step("Log row for colors is displayed, dropdown name and selected value is corresponding to selected")
    public void validateColorsParam(String colorLog) {
        new DifferentElementsPageSelenideForHW4().validateLogState(LogCheckAndRadioBoxes.valueOf(colorLog).parameter);
    }

    @When("Unselect checkboxes ([^\"]*) and ([^\"]*)")
    @Step("Select checkboxes Water, Wind")
    public void UnselectCheckBoxes(String i, String j) {
        new DifferentElementsPageSelenideForHW4().selectCheckBoxes(CheckBox.valueOf(i));
        new DifferentElementsPageSelenideForHW4().selectCheckBoxes(CheckBox.valueOf(j));
    }
}
