package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// TODO Code convention, methods naming...
// TODO This is NOT the home page !!
// TODO You have quite long method names, it will be better to simplify it
public class HomePageSelenideForHW4 extends LoginHomePageSelenideForHW4{

    @FindBy(css = "li[class = 'dropdown'] a[class = 'dropdown-toggle']")
    private SelenideElement serviceHeader;
    @FindBy(css = "li.dropdown-open a.dropdown-menu")
    private SelenideElement headerOptions;
    @FindBy(css = "ul[class = 'dropdown-menu']>li")
    private ElementsCollection headerOptionsCollection;
    @FindBy(linkText = "SUPPORT")
    private SelenideElement headerSupport;
    @FindBy(linkText = "DATES")
    private SelenideElement headerDates;
    @FindBy(linkText = "COMPLEX TABLE")
    private SelenideElement headerComplexTable;
    @FindBy(linkText = "SIMPLE TABLE")
    private SelenideElement headerSimpleTable;
    @FindBy(linkText = "USER TABLE")
    private SelenideElement headerUserTable;
    @FindBy(linkText = "TABLE WITH PAGES")
    private SelenideElement headerTableWithPages;
    @FindBy(linkText = "DIFFERENT ELEMENTS")
    public SelenideElement headerDifferentElements;
    @FindBy(linkText = "PERFORMANCE")
    private SelenideElement headerPerformance;

    /*
    TODO In genera it is not the best idea to create PO in this way, with indexes
    Take a look on ElementsCollection
     */
    @FindBy(css = "a[ui='label']")
    private SelenideElement serviceSidebar;
    @FindBy(css = "li.menu-title[index='3']")
    private SelenideElement sidebarServiceOptions;
    @FindBy(css = "ul[class = 'sub'] li[index = '1']")
    private SelenideElement sidebarSupport;
    @FindBy(css = "ul[class = 'sub'] li[index = '2']")
    private SelenideElement sidebarDates;
    @FindBy(css = "ul[class = 'sub'] li[index = '3']")
    private SelenideElement sidebarComplexTable;
    @FindBy(css = "ul[class = 'sub'] li[index = '4']")
    private SelenideElement sidebarSimpleTable;
    @FindBy(css = "ul[class = 'sub'] li[index = '5']")
    private SelenideElement sidebarUserTable;
    @FindBy(css = "ul[class = 'sub'] li[index = '6']")
    private SelenideElement sidebarTableWithPages;
    @FindBy(css = "ul[class = 'sub'] li[index = '7']")
    private SelenideElement sidebarDifferentElements;
    @FindBy(css = "ul[class = 'sub'] li[index = '8']")
    private SelenideElement sidebarPerformance;

    @FindBy(css = ".label-checkbox:nth-child(1)")
    private SelenideElement waterCheckBox;
    @FindBy(css = ".label-checkbox:nth-child(2)")
    private SelenideElement earthCheckBox;
    @FindBy(css = ".label-checkbox:nth-child(3)")
    private SelenideElement windCheckBox;
    @FindBy(css = ".label-checkbox:nth-child(4)")
    private SelenideElement fireCheckBox;

    @FindBy(css = ".label-radio:nth-child(1)")
    private SelenideElement goldCheckRadio;
    @FindBy(css = ".label-radio:nth-child(2)")
    private SelenideElement silverCheckRadio;
    @FindBy(css = ".label-radio:nth-child(3)")
    private SelenideElement bronzeCheckRadio;
    @FindBy(css = ".label-radio:nth-child(3)")
    private SelenideElement selenCheckRadio;

    @FindBy(css = ".colors")
    private SelenideElement colorsDropdown;
    @FindBy(css = "uui-form-element:nth-child(4)")
    private SelenideElement yellowElement;

    @FindBy(css = "button[name='Default Button']")
    private SelenideElement defaultButton;
    @FindBy(css = "input[type='button']")
    private SelenideElement button;

    // TODO This locator can be improved
    @FindBy(css = ".uui-side-bar right-fix-panel mCustomScrollbar _mCS_2 mCS_no_scrollbar")
    public SelenideElement rightPanelOnDifferentElementsPage;
    @FindBy(css = ".navigation-sidebar")
    public SelenideElement leftPanelOnDifferentElementsPage;


    @FindBy(css = ".panel-body-list")
    public SelenideElement log;

    @Step("Check Header Options")
    public void CheckHeaderOptions(){
        serviceHeader.click();
        headerSupport.should(Condition.exist);
        // TODO Code convention, line length
        List<SelenideElement> headerSupportOptions = Arrays.asList(headerSupport, headerDates, headerComplexTable, headerSimpleTable, headerUserTable, headerTableWithPages, headerDifferentElements, headerPerformance);
        for (SelenideElement element:headerSupportOptions) {
            element.should(Condition.exist);
        }
    }

    @Step("Check SideBar options")
    public void CheckSidebarOptions() {
        serviceSidebar.click();
        sidebarServiceOptions.should(Condition.exist);
        List<SelenideElement> sidebarSupportOptions = Arrays.asList(sidebarSupport, sidebarDates, sidebarComplexTable, sidebarSimpleTable, sidebarUserTable, sidebarTableWithPages, sidebarDifferentElements, sidebarPerformance);
        for (SelenideElement element:sidebarSupportOptions) {
            element.should(Condition.exist);
        }
    }

    @Step("Go to link DiffrentElements")
    public void LinkDifferentElementsInHeader(String text){
        serviceHeader.click();
        headerDifferentElements.click();
        assertEquals(getWebDriver().getTitle(),text);
    }

    @Step("Check Diffrerent Elements Page")
    public void CheckDifferentElementsPageElements() {
        List<SelenideElement> sidebarDifferentElementsListElements = Arrays.asList(waterCheckBox, earthCheckBox, windCheckBox, fireCheckBox, goldCheckRadio, silverCheckRadio, bronzeCheckRadio, selenCheckRadio, colorsDropdown, defaultButton, button);
        for (SelenideElement element:sidebarDifferentElementsListElements) {
            element.should(Condition.exist);
        }
    }

    @Step("Check Right Panel on Different Elements Page (is displayed)")
    public void CheckRightPanelOnDifferentElementsPage(){
        rightPanelOnDifferentElementsPage.isDisplayed();
    }

    @Step("Check Left Panel on Different Elements Page (is displayed)")
    public void CheckLeftPanelOnDifferentElementsPage(){
        leftPanelOnDifferentElementsPage.isDisplayed();
    }

    // TODO This method should be parametrised
    @Step("Select water&wind checkboxes")
    public void SelectCheckBoxes() {
        waterCheckBox.click();
        windCheckBox.click();
    }

    // TODO It is not make scense to create methods like this in OP. Utils, for the example
    boolean validateLogStrings(final List<WebElement> strings, final String name, final String expectedValue) {
        for(WebElement s : strings) {
            String text = s.getText();
            if(text.contains(name)) {
                return text.contains(expectedValue);
            }
        }
        return true;
    }

    @Step("Validate checkboxes on")
    public void ValidateCheckBoxStateOnParam(CheckBoxes value) {
        // TODO You should not find elements in PO method
        List<WebElement> logStrings = log.findElements(By.tagName("li"));
        Assert.assertTrue(validateLogStrings(logStrings, value.name(), "true"));
    }

    @Step("Select selen radiobox")
    public void SelectRadioBoxes(){
        selenCheckRadio.click();
    }

    @Step("Validate radioboxes on")
    public void ValidateRadioButtonsStateOn(RadioButtons values) {
        List<WebElement> logStrings = log.findElements(By.tagName("li"));
        Assert.assertTrue(validateLogStrings(logStrings, values.name(), "metal"));
    }

    // TODO This method should be parametrised
    @Step("Select yellow color")
    public void SelectYellowInDropdown(){
        colorsDropdown.click();

        List<WebElement> options = colorsDropdown.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if("Yellow".equals(option.getText()))
                option.click();
        }
    }

    @Step("Validate colors log")
    public void ValidateColorsParam(Colours value) {
        List<WebElement> logStrings = log.findElements(By.tagName("li"));
        // TODO Quite uncommon approach, you can do it easily with ElementsCollection
        // TODO Just generate the expected string and check that log contains it
        Assert.assertTrue(validateLogStrings(logStrings, value.name(), "Colors"));
    }

    @Step("Validate checkbox off")
    public void ValidateCheckBoxStateOff(CheckBoxes value) {
        List<WebElement> logStrings = log.findElements(By.tagName("li"));
        Assert.assertTrue(validateLogStrings(logStrings, value.name(), "false"));
    }
}
