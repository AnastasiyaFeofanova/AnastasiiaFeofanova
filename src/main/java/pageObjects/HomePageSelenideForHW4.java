package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.xml.soap.Text;

import java.util.List;
import java.util.Scanner;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePageSelenideForHW4 {
    
    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;
    @FindBy(id = "Name")
    private SelenideElement loginName;
    @FindBy(id = "Password")
    private SelenideElement password;
    @FindBy(css = "[type='submit']")
    private SelenideElement submit;

    @FindBy(css = "[ui='label']")
    private SelenideElement userName;

    @FindBy(css = "Service")
    private SelenideElement serviceLeft;
    @FindBy(css = ".sub")
    private SelenideElement options;

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement serviceHeader;
    @FindBy(css = ".dropdown-menu")
    private SelenideElement headerOptions;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private SelenideElement differentElementsLink;

    public void checkBrowserTitle(String BrowserTitle) {
        Assert.assertEquals(getWebDriver().getTitle(), BrowserTitle);
    }

    public void login(String name, String pass) {
        profileButton.click();
        loginName.sendKeys(name);
        password.sendKeys(pass);
        submit.click();
    }

    public void CheckUserName(String name) {
        Assert.assertEquals(userName.getText(), name);
    }

    public void CheckHeaderOptions(String Text){
        serviceHeader.click();
        headerOptions.selectOptionContainingText(Text);
    }
    public void CheckLeftMenuOptions(String Text) {
        serviceLeft.click();
        options.selectOptionContainingText(Text);
    }

    public void LinkDifferentElementsInHeader(){
        serviceHeader.click();
        differentElementsLink.click();
    }

}
