package com.nmp90.idrink.di.app;

import com.nmp90.idrink.di.bars.BarsComponent;
import com.nmp90.idrink.di.bars.BarsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joro on 05.08.16.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    BarsComponent plus(BarsModule module);
}
