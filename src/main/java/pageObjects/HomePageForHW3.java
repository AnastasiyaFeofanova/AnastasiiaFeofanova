package pageObjects;


import enums.MainContentIndexPage;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class HomePageForHW3 {

    public HomePageForHW3(){
        page(this);
    }

    private WebDriver driver;

//    public HomePageForHW3(WebDriver driver) {
//        this.driver = driver;
//    }

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "#name")
    private WebElement loginName;
    @FindBy(css = "#password")
    private WebElement password;
    @FindBy(css = "#login-button")
    private WebElement submit;
    @FindBy(css = "#user-name")
    private WebElement userName;

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8>li")
    public List<WebElement> headerNavigation;

    @FindBy(css = "div.benefit-icon")
    private List<WebElement> icons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> elements;

    @FindBy(className = "main-title")
    private WebElement headerText;
    @FindBy(css = ".main-txt")
    private WebElement textCenter;

    @FindBy(css = "#iframe")
    private WebElement iFrame;
    @FindBy(className = "epam-logo")
    private WebElement iframeLogo;

    @FindBy(css = "h3:nth-child(3)")
    private WebElement subHeaderText;

    @FindBy(linkText = "JDI GITHUB")
    private WebElement link;

    @FindBy(css = "#mCSB_1")
    private WebElement leftSection;

    @FindBy(className = "footer-bg")
    private WebElement footer;


    @Step("Open Home Page")
    public void openHomePage(String s) {
        driver.navigate().to(s);
    }

    @Step("Login to Home Page")
    public void login(Users s) {
        profileButton.click();
        loginName.sendKeys(s.login);
        password.sendKeys(s.password);
        submit.click();
    }

    @Step("Check Title Home page")
    public void checkTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @Step("Check user Name Home Page")
    public void checkUserName(String UserName) {
        Assert.assertEquals(userName.getText(), UserName);
    }

    @Step("Check Header elements")
    public void checkHeaderNavigation(List<String> list) {
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(headerNavigation.get(i).getText(), list.get(i));
        }
    }

    @Step("Check Images on body Home Page is Dispalyed")
    public void checkIconsIsDisplayed() {
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(icons.get(i).isDisplayed());
        }
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void checkUnderIconsTextOnIndexPage(List<String> s) {
        Assert.assertEquals(elements.size(), 4);
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(elements.get(i).getText(), s.get(i));
        }
        List<String> elementsText = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            elementsText.add(i, elements.get(i).getText());
        }
        Assert.assertTrue(elementsText.containsAll(s), "comparison of lists is failed");
        Assert.assertEquals(elementsText, s, "comparison of lists via TestNg is failed");
    }

    @Step("Check main content of HomePage")
    public void checkMainContent(List<String> s) {
        Assert.assertEquals(headerText.getText(), s.get(0));
        Assert.assertEquals(textCenter.getText(), s.get(1));
    }

    @Step("Check main content of HomePage")
    public void checkMainContent() {
        Assert.assertEquals(headerText.getText(), MainContentIndexPage.first.param);
        Assert.assertEquals(textCenter.getText(), MainContentIndexPage.second.param);
    }

    @Step("Check IFrame")
    public void checkIframe() {
        Assert.assertTrue(iFrame.isDisplayed());
    }

    @Step("Check IFrameLogo")
    public void checkIFrameLogo(WebDriver driver) {
        driver.switchTo().frame(iFrame);
        Assert.assertTrue(iframeLogo.isDisplayed());
    }

    @Step("Check SubHeaderText")
    public void checkSubHeaderText(String text) {
        Assert.assertEquals(subHeaderText.getText(), text);
    }

    @Step("Check Link on HomePage")
    public void checkLink(String attribute, String text) {
        Assert.assertEquals(link.getAttribute(attribute), text);
    }

    @Step("Check left section of HomePage")
    public void checkleftSection() {
        Assert.assertTrue(leftSection.isDisplayed());
    }

    @Step("Check footer")
    public void checkFooter() {
        Assert.assertTrue(footer.isDisplayed());
    }

    @Step("Close browser")
    public void close() {
        driver.close();
    }
}
