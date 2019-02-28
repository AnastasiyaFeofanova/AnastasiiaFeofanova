package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Enums;
import enums.CheckBox;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPageSelenideForHW4 extends LoginHomePageSelenideForHW4 {

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8")
    private ElementsCollection headerMenu;
    @FindBy(css = "li[class = 'dropdown'] a[class = 'dropdown-toggle']")
    private SelenideElement serviceHeader;
    @FindBy(css = ".dropdown-menu > li")
    private List<SelenideElement> headerServiceOptions;
    @FindBy(css = ".dropdown-menu > li")
    private ElementsCollection headerServiceOptionsCol;

    @FindBy(css = ".dropdown-menu > li:nth-child(7) > a")
    public SelenideElement headerDifferentElements;

    @FindBy(css = ".sidebar-menu")
    private ElementsCollection sidebarMenu;
    @FindBy(css = "a[ui='label']")
    private SelenideElement serviceSidebar;

    @FindBy(css = "li.menu-title.active > .sub > li")
    private List<SelenideElement> sidebarServiceOptions;

    @FindBy(css = ".main-content-hg > div > label, select, p")
    private List<SelenideElement> differentElements;
    @FindBy(css = ".checkbox-row > label.label-checkbox")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".checkbox-row > label.label-radio")
    private ElementsCollection radioBoxes;

    @FindBy(css = ".colors")
    private SelenideElement colorsDropdown;
    @FindBy(css = ".uui-form-element > option")
    private ElementsCollection colors;

    @FindBy(css = "button[name='Default Button']")
    private SelenideElement defaultButton;
    @FindBy(css = "input[type='button']")
    private SelenideElement button;

    @FindBy(css = ".uui-side-bar.right-fix-panel.mCustomScrollbar._mCS_2.mCS_no_scrollbar")
    public SelenideElement rightPanelOnDifferentElementsPage;
    @FindBy(css = ".navigation-sidebar")
    public SelenideElement leftPanelOnDifferentElementsPage;

    @FindBy(css = ".panel-body-list")
    public SelenideElement log;
    @FindBy(css = ".panel-body-list")
    public ElementsCollection logs;
    public DifferentElementsPageSelenideForHW4(){
        page(this);
    }


    @Step("Check Header Options")
    public void checkHeaderOptions() {
        serviceHeader.click();
        for (SelenideElement element : headerServiceOptions) {
            element.should(Condition.exist);
        }
    }

    @Step("Check Header Options")
    public void checkHeaderOptions(String Service) {
        headerMenu.filter(Condition.text(Service)).first().click();
        for (SelenideElement element : headerServiceOptions) {
            element.should(Condition.exist);
        }
    }

    @Step("Check SideBar options")
    public void checkSidebarOptions() {
        serviceSidebar.click();
        for (SelenideElement element : sidebarServiceOptions) {
            element.should(Condition.exist);
        }
    }

    @Step("Check SideBar options")
    public void checkSidebarOptions(String s) {
        sidebarMenu.filterBy(Condition.text(s)).first().click();
        for (SelenideElement element : sidebarServiceOptions) {
            element.should(Condition.exist);
        }
    }

    @Step("Go to link DiffrentElements")
    public void linkDifferentElementsInHeader(String Service, String text) {
        headerMenu.filter(Condition.text(Service)).first().click();
        headerServiceOptionsCol.filter(Condition.text(text)).first().click();
        assertEquals(getWebDriver().getTitle(), text);
    }

    @Step("Go to link DiffrentElements")
    public void linkDifferentElementsInHeader(String text) {
        serviceHeader.click();
        headerServiceOptionsCol.filter(Condition.text(text)).first().click();
        assertEquals(getWebDriver().getTitle(), text);
    }

    @Step("Check Diffrerent Elements Page")
    public void checkDifferentElementsPageElements() {
        for (SelenideElement element : differentElements) {
            element.should(Condition.exist);
        }
    }

    @Step("Check Right Panel on Different Elements Page (is displayed)")
    public void checkRightPanelOnDifferentElementsPage() {
        rightPanelOnDifferentElementsPage.isDisplayed();
    }

    @Step("Check Left Panel on Different Elements Page (is displayed)")
    public void checkLeftPanelOnDifferentElementsPage() {
        leftPanelOnDifferentElementsPage.isDisplayed();
    }

    @Step("Select checkboxes")
    public void selectCheckBoxes(String value) {
        checkBoxes.filter(Condition.text(value)).first().click();
    }

    @Step("Select checkboxes")
    public void selectCheckBoxes(CheckBox box) {
        checkBoxes.filter(Condition.text(box.toString())).first().click();
    }

    @Step("Select radioboxes")
    public void selectRadioBoxes(String value) {
        radioBoxes.filter(Condition.text(value)).first().click();
    }

    @Step("Validate elements state")
    public void validateLogState(String log) {
        logs.stream()
                .filter(SelenideElement -> SelenideElement.getText().equals(log));
    }

    @Step("Select yellow color")
    public void selectYellowInDropdown(Enum color) {
        colorsDropdown.click();
        colors.filter(Condition.text(color.name())).first().click();
    }
}
