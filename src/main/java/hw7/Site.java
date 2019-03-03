package hw7;

import hw7.pages.IndexPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.pages.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class Site {
    @Url("index.html")
    public static IndexPage indexPage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;
}