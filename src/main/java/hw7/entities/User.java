package hw7.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {

    public static User PITER = new User("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String userName;
}
