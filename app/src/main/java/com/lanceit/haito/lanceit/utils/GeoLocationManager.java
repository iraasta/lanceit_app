package com.lanceit.haito.lanceit.utils;


import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class GeoLocationManager implements LocationListener {
    //TODO: If more of finals will be in this class it might wise to move to the refference section
    public static final double R = 6372.8; // Earth Radiurs

    private double lat;
    private double lng;

    public GeoLocationManager(){

    }



    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lng = location.getLongitude();
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
    @Override
    public void onProviderEnabled(String provider) {
    }
    @Override
    public void onProviderDisabled(String provider) {
    }

    public double getDistanceFrom(double lat, double lng){
        double dLat = Math.toRadians(lat - this.lat);
        double dLon = Math.toRadians(lng - this.lng);

        lat = Math.toRadians(lat);
        double thisLat = Math.toRadians(this.lat);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(thisLat) * Math.cos(lat);
        double c = 2 * Math.asin(Math.sqrt(a));
        return Math.round(R * c * 100)/100;
    }

    public double getLat() {
        return lat;
    }
    public double getLng() {
        return lng;
    }
}
