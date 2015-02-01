package com.lanceit.haito.lanceit.model;

public class FeedItem {

    private String titile;
    private String description;
    private int dissapearAfter;

    private double lat;
    private double lng;

    private int price;

    public FeedItem(String id, String titile, String description, int dissapearAfter, double lat, double lng, int price) {
        this.id = id;
        this.titile = titile;
        this.description = description;
        this.dissapearAfter = dissapearAfter;
        this.lat = lat;
        this.lng = lng;
        this.price = price;
    }

    private String id;

    public String getId() {
        return id;
    }

    public String getTitile() {
        return titile;
    }

    public String getDescription() {
        return description;
    }

    public int getDissapearAfter() {
        return dissapearAfter;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public int getPrice() {
        return price;
    }
}
