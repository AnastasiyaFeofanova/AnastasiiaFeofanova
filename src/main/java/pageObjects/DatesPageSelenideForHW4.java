package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.webdriverContainer;
import static org.testng.Assert.assertEquals;

// TODO Code convention !!
// TODO Take a look on Selenide assertions instead of TestNg one
public class DatesPageSelenideForHW4 extends LoginHomePageSelenideForHW4 {
    // TODO What is the purpose of this variable and constructor in this particular PO ?
    private WebDriver driver;

    public DatesPageSelenideForHW4(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "li[class = 'dropdown'] a[class = 'dropdown-toggle']")
    private SelenideElement serviceHeader;

    @FindBy(linkText = "DATES")
    private SelenideElement headerDates;

    // TODO This locator can be improved
    @FindBy(css = ".uui-slider blue range ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all")
    private SelenideElement slider;

    // TODO This locator can be improved
    @FindBy(css = "div:nth-child(4) > div:nth-child(2) > div > a")
    private List<SelenideElement> sliders;

    // TODO This locator can be improved
    @FindBy(css = "div:nth-child(4) > div:nth-child(2) > div")
    private SelenideElement sliderLength;

    @FindBy(css = ".info-panel-section")
    private SelenideElement log;

    // TODO What is the reason of this constructor ?
    public DatesPageSelenideForHW4() {
        page(this);
    }

    @Test
    public void openDatesPage() {
        serviceHeader.click();
        headerDates.click();
    }

    boolean validateLogStrings(final List<WebElement> strings, final String name, final String expectedValue) {
        for (WebElement s : strings) {
            String text = s.getText();
            if (text.contains(name)) {
                return text.contains(expectedValue);
            }
        }
        return true;
    }

    // TODO Take a look on java naming convention
    @Test
    public void moveSlider(int _from, int _to) {
        int step = sliderLength.getSize().width;
        Actions move = new Actions(getWebDriver());
        System.out.println(step + "step");
        System.out.println(sliders.get(0).getText() + "from");
        System.out.println(sliders.get(1).getText() + "to");
        move.clickAndHold(sliders.get(0)).moveToElement(sliderLength, (_from * step), 0).release().perform();
        move.clickAndHold(sliders.get(1)).moveToElement(sliderLength, (_to * step), 0).release().perform();
    }

    // TODO Take a look on java naming convention
    /* TODO In general, you should not pass different variable types in similar methods
       moveSlider(int, int)
       ValidateSliderLog(String, String)
    */
    @Test
    public void ValidateSliderLog(String _from, String _to) {
        // TODO Basically, you should not find elements in PO method
        List<WebElement> logStrings = log.findElements(By.tagName("li"));
        // TODO You have to check the log message only, take a look on Selenide ElementsCollection
        Assert.assertTrue(validateLogStrings(logStrings, sliders.get(0).innerText(), _from));
        Assert.assertTrue(validateLogStrings(logStrings, sliders.get(1).innerText(), _to));
    }
}
