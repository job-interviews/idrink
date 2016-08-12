package com.nmp90.idrink.ui.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nmp90.idrink.R;
import com.nmp90.idrink.api.models.Bar;
import com.nmp90.idrink.di.bars.BarsModule;
import com.nmp90.idrink.mvp.bars.BarsContract;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by joro on 11.08.16.
 */

public class MapFragment extends BaseFragment implements BarsContract.View {
    private static final int RC_GET_LOCATION = 124;

    @Inject
    BarsContract.Presenter presenter;

    public static MapFragment newInstance() {
        Bundle args = new Bundle();

        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent().plus(new BarsModule(this)).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bars_list, container, false);
    }

    @Override
    public void onStart() {
        presenter.start();
        super.onStart();
    }

    @Override
    public void onStop() {
        presenter.stop();
        super.onStop();
    }

    @Override
    public void displayBars(List<Bar> bars) {
        Timber.d("Meetings " + bars.size());

        for (int i = 0; i < bars.size(); i++) {
            double d = bars.get(i).getDistance();
            Timber.d(d + "");
        }
    }

    @Override
    public void displayNoBars() {

    }

    @Override
    public void requestLocationPermissionFromUser() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.READ_CONTACTS)) {
            AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                    .setMessage("We need your location to display the bars around you!")
                    .setPositiveButton("OK", (dialogInterface, i) -> {
                    })
                    .create();
            alertDialog.show();
        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    RC_GET_LOCATION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RC_GET_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    presenter.locationApproved();
                } else {
                    presenter.locationDeclined();
                }
                return;
            }
        }
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(BarsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
