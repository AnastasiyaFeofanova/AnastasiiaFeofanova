package pageObjects.utils;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;

import java.util.Objects;
//
//@ToString
//@AllArgsConstructor
//@EqualsAndHashCode

public class DropdownValues {

    public DropdownValues() {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DropdownValues{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DropdownValues)) return false;
        DropdownValues that = (DropdownValues) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String value;
}
