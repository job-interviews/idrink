package com.nmp90.idrink.api;

import com.nmp90.idrink.api.models.BarsResult;
import com.nmp90.idrink.api.models.LatLng;
import com.nmp90.idrink.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by joro on 05.08.16.
 */

public interface Api {
    @GET("nearbysearch/json")
    Observable<BarsResult> getBars(@Query("location") LatLng location, @Query("radius") int radius, @Query("type") String type, @Query("key") String key);

    class Builder {
        private Builder() {}

        public static Api createGettiApiService() {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);  // <-- this is the important line!

            Retrofit.Builder builder = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .baseUrl(Constants.MAPS_URL)
                    .client(httpClient.build());

            return builder.build().create(Api.class);
        }
    }
}
