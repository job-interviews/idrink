package com.nmp90.idrink.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.parceler.Parcel;

/**
 * Created by joro on 11.08.16.
 */

@Parcel
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {
    LatLng location;

    public LatLng getLocation() {
        return location;
    }

    public com.google.android.gms.maps.model.LatLng getGoogleLocation() {
        return new com.google.android.gms.maps.model.LatLng(location.getLat(), location.getLng());
    }
}
