package hw8.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hw8.MetalsColors;
import hw8.Sections.Summary;

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

    @JDropdown(root = "#vegetables", value = "#salad-dropdown",
            list = "li", expand = ".caret")
    public Droplist vegetables;

    public void fillIn(MetalsColors metCol) {
        summary.odds.select(metCol.getSummary().get(0));
        summary.even.select(metCol.getSummary().get(1));
        summary.calculate.click();
        metCol.getElements().forEach(natureElements::select);
        colors.select(metCol.getColor());
        metals.select(metCol.getMetals());
        for (String s : vegetables.getSelected().split(" ")) {
            vegetables.select(s);
        }
        metCol.getVegetables().forEach(vegetables::select);
    }
}
