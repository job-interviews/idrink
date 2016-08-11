package com.nmp90.idrink.di.bars;

import com.nmp90.idrink.api.Api;
import com.nmp90.idrink.mvp.bars.BarsContract;
import com.nmp90.idrink.mvp.bars.BarsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joro on 05.08.16.
 */

@Module
public class BarsModule {
    BarsContract.View view;
    public BarsModule(BarsContract.View view) {
        this.view = view;
    }

    @Provides
    public BarsContract.View providesView() {
        return view;
    }

    @Provides
    public BarsContract.Presenter providesPresenter(Api tourmeetApi) {
        return new BarsPresenter(tourmeetApi, view);
    }
}
