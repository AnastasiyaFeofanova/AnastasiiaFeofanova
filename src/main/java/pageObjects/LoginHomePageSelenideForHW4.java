package pageObjects;

import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Enums;
import enums.Users;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class LoginHomePageSelenideForHW4 {
    @FindBy(css = "h3.main-title")
    private SelenideElement mainText;
    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;
    @FindBy(id = "name")
    private SelenideElement loginName;
    @FindBy(id = "password")
    private SelenideElement password;
    @FindBy(id = "login-button")
    private SelenideElement submit;

    @FindBy(id = "user-name")
    private SelenideElement userName;

    public LoginHomePageSelenideForHW4() {
        page(this);
    }

    @Test
    public void checkMainTitle(String text) {
        assertEquals(getWebDriver().getTitle(), text);
    }

    @Test
    public void login(Users user) {
        profileButton.click();
        loginName.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @Test
    public void checkUserName(Users user) {
        Assert.assertEquals(userName.getText(), user.userName);
    }
}
