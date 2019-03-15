package enums;

import java.util.ArrayList;
import java.util.List;

public enum HeaderOptions {
    home("HOME"),
    contactForme("CONTACT FORM"),
    service("SERVICE"),
    metalsAndColors("METALS & COLORS");

    public String values;

    HeaderOptions(String values) {
        this.values = values;
    }

    public static List<String> getValues() {
        List<String> links = new ArrayList<>();
        for (HeaderOptions i : HeaderOptions.values()) {
            links.add(i.values);
        }
        return links;
    }
}
