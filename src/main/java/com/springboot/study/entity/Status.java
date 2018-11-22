package com.springboot.study.entity;

public class Status {
    private String username;
    private String status;

    public Status(){
    }

    public Status( String username, String status) {
        super();
        this.username = username;
        this.status = status;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
