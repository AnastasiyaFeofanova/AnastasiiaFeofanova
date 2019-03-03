package hw7.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hw7.Sections.Summary;
import hw7.entities.*;


public class MetalsAndColorsForm extends Form {

    Summary summary;

    @Css("#elements-checklist p")
    public WebList natureElements;

    @JDropdown(root = "div#colors", value = "#colors span.filter-option.pull-left",
            list = "li", expand = ".caret")
    public Droplist colors;

    @JDropdown(root = "div#metals", value = "#metals span.filter-option.pull-left",
            list = "li", expand = ".caret")
    public Droplist metals;

    @JDropdown(root = "#vegetables", value = "#colors span.filter-option.pull-left",
            list = "li", expand = ".caret")
    public Droplist vegetables;

    public void fillIn() {
        summary.odds.select(SummaryEnum.ODDS_3.index);
        summary.even.select(SummaryEnum.EVEN_8.index);
        summary.calculate.click();
        natureElements.select(NatureElementsEnum.WATER);
        natureElements.select(NatureElementsEnum.FIRE.value);
        colors.select(Colors.Red.value);
        metals.select(Metals.SELEN.value);
        vegetables.select(Vegetables.CUCUMBER.value);
        vegetables.select(Vegetables.TOMATO.value);
        vegetables.select(Vegetables.VEGETABLES);
    }

}
