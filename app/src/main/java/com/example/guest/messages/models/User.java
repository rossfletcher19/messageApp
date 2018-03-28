package com.example.guest.messages.models;


public class User {
    private String name;
    private String email;
    private String pushId;

    public User() {}

    public User(String name, String email, String pushId) {
        this.name = name;
        this.email = email;
        this.pushId = pushId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}

