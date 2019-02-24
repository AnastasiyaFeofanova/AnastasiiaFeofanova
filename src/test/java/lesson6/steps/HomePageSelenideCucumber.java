package lesson6.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import cucumber.api.java.en.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageSelenideCucumber {

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

    @FindBy(css = "div.logout")
    private SelenideElement logout;

    public HomePageSelenideCucumber() {
        page(this);
    }

    @Step("Open JDI Test Application - HomePage")
    @When("^I'm on the Home Page$")
    public void openPage(){open("https://epam.github.io/JDI/index.html");}

//    @When("^I'm login as ([^\"]*) with password ([^\"]*)$")
//    public void login(String name, String passvord){
//        profileButton.click();
//        login.sendKeys(name);
//        password.sendKeys(passvord);
//        submit.click();
//    }

    @Then("^The browser title is Home Page$")
    public  void checkTitle(){assertEquals(getWebDriver().getTitle(),"Home Page");
    }

    @Test
    public void checkMainText(){
        mainTitle.shouldBe(Condition.visible);
        mainTitle.shouldHave(Condition.text("EPAM FRAMEWORK WISHES…"));
    }

    @Then("The user icon is displayed on the header")
    public void checkUserIcon() {
        profileButton.shouldBe(Condition.visible);
    }

    @Then("LogOut")
    public void logOut(){
        logout.click();
    }
}
