package hw7.entities;

import java.util.ArrayList;
import java.util.List;

public enum Results {
    Summary("Summary: 11"),
    Elements("Elements: Water, Fire"),
    Color("Color: Red"),
    Metal("Metal: Selen"),
    Vegetables("Vegetables: Cucumber, Tomato");

    public String parameter;

    Results(String parameter) {
        this.parameter = parameter;
    }

    public static List<String> getResults(){
        List<String> texts = new ArrayList<>();
        for (Results s:Results.values()) {
            texts.add(s.parameter);
        }
        return texts;
    }
}
