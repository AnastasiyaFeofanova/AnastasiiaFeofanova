package hw2.exercise2;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class GroupsRegressionAndSmoke extends SeleniumBase {

    ///Test1///
    @Test(groups = {"Regression"})
    public void regression1() {

        // Open BR
        WebDriver driver = new ChromeDriver();
        String mainWindow = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Navigate
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3 login
        driver.findElement(By.cssSelector("[id = 'user-icon']")).click();
        driver.findElement(By.cssSelector("[id = 'name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id = 'login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector("[id='user-name']"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement home = driver.findElement(By.xpath("//a[starts-with(@href, 'index.html')]"));
        Assert.assertEquals(home.getText(), "HOME");

        WebElement contactForm = driver.findElement(By.xpath("//a[starts-with(@href, 'contacts.html')]"));
        Assert.assertEquals(contactForm.getText(), "CONTACT FORM");

        WebElement service = driver.findElement(By.className("dropdown-toggle"));
        Assert.assertEquals(service.getText(), "SERVICE");

        WebElement metCol = driver.findElement(By.xpath("//a[starts-with(@href, 'metals-colors.html')]"));
        Assert.assertEquals(metCol.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement practiseIcon = driver.findElement(By.className("icon-practise"));
        Assert.assertTrue(practiseIcon.isDisplayed());

        WebElement customIcon = driver.findElement(By.className("icon-custom"));
        Assert.assertTrue(customIcon.isDisplayed());

        WebElement multiIcon = driver.findElement(By.className("icon-multi"));
        Assert.assertTrue(multiIcon.isDisplayed());

        WebElement baseIcon = driver.findElement(By.className("icon-base"));
        Assert.assertTrue(baseIcon.isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> elements = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(elements.size(), 4);
        Assert.assertEquals(elements.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        Assert.assertEquals(elements.get(1).getText(), "To be flexible and\n" +
                "customizable");
        Assert.assertEquals(elements.get(2).getText(), "To be multiplatform");
        Assert.assertEquals(elements.get(3).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert a text of the main header
        WebElement headerText = driver.findElement(By.className("main-title"));
        Assert.assertEquals(headerText.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement textCenter = driver.findElement(By.cssSelector(".main-txt"));
        Assert.assertEquals(textCenter.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
                "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT " +
                "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

//        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id='iframe']"));
        Assert.assertTrue(iFrame.isDisplayed());

//        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        WebDriver iFrameWebDriver = driver.switchTo().frame("iframe");

//      iFrameWebDriver.get(iFrameWebDriver.getCurrentUrl()); //for Firefox
        WebElement logo = iFrameWebDriver.findElement(By.className("epam-logo"));
        Assert.assertTrue(logo.isDisplayed());

        //12 Switch to original window back
//        driver.navigate().to("https://epam.github.io/JDI/");
//        driver.switchTo().window("mainWindow");

//        //13 Assert a text of the sub header
        WebElement subTxt = driver.findElement(By.xpath("//a[starts-with(@href, 'https://github.com/epam/JDI')]"));
        Assert.assertEquals(subTxt.getText(), "JDI GITHUB");

//        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement subTxt1 = driver.findElement(By.linkText("JDI GITHUB"));
        Assert.assertEquals(subTxt1.getAttribute("href"), "https://github.com/epam/JDI");

//        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.id("mCSB_1"));
        Assert.assertTrue(leftSection.isDisplayed());

//        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.className("footer-bg"));
        Assert.assertTrue(footer.isDisplayed());

        //17 close driver
        driver.close();
    }

    ///Test2///
    @Test(groups = {"Regression"})
    public void regression2() {

        // Open BR
        WebDriver driver = new ChromeDriver();
        String mainWindow = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Navigate
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3 login
        driver.findElement(By.cssSelector("[id = 'user-icon']")).click();
        driver.findElement(By.cssSelector("[id = 'name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id = 'login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector("[id='user-name']"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement home = driver.findElement(By.xpath("//a[starts-with(@href, 'index.html')]"));
        Assert.assertEquals(home.getText(), "HOME");

        WebElement contactForm = driver.findElement(By.xpath("//a[starts-with(@href, 'contacts.html')]"));
        Assert.assertEquals(contactForm.getText(), "CONTACT FORM");

        WebElement service = driver.findElement(By.className("dropdown-toggle"));
        Assert.assertEquals(service.getText(), "SERVICE");

        WebElement metCol = driver.findElement(By.xpath("//a[starts-with(@href, 'metals-colors.html')]"));
        Assert.assertEquals(metCol.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement practiseIcon = driver.findElement(By.className("icon-practise"));
        Assert.assertTrue(practiseIcon.isDisplayed());

        WebElement customIcon = driver.findElement(By.className("icon-custom"));
        Assert.assertTrue(customIcon.isDisplayed());

        WebElement multiIcon = driver.findElement(By.className("icon-multi"));
        Assert.assertTrue(multiIcon.isDisplayed());

        WebElement baseIcon = driver.findElement(By.className("icon-base"));
        Assert.assertTrue(baseIcon.isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> elements = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(elements.size(), 4);
        Assert.assertEquals(elements.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        Assert.assertEquals(elements.get(1).getText(), "To be flexible and\n" +
                "customizable");
        Assert.assertEquals(elements.get(2).getText(), "To be multiplatform");
        Assert.assertEquals(elements.get(3).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert a text of the main header
        WebElement headerText = driver.findElement(By.className("main-title"));
        Assert.assertEquals(headerText.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement textCenter = driver.findElement(By.cssSelector(".main-txt"));
        Assert.assertEquals(textCenter.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
                "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT " +
                "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

//        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id='iframe']"));
        Assert.assertTrue(iFrame.isDisplayed());

//        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        WebDriver iFrameWebDriver = driver.switchTo().frame("iframe");

//      iFrameWebDriver.get(iFrameWebDriver.getCurrentUrl()); //for Firefox
        WebElement logo = iFrameWebDriver.findElement(By.className("epam-logo"));
        Assert.assertTrue(logo.isDisplayed());

        //12 Switch to original window back
//        driver.navigate().to("https://epam.github.io/JDI/");
//        driver.switchTo().window("mainWindow");

//        //13 Assert a text of the sub header
        WebElement subTxt = driver.findElement(By.xpath("//a[starts-with(@href, 'https://github.com/epam/JDI')]"));
        Assert.assertEquals(subTxt.getText(), "JDI GITHUB");

//        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement subTxt1 = driver.findElement(By.linkText("JDI GITHUB"));
        Assert.assertEquals(subTxt1.getAttribute("href"), "https://github.com/epam/JDI");

//        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.id("mCSB_1"));
        Assert.assertTrue(leftSection.isDisplayed());

//        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.className("footer-bg"));
        Assert.assertTrue(footer.isDisplayed());

        //17 close driver
        driver.close();
    }

///Test3///

    @Test(groups = {"Smoke"})
    public void smoke1() {

        // Open BR
        WebDriver driver = new ChromeDriver();
        String mainWindow = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Navigate
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //3 login
        driver.findElement(By.cssSelector("[id = 'user-icon']")).click();
        driver.findElement(By.cssSelector("[id = 'name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id = 'login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector("[id='user-name']"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement home = driver.findElement(By.xpath("//a[starts-with(@href, 'index.html')]"));
        Assert.assertEquals(home.getText(), "HOME");

        WebElement contactForm = driver.findElement(By.xpath("//a[starts-with(@href, 'contacts.html')]"));
        Assert.assertEquals(contactForm.getText(), "CONTACT FORM");

        WebElement service = driver.findElement(By.className("dropdown-toggle"));
        Assert.assertEquals(service.getText(), "SERVICE");

        WebElement metCol = driver.findElement(By.xpath("//a[starts-with(@href, 'metals-colors.html')]"));
        Assert.assertEquals(metCol.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement practiseIcon = driver.findElement(By.className("icon-practise"));
        Assert.assertTrue(practiseIcon.isDisplayed());

        WebElement customIcon = driver.findElement(By.className("icon-custom"));
        Assert.assertTrue(customIcon.isDisplayed());

        WebElement multiIcon = driver.findElement(By.className("icon-multi"));
        Assert.assertTrue(multiIcon.isDisplayed());

        WebElement baseIcon = driver.findElement(By.className("icon-base"));
        Assert.assertTrue(baseIcon.isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> elements = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(elements.size(), 4);
        Assert.assertEquals(elements.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        Assert.assertEquals(elements.get(1).getText(), "To be flexible and\n" +
                "customizable");
        Assert.assertEquals(elements.get(2).getText(), "To be multiplatform");
        Assert.assertEquals(elements.get(3).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert a text of the main header
        WebElement headerText = driver.findElement(By.className("main-title"));
        Assert.assertEquals(headerText.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement textCenter = driver.findElement(By.cssSelector(".main-txt"));
        Assert.assertEquals(textCenter.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
                "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT " +
                "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

//        //10 Assert that there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id='iframe']"));
        Assert.assertTrue(iFrame.isDisplayed());

//        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        WebDriver iFrameWebDriver = driver.switchTo().frame("iframe");

//      iFrameWebDriver.get(iFrameWebDriver.getCurrentUrl()); //for Firefox
        WebElement logo = iFrameWebDriver.findElement(By.className("epam-logo"));
        Assert.assertTrue(logo.isDisplayed());

        //12 Switch to original window back
//        driver.navigate().to("https://epam.github.io/JDI/");
//        driver.switchTo().window("mainWindow");

//        //13 Assert a text of the sub header
        WebElement subTxt = driver.findElement(By.xpath("//a[starts-with(@href, 'https://github.com/epam/JDI')]"));
        Assert.assertEquals(subTxt.getText(), "JDI GITHUB");

//        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement subTxt1 = driver.findElement(By.linkText("JDI GITHUB"));
        Assert.assertEquals(subTxt1.getAttribute("href"), "https://github.com/epam/JDI");

//        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.id("mCSB_1"));
        Assert.assertTrue(leftSection.isDisplayed());

//        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.className("footer-bg"));
        Assert.assertTrue(footer.isDisplayed());

        //17 close driver
        driver.close();
    }
}
