package hw8.Sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.complex.Menu;

public class Header extends Section {
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8")
    public Menu menuNavigation;
}
