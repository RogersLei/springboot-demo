package com.springboot.study.entity;

public class User {
    private String username;
    private String password;
    private String description;

    public User() {
    }

    public User(String username, String password, String description) {
        super();
        this.username = username;
        this.password = password;
        this.description = description;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
