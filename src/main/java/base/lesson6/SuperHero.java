package base.lesson6;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;

import java.util.Objects;
//
//@ToString
//@AllArgsConstructor
//@EqualsAndHashCode

public class SuperHero {
    @Override
    public String toString() {
        return "SuperHero{" +
                "number=" + number +
                ", user='" + user + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperHero superHero = (SuperHero) o;
        return Objects.equals(number, superHero.number) &&
                Objects.equals(user, superHero.user) &&
                Objects.equals(description, superHero.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user, description);
    }

    public SuperHero(Integer number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    Integer number;
    String user;
    String description;
}
