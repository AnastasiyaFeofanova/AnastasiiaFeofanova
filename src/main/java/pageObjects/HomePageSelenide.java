package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageSelenide {
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

    @FindBy(id="user-name")
    private SelenideElement userName;

    public SelenideElement getUserName() {
        return userName;
    }

    public HomePageSelenide(){
        page(this);
    }

    @Test
    public void openPage(){open("https://epam.github.io/JDI/index.html");}

    @Test
    public void login(String name, String passvord){
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passvord);
        submit.click();
    }

    @Test
    public  void checkTitle(){assertEquals(getWebDriver().getTitle(),"Home Page");
    }

    @Test
    public void checkMainText(){
        mainTitle.shouldBe(Condition.visible);
        mainTitle.shouldHave(Condition.text("EPAM FRAMEWORK WISHES…"));
    }
}
