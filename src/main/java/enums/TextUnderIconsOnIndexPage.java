package enums;

import java.util.ArrayList;
import java.util.List;

public enum  TextUnderIconsOnIndexPage {
    first("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    second("To be flexible and\n" +
            "customizable"),
    third("To be multiplatform"),
    fourth("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    String values;
    TextUnderIconsOnIndexPage(String values){
        this.values=values;
    }

    public static List<String> getTextUnderIconsOnIndexPage(){
        List<String> texts = new ArrayList<>();
        for (TextUnderIconsOnIndexPage s:TextUnderIconsOnIndexPage.values()) {
            texts.add(s.values);
        }
        return texts;
    }
}
