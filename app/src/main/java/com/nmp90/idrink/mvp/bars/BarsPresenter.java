package com.nmp90.idrink.mvp.bars;

import com.nmp90.idrink.api.Api;
import com.nmp90.idrink.mvp.BasePresenter;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by joro on 05.08.16.
 */

public class BarsPresenter extends BasePresenter<BarsContract.View> implements BarsContract.Presenter {

    private Api tourMeetApi;
    private BarsContract.View view;

    @Inject
    public BarsPresenter(Api tourMeetApi, BarsContract.View view) {
        this.tourMeetApi = tourMeetApi;
        this.view = view;
    }

    @Inject
    void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void loadMeetings() {
        tourMeetApi.getMeetings("").subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(meetings -> {
                        view.displayBars(meetings);
                }, err -> {

                });
    }
}
