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

public class GroupsRegression extends SeleniumBase {
    ///Test1///
    @Test(groups = {"Regression"})
    public void regression1() {

        /// Open BR
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

        WebElement contactform = driver.findElement(By.xpath("//a[starts-with(@href, 'contacts.html')]"));
        Assert.assertEquals(contactform.getText(), "CONTACT FORM");

        WebElement service = driver.findElement(By.className("dropdown-toggle"));
        Assert.assertEquals(service.getText(), "SERVICE");

        WebElement metcol = driver.findElement(By.xpath("//a[starts-with(@href, 'metals-colors.html')]"));
        Assert.assertEquals(metcol.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement practiseicon = driver.findElement(By.className("icon-practise"));
        Assert.assertTrue(practiseicon.isDisplayed());

        WebElement customicon = driver.findElement(By.className("icon-custom"));
        Assert.assertTrue(customicon.isDisplayed());

        WebElement multiicon = driver.findElement(By.className("icon-multi"));
        Assert.assertTrue(multiicon.isDisplayed());

        WebElement baseicon = driver.findElement(By.className("icon-base"));
        Assert.assertTrue(baseicon.isDisplayed());

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
        WebDriver iframeWebDriver = driver.switchTo().frame("iframe");

//      iframeWebDriver.get(iframeWebDriver.getCurrentUrl()); //for Firefox
        WebElement logo = iframeWebDriver.findElement(By.className("epam-logo"));
        Assert.assertTrue(logo.isDisplayed());

        //12 Switch to original window back
//        driver.navigate().to("https://epam.github.io/JDI/");
//        driver.switchTo().window("mainWindow");

//        //13 Assert a text of the sub header
        WebElement subtxt = driver.findElement(By.xpath("//a[starts-with(@href, 'https://github.com/epam/JDI')]"));
        Assert.assertEquals(subtxt.getText(), "JDI GITHUB");

//        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement subtxt1 = driver.findElement(By.linkText("JDI GITHUB"));
        Assert.assertEquals(subtxt1.getAttribute("href"), "https://github.com/epam/JDI");

//        //15 Assert that there is Left Section
        WebElement leftsection = driver.findElement(By.id("mCSB_1"));
        Assert.assertTrue(leftsection.isDisplayed());

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

        WebElement contactform = driver.findElement(By.xpath("//a[starts-with(@href, 'contacts.html')]"));
        Assert.assertEquals(contactform.getText(), "CONTACT FORM");

        WebElement service = driver.findElement(By.className("dropdown-toggle"));
        Assert.assertEquals(service.getText(), "SERVICE");

        WebElement metcol = driver.findElement(By.xpath("//a[starts-with(@href, 'metals-colors.html')]"));
        Assert.assertEquals(metcol.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement practiseicon = driver.findElement(By.className("icon-practise"));
        Assert.assertTrue(practiseicon.isDisplayed());

        WebElement customicon = driver.findElement(By.className("icon-custom"));
        Assert.assertTrue(customicon.isDisplayed());

        WebElement multiicon = driver.findElement(By.className("icon-multi"));
        Assert.assertTrue(multiicon.isDisplayed());

        WebElement baseicon = driver.findElement(By.className("icon-base"));
        Assert.assertTrue(baseicon.isDisplayed());

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
        WebDriver iframeWebDriver = driver.switchTo().frame("iframe");

//      iframeWebDriver.get(iframeWebDriver.getCurrentUrl()); //for Firefox
        WebElement logo = iframeWebDriver.findElement(By.className("epam-logo"));
        Assert.assertTrue(logo.isDisplayed());

        //12 Switch to original window back
//        driver.navigate().to("https://epam.github.io/JDI/");
//        driver.switchTo().window("mainWindow");

//        //13 Assert a text of the sub header
        WebElement subtxt = driver.findElement(By.xpath("//a[starts-with(@href, 'https://github.com/epam/JDI')]"));
        Assert.assertEquals(subtxt.getText(), "JDI GITHUB");

//        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement subtxt1 = driver.findElement(By.linkText("JDI GITHUB"));
        Assert.assertEquals(subtxt1.getAttribute("href"), "https://github.com/epam/JDI");

//        //15 Assert that there is Left Section
        WebElement leftsection = driver.findElement(By.id("mCSB_1"));
        Assert.assertTrue(leftsection.isDisplayed());

//        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.className("footer-bg"));
        Assert.assertTrue(footer.isDisplayed());

        //17 close driver
        driver.close();
    }

///Test3///

    @Test(groups = {"Regression"})
    public void regression3() {

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

        WebElement contactform = driver.findElement(By.xpath("//a[starts-with(@href, 'contacts.html')]"));
        Assert.assertEquals(contactform.getText(), "CONTACT FORM");

        WebElement service = driver.findElement(By.className("dropdown-toggle"));
        Assert.assertEquals(service.getText(), "SERVICE");

        WebElement metcol = driver.findElement(By.xpath("//a[starts-with(@href, 'metals-colors.html')]"));
        Assert.assertEquals(metcol.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement practiseicon = driver.findElement(By.className("icon-practise"));
        Assert.assertTrue(practiseicon.isDisplayed());

        WebElement customicon = driver.findElement(By.className("icon-custom"));
        Assert.assertTrue(customicon.isDisplayed());

        WebElement multiicon = driver.findElement(By.className("icon-multi"));
        Assert.assertTrue(multiicon.isDisplayed());

        WebElement baseicon = driver.findElement(By.className("icon-base"));
        Assert.assertTrue(baseicon.isDisplayed());

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
        WebDriver iframeWebDriver = driver.switchTo().frame("iframe");

//      iframeWebDriver.get(iframeWebDriver.getCurrentUrl()); //for Firefox
        WebElement logo = iframeWebDriver.findElement(By.className("epam-logo"));
        Assert.assertTrue(logo.isDisplayed());

        //12 Switch to original window back
//        driver.navigate().to("https://epam.github.io/JDI/");
//        driver.switchTo().window("mainWindow");

//        //13 Assert a text of the sub header
        WebElement subtxt = driver.findElement(By.xpath("//a[starts-with(@href, 'https://github.com/epam/JDI')]"));
        Assert.assertEquals(subtxt.getText(), "JDI GITHUB");

//        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement subtxt1 = driver.findElement(By.linkText("JDI GITHUB"));
        Assert.assertEquals(subtxt1.getAttribute("href"), "https://github.com/epam/JDI");

//        //15 Assert that there is Left Section
        WebElement leftsection = driver.findElement(By.id("mCSB_1"));
        Assert.assertTrue(leftsection.isDisplayed());

//        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.className("footer-bg"));
        Assert.assertTrue(footer.isDisplayed());

        //17 close driver
        driver.close();
    }
}