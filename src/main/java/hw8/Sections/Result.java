package hw8.Sections;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import hw7.entities.Results;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Result extends Section {
    @FindBy(css = ".info-panel-body-result li")
    public WebList result;

    public void checkResults() {
        List<String> resultList = new ArrayList<>();
        for (WebElement element : result) {
            resultList.add(element.getText());
        }
        Assert.assertEquals(resultList, Results.getResults());
    }
}
