package com.nmp90.idrink;

import android.app.Application;

import com.nmp90.idrink.components.logger.TimberCrashReportingTree;
import com.nmp90.idrink.di.app.AppComponent;
import com.nmp90.idrink.di.app.AppModule;
import com.nmp90.idrink.di.app.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import timber.log.Timber;

/**
 * Created by joro on 03.08.16.
 */

public class iDrinkApplication extends Application {
    private static AppComponent applicationComponent;
    private static RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

        refWatcher = LeakCanary.install(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new TimberCrashReportingTree());
        }
    }

    public static AppComponent getApplicationComponent() {
        return applicationComponent;
    }
}
