package com.nmp90.idrink.api;

import com.nmp90.idrink.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by joro on 05.08.16.
 */

public class iDrinkApi {
    private iDrinkApi() {}

    public static Api createGettiApiService() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(Constants.MAPS_URL);

        return builder.build().create(Api.class);
    }
}
