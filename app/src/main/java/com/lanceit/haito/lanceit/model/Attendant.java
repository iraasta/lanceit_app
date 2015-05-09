package com.lanceit.haito.lanceit.model;

public class Attendant {

    private String username;
    private boolean expired;

    public Attendant(String username, boolean expired) {
        this.username = username;
        this.expired = expired;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
