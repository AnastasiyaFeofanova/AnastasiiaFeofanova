package hw7.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hw7.Sections.Summary;
import hw7.entities.*;

// TODO This class should be parametrise by Entity, take a look on Login form from classwork.
public class MetalsAndColorsForm extends Form {

    Summary summary;

    @Css("#elements-checklist p")
    public WebList natureElements;

    @JDropdown(
            root = "div#colors",
            value = "#colors span.filter-option.pull-left",
            list = "li", expand = ".caret")
    public Droplist colors;

    @JDropdown(
            root = "div#metals",
            value = "#metals span.filter-option.pull-left",
            list = "li", expand = ".caret")
    public Droplist metals;

    @JDropdown(root = "#vegetables", value = "#salad-dropdown", list = "li", expand = ".caret")
    public Droplist vegetables;

    public void fillIn() {
        // TODO Pay attention on IDEA warning !!
        summary.odds.select(SummaryEnum.ODDS_3.index);
        summary.even.select(SummaryEnum.EVEN_8.index);
        // TODO Where did you find this action in test script ?
        summary.calculate.click();
        natureElements.select(NatureElementsEnum.WATER);
        natureElements.select(NatureElementsEnum.FIRE.value);
        colors.select(Colors.Red.value);
        metals.select(Metals.SELEN.value);
        vegetables.select(vegetables.getSelected());
        vegetables.select(Vegetables.CUCUMBER.value);
        vegetables.select(Vegetables.TOMATO.value);
    }

}
