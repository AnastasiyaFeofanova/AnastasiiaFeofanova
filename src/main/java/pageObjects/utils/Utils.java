package pageObjects.utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils {
    public static boolean validateLogStrings(final List<WebElement> strings, final String name, final String expectedValue) {
        for (WebElement s : strings) {
            String text = s.getText();
            if (text.contains(name)) {
                return text.contains(expectedValue);
            }
        }
        return true;
    }
}
