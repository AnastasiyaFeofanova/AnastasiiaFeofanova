package enums;

public enum CheckBoxes {
CHECK_BOXES("Water", "Earth", "Wind", "Fire", "true", "false");
    public String water = "Water";
    public String earth = "Earth";
    public String wind = "Wind";
    public String fire = "Fire";
    public String on;
    public String off;


    CheckBoxes(String water, String earth, String wind, String fire, String on, String off){
        this.water = water;
        this.earth = earth;
        this.wind = wind;
        this.fire = fire;
        this.on = on;
        this.off = off;
    }
}
