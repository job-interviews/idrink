package com.nmp90.idrink.mvp.bars;

import com.nmp90.idrink.api.Api;
import com.nmp90.idrink.mvp.BasePresenter;

import javax.inject.Inject;

/**
 * Created by joro on 05.08.16.
 */

public class BarsPresenter extends BasePresenter<BarsContract.View> implements BarsContract.Presenter {

    private Api iDrinkApi;
    private BarsContract.View view;

    @Inject
    public BarsPresenter(Api iDrinkApi, BarsContract.View view) {
        this.iDrinkApi = iDrinkApi;
        this.view = view;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void loadMeetings() {

    }
}
