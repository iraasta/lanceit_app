package com.lanceit.haito.lanceit.model;

/*t*/

import java.sql.Timestamp;
import java.util.ArrayList;

public class FeedItem {
    private String username;
    private String title;
    private String description;

    private String id;

    private int stage;
    private int category;

    private double cost;

    private boolean completed;

    private ArrayList<Attendant> attendants;

    private Location loc;

    private String createdAt;
    private String expireAt;

    public FeedItem(){}

    public FeedItem(String username, String title, String description, String id, int stage, int category, double cost, boolean completed, ArrayList<Attendant> attendants, Location loc, String createdAt, String expireAt) {
        this.username = username;
        this.title = title;
        this.description = description;
        this.id = id;
        this.stage = stage;
        this.category = category;
        this.cost = cost;
        this.completed = completed;
        this.attendants = attendants;
        this.loc = loc;
        this.createdAt = createdAt;
        this.expireAt = expireAt;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
