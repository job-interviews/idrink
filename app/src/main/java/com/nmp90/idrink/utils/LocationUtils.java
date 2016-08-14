package com.nmp90.idrink.utils;

/**
 * Created by joro on 11.08.16.
 */

public class LocationUtils {
    // Haversine formula
    // Can be replaced with: Location.distanceBetween();
    public static double getDistanceFromLatLonInKm(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371; // Radius of the earth in km
        double dLat = toRadian(lat2-lat1);  // toRadian below
        double dLon = toRadian(lon2-lon1);
        double a =
                Math.sin(dLat/2) * Math.sin(dLat/2) +
                        Math.cos(toRadian(lat1)) * Math.cos(toRadian(lat2)) *
                                Math.sin(dLon/2) * Math.sin(dLon/2)
                ;
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return earthRadius * c;
    }

    public static double toRadian(Double deg) {
        return deg * (Math.PI/180);
    }
}
