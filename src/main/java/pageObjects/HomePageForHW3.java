package pageObjects;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import enums.MainContentIndexPage;
import enums.TextUnderIconsOnIndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class HomePageForHW3 {

    private WebDriver driver;

    public HomePageForHW3(WebDriver driver){this.driver = driver;}

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

    @FindBy(css = "ul[class='uui-navigation nav navbar-nav m-l8'] a[href='index.html']")
    private WebElement home;
    @FindBy(css = "ul[class='uui-navigation nav navbar-nav m-l8'] a[href='contacts.html']")
    private WebElement contactForm;
    @FindBy(css= "ul[class='uui-navigation nav navbar-nav m-l8'] a[class='dropdown-toggle']")
    private WebElement service;
    @FindBy(css="ul[class='uui-navigation nav navbar-nav m-l8'] a[href='metals-colors.html']")
    private  WebElement metCol;

    @FindBy(className = "icon-practise")
            private WebElement practiseIcon;
    @FindBy(className = "icon-custom")
            private WebElement customIcon;
    @FindBy(className = "icon-multi")
            private WebElement multiIcon;
    @FindBy(className = "icon-base")
            private WebElement baseIcon;
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
    public void openHomePage(String s){
        driver.navigate().to(s);
    }

    @Step("Login to Home Page")
    public void login(List<String> s){
        profileButton.click();
        loginName.sendKeys(s.get(0));
        password.sendKeys(s.get(1));
        submit.click();
    }

    @Step("Check Title Home page")
    public void checkTitle(WebDriver driver, String title){
        Assert.assertEquals(driver.getTitle(),title);
    }

    @Step("Check user Name Home Page")
    public void checkUserName(String UserName){
        Assert.assertEquals(userName.getText(), UserName);
    }

    @Step("Check Header elements")
    public void checkHeader(List<String> s){
        Assert.assertEquals(home.getText(), s.get(0));
        Assert.assertEquals(contactForm.getText(), s.get(1));
        Assert.assertEquals(service.getText(), s.get(2));
        Assert.assertEquals(metCol.getText(), s.get(3));
    }

    @Step("Check Images on body Home Page is Dispalyed")
    public void checkImagesIsDisplayed(){
        Assert.assertTrue(practiseIcon.isDisplayed());
        Assert.assertTrue(customIcon.isDisplayed());
        Assert.assertTrue(multiIcon.isDisplayed());
        Assert.assertTrue(baseIcon.isDisplayed());
    }

    @Step("Check element 'Index page' on Header HomePage ")
    public void checkIndexPage(List<String> s){
        Assert.assertEquals(elements.size(), 4);
        Assert.assertEquals(elements.get(0).getText(), s.get(0));
        Assert.assertEquals(elements.get(1).getText(), s.get(1));
        Assert.assertEquals(elements.get(2).getText(), s.get(2));
        Assert.assertEquals(elements.get(3).getText(), s.get(3));
    }

    @Step("Check element 'Index page' on Header HomePage ")
    public void checkIndexPage(){
        Assert.assertEquals(elements.size(), 4);
        Assert.assertEquals(elements.get(0).getText(), TextUnderIconsOnIndexPage.first);
        Assert.assertEquals(elements.get(1).getText(), TextUnderIconsOnIndexPage.second);
        Assert.assertEquals(elements.get(2).getText(), TextUnderIconsOnIndexPage.third);
        Assert.assertEquals(elements.get(3).getText(), TextUnderIconsOnIndexPage.fourth);
    }

    @Step("Check main content of HomePage")
    public void checkMainContent(List<String> s){
        Assert.assertEquals(headerText.getText(), s.get(0));
        Assert.assertEquals(textCenter.getText(), s.get(1));
    }

    @Step("Check main content of HomePage")
    public void checkMainContent(){
        Assert.assertEquals(headerText.getText(), MainContentIndexPage.first);
        Assert.assertEquals(textCenter.getText(), MainContentIndexPage.second);
    }

    @Step("Check IFrame")
    public void checkIframe(){
        Assert.assertTrue(iFrame.isDisplayed());
    }

    @Step("Check IFrameLogo")
    public void checkIFrameLogo(WebDriver driver){
        driver.switchTo().frame(iFrame);
        Assert.assertTrue(iframeLogo.isDisplayed());
    }

    @Step("Check SubHeaderText")
    public void checkSubHeaderText(String text){
        Assert.assertEquals(subHeaderText.getText(), text);
    }

    @Step("Check Link on HomePage")
    public void checkLink(String attribute, String text){
        Assert.assertEquals(link.getAttribute(attribute), text);
    }

    @Step("Check left section of HomePage")
    public void checkleftSection(){
        Assert.assertTrue(leftSection.isDisplayed());
    }

    @Step("Check footer")
    public void checkfooter(){
        Assert.assertTrue(footer.isDisplayed());
    }

    @Step("Close browser")
    public void close(){
        driver.close();
    }
}
