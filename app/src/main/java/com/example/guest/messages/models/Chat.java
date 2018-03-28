package com.example.guest.messages.models;


import org.parceler.Parcel;

@Parcel
public class Chat {
    private String message;
    private String sender;
    private String dateTime;

    public Chat() {}

    public Chat(String message, String sender, String dateTime) {
        this.message = message;
        this.sender = sender;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
