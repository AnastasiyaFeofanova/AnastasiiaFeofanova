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
    private SelenideElement headerDifferentElements;
    @FindBy(linkText = "PERFORMANCE")
    private SelenideElement headerPerformance;

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

    @FindBy(css = ".uui-side-bar right-fix-panel mCustomScrollbar _mCS_2 mCS_no_scrollbar")
    public SelenideElement rightPanelOnDifferentElementsPage;
    @FindBy(css = ".navigation-sidebar")
    public SelenideElement leftPanelOnDifferentElementsPage;


    @FindBy(css = ".panel-body-list")
    public SelenideElement log;

    @Step("Check Header Options")
    @Test
    public void CheckHeaderOptions(){
        serviceHeader.click();
        headerSupport.should(Condition.exist);
        List<SelenideElement> headerSupportOptions = Arrays.asList(headerSupport, headerDates, headerComplexTable, headerSimpleTable, headerUserTable, headerTableWithPages, headerDifferentElements, headerPerformance);
        for (SelenideElement element:headerSupportOptions) {
            element.should(Condition.exist);
        }
    }

    @Step("Check SideBar options")
    @Test
    public void CheckSidebarOptions() {
        serviceSidebar.click();
        sidebarServiceOptions.should(Condition.exist);
        List<SelenideElement> sidebarSupportOptions = Arrays.asList(sidebarSupport, sidebarDates, sidebarComplexTable, sidebarSimpleTable, sidebarUserTable, sidebarTableWithPages, sidebarDifferentElements, sidebarPerformance);
        for (SelenideElement element:sidebarSupportOptions) {
            element.should(Condition.exist);
        }
    }

    @Step("Go to link DiffrentElements")
    @Test
    public void LinkDifferentElementsInHeader(String text){
        serviceHeader.click();
        headerDifferentElements.click();
        assertEquals(getWebDriver().getTitle(),text);
    }

    @Step("Check Diffrerent Elements Page")
    @Test
    public void CheckDifferentElementsPageElements() {
        List<SelenideElement> sidebarDifferentElementsListElements = Arrays.asList(waterCheckBox, earthCheckBox, windCheckBox, fireCheckBox, goldCheckRadio, silverCheckRadio, bronzeCheckRadio, selenCheckRadio, colorsDropdown, defaultButton, button);
        for (SelenideElement element:sidebarDifferentElementsListElements) {
            element.should(Condition.exist);
        }
    }

    @Step("Check Right Panel on Different Elements Page (is displayed)")
    @Test
    public void CheckRightPanelOnDifferentElementsPage(){
        rightPanelOnDifferentElementsPage.isDisplayed();
    }

    @Step("Check Left Panel on Different Elements Page (is displayed)")
    @Test
    public void CheckLeftPanelOnDifferentElementsPage(){
        leftPanelOnDifferentElementsPage.isDisplayed();
    }

    @Step("Select water&wind checkboxes")
    @Test
    public void SelectCheckBoxes() {
        waterCheckBox.click();
        windCheckBox.click();
    }

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
    @Test
    public void ValidateCheckBoxStateOnParam(CheckBoxes value) {
        List<WebElement> logStrings = log.findElements(By.tagName("li"));
        Assert.assertTrue(validateLogStrings(logStrings, value.name(), "true"));
    }

    @Step("Select selen radiobox")
    @Test
    public void SelectRadioBoxes(){
        selenCheckRadio.click();
    }

    @Step("Validate radioboxes on")
    @Test
    public void ValidateRadioButtonsStateOn(RadioButtons values) {
        List<WebElement> logStrings = log.findElements(By.tagName("li"));
        Assert.assertTrue(validateLogStrings(logStrings, values.name(), "metal"));
    }

    @Step("Select yellow color")
    @Test
    public void SelectYellowInDropdown(){
        colorsDropdown.click();

        List<WebElement> options = colorsDropdown.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if("Yellow".equals(option.getText()))
                option.click();
        }
    }

//    @Test
//    public void ValidateColors() {
//        List<WebElement> logStrings = log.findElements(By.tagName("li"));
//        Assert.assertTrue(validateLogStrings(logStrings, checkedColor(colorsDropdown.findElements(By.tagName("option"))), "Colors"));
//    }
//
//    String checkedColor (final List<WebElement> strings) {
//        for(WebElement s : strings) {
//            String text = s.getText();
//            if(s.isSelected()) {
//                return text;
//            }
//        }
//        return null;
//    }

    @Step("Validate colors log")
    @Test
    public void ValidateColorsParam(Colours value) {
        List<WebElement> logStrings = log.findElements(By.tagName("li"));
        Assert.assertTrue(validateLogStrings(logStrings, value.name(), "Colors"));
    }

    @Step("Validate checkbox off")
    @Test
    public void ValidateCheckBoxStateOff(CheckBoxes value) {
        List<WebElement> logStrings = log.findElements(By.tagName("li"));
        Assert.assertTrue(validateLogStrings(logStrings, value.name(), "false"));
    }
}
