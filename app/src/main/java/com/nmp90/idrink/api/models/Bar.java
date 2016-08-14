package com.nmp90.idrink.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.parceler.Parcel;

/**
 * Created by joro on 11.08.16.
 */

@Parcel
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bar {
    String name;
    String vicinity;
    Geometry geometry;
    double distance;

    public String getName() {
        return name;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public String getVicinity() {
        return vicinity;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
