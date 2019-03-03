package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import hw7.Sections.Result;
import hw7.forms.MetalsAndColorsForm;

public class MetalsAndColorsPage extends WebPage {
    MetalsAndColorsForm metalsAndColorsForm;
    Result result;
    @Css("#submit-button")
    public Button submit;

    public void fillForm(){
        metalsAndColorsForm.fillIn();
    }

    public void submit(){
        submit.click();
    }
    public void checkResults(){
        result.checkResults();
    };
}