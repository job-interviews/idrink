package com.nmp90.idrink.api.models;

import org.parceler.Parcel;

/**
 * Created by joro on 11.08.16.
 */

@Parcel
public class LatLng {
    double lat;
    double lng;

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

