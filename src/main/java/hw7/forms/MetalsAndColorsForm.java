package hw7.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hw7.Sections.Summary;
import hw7.entities.*;

public class MetalsAndColorsForm extends Form<MetalsColorsData>{

    private Summary summary;

    @Css("#elements-checklist p")
    private WebList natureElements;

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

    public void fillIn(MetalsColorsData data) {
        System.out.println(data.summary);
        Summary.odds.select(data.summary.get(0));
        Summary.even.select(data.summary.get(1));
        data.elements.forEach(natureElements::select);
        colors.select(data.color);
        metals.select(data.metals);
        vegetables.select(vegetables.getSelected());
        data.vegetables.forEach(vegetables::select);
    }
}
