package hw8;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// TODO Code conventions !
@NoArgsConstructor
@Getter
@Setter
public class MetalsColors {

    public List<String> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    private int sum(){
        int i=0;
        for (String aSummary : summary) {
            i += Integer.parseInt(aSummary);
        }
        return i;
    }

    public List<String> getMetalsColors(){
        // TODO Take a look on String::join method.
        // TODO Pay attention on IDEA warning !
        List<String> metCol = new ArrayList<>();
        metCol.add("Summary: "+ sum());
        metCol.add("Elements: "+elements.toString().replaceAll("\\[", "").replaceAll("\\]",""));
        metCol.add("Color: "+color);
        metCol.add("Metal: "+metals.toString());
        metCol.add("Vegetables: "+vegetables.toString().replaceAll("\\[", "").replaceAll("\\]",""));
        return metCol;
    }
}
