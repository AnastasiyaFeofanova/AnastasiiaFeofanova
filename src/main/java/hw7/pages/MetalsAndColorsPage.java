package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import hw7.Sections.Result;
import hw7.entities.MetalsColorsData;
import hw7.forms.MetalsAndColorsForm;

import java.util.List;

public class MetalsAndColorsPage extends WebPage {
    private MetalsAndColorsForm metalsAndColorsForm;
    private Result result;
    @Css("#submit-button")
    public Button submit;
    private hw7.entities.MetalsColorsData MetalsColorsData;

    public void fillForm(MetalsColorsData data) {
        metalsAndColorsForm.fillIn(data);
    }

    public void submit() {
        submit.click();
    }

    public void checkResults(List<String> results) {
        result.checkResults(results);
    }
}