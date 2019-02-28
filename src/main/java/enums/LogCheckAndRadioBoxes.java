package enums;

public enum LogCheckAndRadioBoxes {
    WATER_ON("Water: condition changed to true"),
    WIND_ON("Wind: condition changed to true"),
    WATER_OFF("Water: condition changed to false"),
    WIND_OFF("Wind: condition changed to false"),
    SELEN_ON("metal: value changed to Selen"),
    YELLOW_ON("Colors: value changed to Yellow");
    public String parameter;

    LogCheckAndRadioBoxes(String parameter) {
        this.parameter = parameter;
    }
}
