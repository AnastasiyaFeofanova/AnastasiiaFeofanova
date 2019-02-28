package base.jdi.entities;

//import lombok.AllArgsConstructor;
//
//@AllArgsConstructor
public class User {
    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public static User PETER = new User("epam", "1234", "PETER CHAVLOVSKY");

    String login;
    String password;
    String fullName;
}
