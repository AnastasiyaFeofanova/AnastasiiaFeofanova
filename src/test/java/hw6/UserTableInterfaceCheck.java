package hw6;

import cucumber.api.java.en.And;
import pageObjects.utils.SuperHero;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class UserTableInterfaceCheck {

    @FindBy(css = ".dropdown-menu > li")
    private ElementsCollection serviceDropdown;
    @FindBy(css = "#user-table tr")
    ElementsCollection table;

    @FindBy(css = "#user-table > tbody > tr > td > select")
    //#user-table > tbody > tr > td:nth-child(1)
    private ElementsCollection typeDropdowns;
    @FindBy(css = "#user-table > tbody > tr > td > a")
    private ElementsCollection names;
    @FindBy(css = "#user-table > tbody > tr > td > img")
    public ElementsCollection images;
    @FindBy(css = "#user-table > tbody > tr > td > div > span")
    public ElementsCollection textsUnderImages;
    @FindBy(css = "#user-table > tbody > tr > td > div > input")
    public ElementsCollection checkboxes;
    @FindBy(css = "[class='info-panel-body info-panel-body-log']")
    public ElementsCollection logs;
    @FindBy(css = "#user-table > tbody > tr:nth-child(2) > td:nth-child(2) > select > option")
    public ElementsCollection dropdown;

    public UserTableInterfaceCheck() {
        page(this);
    }

    @And("I click on \"([^\"]*)\" button in Service dropdown")
    @Step("Click \"User\" Table on Service dropdown")
    public void clickUserTableLink(String s) {
        serviceDropdown.filter(Condition.text(s)).first().click();
    }

    @Then("\"([^\"]*)\" page is opened")
    @Step("Check UserTable is opened")
    public void checkUsertableIsOpened(String s) {
        assertEquals(getWebDriver().getTitle(), s);
    }

    @And("6 NumberType Dropdowns are displayed on Users Table on User Table Page")
    @Step("Check 6 dropdowns are displayed on User Table Page")
    public void checkNumberTypeDropdownsAreDisplayed() {
        Assert.assertEquals(typeDropdowns.size(), 6);
    }

    @And("6 User names are displayed on Users Table on User Table Page")
    @Step("check 6 names are displayed on User Table Page")
    public void checkNamesAreDisplayed() {
        Assert.assertEquals(names.size(), 6);
    }

    @And("6 Description images are displayed on Users Table on User Table Page")
    @Step("check 6 description images are displayed on Users Table on User Table Page")
    public void checkDescriptionImagesAreDisplayed() {
        Assert.assertEquals(images.size(), 6);
    }

    @And("6 Description texts under images are displayed on Users Table on User Table Page")
    @Step("check 6 description texts under images are displayed on Users Table on User Table Page")
    public void checkDescriptionTextsUnderImagesAreDisplayed() {
        Assert.assertEquals(textsUnderImages.size(), 6);
    }

    @And("6 checkboxes are displayed on Users Table on User Table Page")
    @Step("check 6 checkboxes are displayed on Users Table on User Table Page")
    public void checkCheckboxesAreDisplayed() {
        Assert.assertEquals(textsUnderImages.size(), 6);
    }

    @And("User table contains following values:")
    public void checkSuperHeroes(List<SuperHero> superHeroes) {
        Assert.assertEquals(getSuperHeroes(), superHeroes);
    }

    private List<SuperHero> getSuperHeroes() {
        return table.stream().skip(1).map(e -> new SuperHero(
                Integer.parseInt(e.$("td", 0).text()),
                e.$("td a").text(),
                e.$("td span").text().replaceAll("\n", " ")
        )).collect(Collectors.toList());
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    @Step("selecting 'vip' checkbox for \"Sergey Ivan\"")
    public void selectCheckboxForUser() {
        checkboxes.filter(Condition.id("ivan")).first().click();
    }

    @Then("1 log row has \"([^\"]*)\" text in log section")
    @Step("1 log row has \"Vip: condition changed to true\" text in log section")
    public void validateLogState(String log) {
        logs.stream()
                .filter(SelenideElement -> SelenideElement.getText().equals(log));
    }

    @When("I click on dropdown in column Type for user Roman")
    @Step("Click on dropdown in column Type for user Roman")
    public void clickTypeForUser() {
        typeDropdowns.first().click();
    }

    @Then("droplist contains values")
    @Step("check droplist contains values")
    public void checkDroplistTypeUsersContainsValues(List<String> dropdownValues) {
        Assert.assertEquals(getDropdownValues(), dropdownValues);
    }

    private List<String> getDropdownValues() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(dropdown.get(i).getValue());
        }
        return list;
    }
}
