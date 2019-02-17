package pageObjects;

import com.codeborne.selenide.Condition;
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

public class DatesPageSelenideForHW4 extends LoginHomePageSelenideForHW4{
    private WebDriver driver;
    public DatesPageSelenideForHW4(WebDriver driver){this.driver = driver;}

    @FindBy(css = "li[class = 'dropdown'] a[class = 'dropdown-toggle']")
    private SelenideElement serviceHeader;
    @FindBy(linkText = "DATES")
    private SelenideElement headerDates;

    @FindBy(css = ".uui-slider blue range ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all")
    private SelenideElement slider;
    @FindBy(css = "div:nth-child(4) > div:nth-child(2) > div > a")
    private List<SelenideElement> sliders;
    @FindBy(css = "div:nth-child(4) > div:nth-child(2) > div")
    private SelenideElement sliderLength;
    @FindBy(css = ".info-panel-section")
    private SelenideElement log;

    public DatesPageSelenideForHW4(){
        page(this);
    }

    @Test
    public void openDatesPage(){
        serviceHeader.click();
        headerDates.click();
    }

    boolean validateLogStrings(final List<WebElement> strings, final String name, final String expectedValue) {
        for(WebElement s : strings) {
            String text = s.getText();
            if(text.contains(name)) {
                return text.contains(expectedValue);
            }
        }
        return true;
    }

    @Test
    public void moveSlider(int _from, int _to){
        int step = sliderLength.getSize().width;
        Actions move = new Actions(getWebDriver());
        System.out.println(step+"step");
        System.out.println(sliders.get(0).getText()+"from");
        System.out.println(sliders.get(1).getText()+"to");
        move.clickAndHold(sliders.get(0)).moveToElement(sliderLength, (_from*step) , 0).release().perform();
        move.clickAndHold(sliders.get(1)).moveToElement(sliderLength, (_to*step) , 0).release().perform();
    }

    @Test
    public void ValidateSliderLog(String _from, String _to) {
        List<WebElement> logStrings = log.findElements(By.tagName("li"));
        Assert.assertTrue(validateLogStrings(logStrings, sliders.get(0).innerText(), _from));
        Assert.assertTrue(validateLogStrings(logStrings, sliders.get(1).innerText(), _to));
    }
}
