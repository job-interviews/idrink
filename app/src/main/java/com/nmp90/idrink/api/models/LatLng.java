package com.nmp90.idrink.api.models;

/**
 * Created by joro on 11.08.16.
 */

public class LatLng {
    private double lat;
    private double lng;

    public LatLng() {}

    public LatLng(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override public String toString() {
        return String.format("%.1f,%.1f", lat, lng);
    }
}

