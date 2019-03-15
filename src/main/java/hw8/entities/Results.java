package hw8.entities;

import hw8.MetalsColors;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private static List<String> params = new ArrayList<>();

    private static List<String> getParams() {
        params.add("Symmary");
        params.add("Elements");
        params.add("Color");
        params.add("Metal");
        params.add("Vegetables");
        return params;
    }

    private MetalsColors metalsColors;

    public List<String> getResults() {
        List<String> texts = new ArrayList<>();
        for (int i = 0; i < getParams().size(); i++) {
            texts.add(getParams().get(i) + ": " + metalsColors.getMetalsColors().get(i));
        }
        return texts;
    }

}
