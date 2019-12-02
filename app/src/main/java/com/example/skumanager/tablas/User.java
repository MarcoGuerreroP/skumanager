package com.example.skumanager.tablas;

public class User {
    private Integer user;
    private String email;
    private String password;

    public User(Integer user, String email, String password) {
        this.user = user;
        this.email = email;
        this.password = password;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
