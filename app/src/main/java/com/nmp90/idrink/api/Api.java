package com.nmp90.idrink.api;

import com.nmp90.idrink.api.models.BarsResult;
import com.nmp90.idrink.api.models.LatLng;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by joro on 05.08.16.
 */

public interface Api {
    @GET("nearbysearch/json")
    Observable<BarsResult> getBars(@Query("location") LatLng location, @Query("radius") int radius, @Query("type") String type, @Query("key") String key);
}
