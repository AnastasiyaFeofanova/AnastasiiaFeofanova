package pageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPageSelenideForHW4 extends LoginHomePageSelenideForHW4 {

    @FindBy(css = "li[class = 'dropdown'] a[class = 'dropdown-toggle']")
    private SelenideElement serviceHeader;

    @FindBy(linkText = "DATES")
    private SelenideElement headerDates;

    // TODO This locator can be improved
    //div[class ='uui-slider blue range ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all'] > a
    @FindBy(css = "div:nth-child(4) > div:nth-child(2) > div > a")
    private List<SelenideElement> sliders;

    // TODO This locator can be improved
    //div[class= 'uui-slider blue range ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']
    @FindBy(css = "div:nth-child(4) > div:nth-child(2) > div")
    private SelenideElement sliderLength;

    @FindBy(css = ".info-panel-section")
    private SelenideElement log;
    @FindBy(css = ".panel-body-list.logs")
    private ElementsCollection logs;

    @Test
    public void openDatesPage() {
        serviceHeader.click();
        headerDates.click();
    }

    @Test
    public void moveSlider(int xFrom, int xTo) {
        int step = sliderLength.getSize().width;
        Actions move = new Actions(getWebDriver());
        System.out.println(step + "step");
        System.out.println(sliders.get(0).getText() + "before from");
        System.out.println(sliders.get(1).getText() + "before to");
        move.clickAndHold(sliders.get(0)).moveToElement(sliderLength, (xFrom * step / 99), 0).release().perform();
        move.clickAndHold(sliders.get(1)).moveToElement(sliderLength, (xTo * step / 99), 0).release().perform();
        System.out.println(sliders.get(0).getText() + "after from");
        System.out.println(sliders.get(1).getText() + "after to");
    }

    @Test
    public void validateSliderLog(int xFrom, int xTo) {
        logs.shouldHave(CollectionCondition.textsInAnyOrder(sliders.get(0).innerText()), CollectionCondition.textsInAnyOrder(String.valueOf(xFrom)));
        logs.shouldHave(CollectionCondition.textsInAnyOrder(sliders.get(1).innerText()), CollectionCondition.textsInAnyOrder(String.valueOf(xTo)));
    }
}
