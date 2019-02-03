package pageObjects;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    public void openHomePage(String s){
        driver.navigate().to(s);
    }

    public void login(List<String> s){
        profileButton.click();
        loginName.sendKeys(s.get(0));
        password.sendKeys(s.get(1));
        submit.click();
    }
    public void checkTitle(WebDriver driver, String title){
        Assert.assertEquals(driver.getTitle(),title);
    }

    public void checkUserName(String UserName){
        Assert.assertEquals(userName.getText(), UserName);
    }

    public void checkHeader(List<String> s){
        Assert.assertEquals(home.getText(), s.get(0));
        Assert.assertEquals(contactForm.getText(), s.get(1));
        Assert.assertEquals(service.getText(), s.get(2));
        Assert.assertEquals(metCol.getText(), s.get(3));
    }

    public void checkImagesIsDisplayed(){
        Assert.assertTrue(practiseIcon.isDisplayed());
        Assert.assertTrue(customIcon.isDisplayed());
        Assert.assertTrue(multiIcon.isDisplayed());
        Assert.assertTrue(baseIcon.isDisplayed());
    }

    public void checkIndexPage(List<String> s){
        Assert.assertEquals(elements.size(), 4);
        Assert.assertEquals(elements.get(0).getText(), s.get(0));
        Assert.assertEquals(elements.get(1).getText(), s.get(1));
        Assert.assertEquals(elements.get(2).getText(), s.get(2));
        Assert.assertEquals(elements.get(3).getText(), s.get(3));
    }

    public void checkMainContent(List<String> s){
        Assert.assertEquals(headerText.getText(), s.get(0));
        Assert.assertEquals(textCenter.getText(), s.get(1));
    }

    public void checkIframe(){
        Assert.assertTrue(iFrame.isDisplayed());
    }

    public void checkIFrameLogo(WebDriver driver){
        driver.switchTo().frame(iFrame);
        Assert.assertTrue(iframeLogo.isDisplayed());
    }

    public void checkSubHeaderText(String text){
        Assert.assertEquals(subHeaderText.getText(), text);
    }

    public void checkLink(String attribute, String text){
        Assert.assertEquals(link.getAttribute(attribute), text);
    }

    public void checkleftSection(){
        Assert.assertTrue(leftSection.isDisplayed());
    }

    public void checkfooter(){
        Assert.assertTrue(footer.isDisplayed());
    }

    public void close(){
        driver.close();
    }
}
