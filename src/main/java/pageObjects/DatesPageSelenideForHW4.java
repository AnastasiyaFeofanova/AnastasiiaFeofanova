package pageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.*;

public class DatesPageSelenideForHW4 extends LoginHomePageSelenideForHW4 {

    @FindBy(css = "li[class = 'dropdown'] a[class = 'dropdown-toggle']")
    private SelenideElement serviceHeader;

    @FindBy(linkText = "DATES")
    private SelenideElement headerDates;

    @FindBy(css = "div:nth-child(4) > div:nth-child(2) > div > a")
    private List<SelenideElement> sliders;

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
        sliderAction(0, xFrom, step);
        sliderAction(1, xTo, step);
    }

    private void sliderAction(int slider, int x, int step) {
        new Actions(getWebDriver())
                .clickAndHold(sliders.get(slider))
                .moveToElement(sliderLength, (x * step / 99), 0).release()
                .perform();
    }

    @Test
    public void validateSliderLog(int xFrom, int xTo) {
        logs.shouldHave(textsInAnyOrder(sliders.get(0).innerText()), textsInAnyOrder(valueOf(xFrom)));
        logs.shouldHave(textsInAnyOrder(sliders.get(1).innerText()), textsInAnyOrder(valueOf(xTo)));
    }
}
