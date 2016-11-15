package com.dataart.serenitybdd.models;

/**
 * Created by achernyshev on 11.11.2016.
 */

public class UserBuilder {
    public static User admin() {
        User user = new User("admin", "admin");
        user.setFname("Ivan");
        user.setLname("Petrov");
        return user;
    }

    public static User getUser() {
        User user = new User("user", "user");
        user.setFname("Aleksei");
        user.setLname("Chernyshev");
        user.setRole("user");
        return user;
    }


    public static User getDeveloper() {
        User developer = new User("developer", "developer");
        developer.setFname("Aleksei_dev");
        developer.setLname("Chernyshev_dev");
        developer.setRole("developer");
        return developer;
    }
}
