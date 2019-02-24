package enums;

public enum RadioButtons {

    RADIO_BOXES("Gold", "Silver", "Bronze", "Selen", "metal");
    public String gold;
    public String silver;
    public String bronze;
    public String selen;
    public String on;

    RadioButtons(String gold, String silver, String bronze, String selen, String on){
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.selen = selen;
        this.on = on;
    }

}
