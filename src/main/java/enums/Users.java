package enums;

public enum Users {
    PITER("epam","1234","PITER CHAILOVSKII");
    public String login;
    public String password;
    public String userName;
    Users(String login, String password, String userName){
        this.login = login;
        this.password = password;
        this.userName = userName;
    }
}
