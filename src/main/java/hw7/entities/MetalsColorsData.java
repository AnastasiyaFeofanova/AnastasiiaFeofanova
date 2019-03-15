package hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static hw7.entities.Results.Color;
@AllArgsConstructor
@NoArgsConstructor
public class MetalsColorsData {

    public static MetalsColorsData DATA = new MetalsColorsData(getSum(), getEl(), "Red", "Selen", getVeg());

    private static List<String> getSum(){
        List<String> sum = new ArrayList<>();
        sum.add("3");
        sum.add("8");
        System.out.println(sum);
        return sum;
    }

    private static List<String> getEl(){
        List<String> el = new ArrayList<>();
        el.add("Water");
        el.add("Fire");
        return el;
    }

    private static List<String> getVeg(){
        List<String> veg = new ArrayList<>();
        veg.add("Cucumber");
        veg.add("Tomato");
        return veg;
    }

    public List<String> summary = new ArrayList<>();
    public List<String> elements = new ArrayList<>();
    public String color;
    public String metals;
    public List<String> vegetables = new ArrayList<>();

}
