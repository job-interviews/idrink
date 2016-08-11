package com.nmp90.idrink.di.app;

import android.content.Context;

import com.nmp90.idrink.api.Api;
import com.nmp90.idrink.api.iDrinkApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joro on 05.08.16.
 */

@Module
public class AppModule {
    private final Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    Api provideApi() {
        return iDrinkApi.createGettiApiService();
    }
}
