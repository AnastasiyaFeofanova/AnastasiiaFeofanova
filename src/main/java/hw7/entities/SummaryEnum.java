package hw7.entities;

public enum SummaryEnum {

    ODDS_1("1"),
    ODDS_3("3"),
    ODDS_5("5"),
    ODDS_7("7"),
    EVEN_2("2"),
    EVEN_4("4"),
    EVEN_6("6"),
    EVEN_8("8");

    public String index;

    SummaryEnum(String index){
        this.index = index;
    }


}
