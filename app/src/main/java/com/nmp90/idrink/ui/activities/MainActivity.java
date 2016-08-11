package com.nmp90.idrink.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;
import com.nmp90.idrink.R;
import com.nmp90.idrink.api.models.Bars;
import com.nmp90.idrink.di.bars.BarsModule;
import com.nmp90.idrink.mvp.bars.BarsContract;
import com.nmp90.idrink.mvp.bars.BarsPresenter;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

public class MainActivity extends BaseActivity implements BarsContract.View, GoogleApiClient.OnConnectionFailedListener {

    @Inject
    BarsContract.Presenter presenter;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplicationComponent().plus(new BarsModule(this)).inject(this);

        Timber.d(presenter.toString());
        presenter.loadMeetings();

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();


    }



    @Override
    public void displayBars(List<Bars> barses) {
        Timber.d("Meetings " + barses.size());
    }

    @Override
    public void setPresenter(BarsContract.Presenter presenter) {
        this.presenter = (BarsPresenter) presenter;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
