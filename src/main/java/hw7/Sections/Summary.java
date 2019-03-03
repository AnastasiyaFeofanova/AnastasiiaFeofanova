package hw7.Sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;

public class Summary extends Section {
    @FindBy(css = "#odds-selector p")
    public static RadioButtons odds;
    @FindBy(css = "#even-selector p")
    public static RadioButtons even;
    @FindBy(id = "calculate-button")
    public static Button calculate;

}
