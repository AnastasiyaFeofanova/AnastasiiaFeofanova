package hw8.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class MetalsColorsData {
    public static MetalsColorsData DATA = new MetalsColorsData(getSummary(), getElements(), getColor(), getMetal(), getVegetables());

    private static List<String> summary = new ArrayList<>();
    private static List<String> elements = new ArrayList<>();
    public static String color;
    public static String metals;
    private static List<String> vegetables = new ArrayList<>();

    public MetalsColorsData(List<String> summary, List<String> elements, String color, String metals, List<String> vegetables) {
    }

    public static List<String> getSummary() {
        summary.add("3");
        summary.add("8");
        return summary;
    }

    public static List<String> getElements() {
        elements.add("Water");
        elements.add("Fire");
        return elements;
    }

    public static List<String> getVegetables() {
        vegetables.add("Cucumber");
        vegetables.add("Tomato");
        return vegetables;
    }

    public static String getColor() {
        color = "Red";
        return color;
    }

    public static String getMetal() {
        metals = "Selen";
        return metals;
    }

}
