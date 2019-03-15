package hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import hw8.MetalsColors;
import hw8.Sections.Result;
import hw8.forms.MetalsAndColorsForm;

public class MetalsAndColorsPage extends WebPage {
    private MetalsAndColorsForm metalsAndColorsForm;
    private Result result;
    @Css("#submit-button")
    public Button submit;

    public void fillForm(MetalsColors values){
        metalsAndColorsForm.fillIn(values);
    }

    public void submit(){
        submit.click();
    }
    public void checkResults(MetalsColors values){
        result.checkResults(values);
    };
}