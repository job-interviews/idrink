package com.nmp90.idrink.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.parceler.Parcel;

/**
 * Created by joro on 11.08.16.
 */

@Parcel
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bar {
    private String name;
    private Geometry geometry;
    private double distance;

    public String getName() {
        return name;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
