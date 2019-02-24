package enums;

import java.util.ArrayList;
import java.util.List;

public enum ServiceDropdownOptions {
    support("SUPPORT"),
    dates("DATES"),
    complexTable("COMPLEX TABLE"),
    simpleTable("SIMPLE TABLE"),
    userTable("USER TABLE"),
    tableWithPages("TABLE WITH PAGES"),
    differentElements("DIFFERENT ELEMENTS"),
    performance("PERFORMANCE");

    public String values;

    ServiceDropdownOptions(String values){
        this.values = values;
    }

    public static List<String> getValues(){
        List<String> links = new ArrayList<>();
        for (ServiceDropdownOptions i: ServiceDropdownOptions.values()) {
            links.add(i.values);
        }
        return links;
    }
}
