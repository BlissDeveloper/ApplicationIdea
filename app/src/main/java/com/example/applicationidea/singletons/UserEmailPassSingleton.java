package com.example.applicationidea.singletons;

public class UserEmailPassSingleton {
    private String email, pass;

    private static final UserEmailPassSingleton ourInstance = new UserEmailPassSingleton();

    public static UserEmailPassSingleton getInstance() {
        return ourInstance;
    }

    private UserEmailPassSingleton() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
