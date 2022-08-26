package com.example.application.model;

import dev.hilla.Nonnull;

import java.time.ZonedDateTime;

public class Message {
    private @Nonnull String text;
    private ZonedDateTime time;
    private @Nonnull String userName;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}