package com.lanceit.haito.lanceit.model;

public class FeedItem {

    private String id;
    private String titile;
    private String description;

    private Long createdAt;
    private Long expireAt;

    private double lat;
    private double lng;

    private int cost;
    private int category;

    public FeedItem(String id, String titile, String description, String createdAt, String expireAt, double lat, double lng, int price, int category) {

        this.id = id;
        this.titile = titile;
        this.description = description;

        this.createdAt = wendeStuffToLong(createdAt);
        this.expireAt = wendeStuffToLong(expireAt);

        this.lat = lat;
        this.lng = lng;

        this.cost = price;
        this.category = category;
    }

    private Long wendeStuffToLong(String timestamp){
        String[] splitted = timestamp.split(":");
        return Long.valueOf(splitted[0].replace("}",""));
    }

    public String getId() {
        return id;
    }

    public String getTitile() {
        return titile;
    }

    public String getDescription() {
        return description;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public int getCost() {
        return cost;
    }

    public int getCategory() {
        return category;
    }
}
