package enums;

public enum CheckBox {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire"),
    ON("true"),
    OFF("false");

    private String value;

    CheckBox(String value){
        this.value = value;
    }
}
