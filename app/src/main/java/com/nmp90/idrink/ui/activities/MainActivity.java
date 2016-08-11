package com.nmp90.idrink.ui.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.nmp90.idrink.R;
import com.nmp90.idrink.api.models.Bar;
import com.nmp90.idrink.di.bars.BarsModule;
import com.nmp90.idrink.mvp.bars.BarsContract;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

public class MainActivity extends BaseActivity implements BarsContract.View {
    private static final int RC_GET_LOCATION = 124;

    @Inject
    BarsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplicationComponent().plus(new BarsModule(this)).inject(this);
    }

    @Override
    protected void onStart() {
        presenter.start();
        presenter.loadBars();
        super.onStart();
    }

    @Override
    protected void onStop() {
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
    public void requestLocationPermissionFromUser() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_CONTACTS)) {

            // Show an expanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.

        } else {

            // No explanation needed, we can request the permission.

            ActivityCompat.requestPermissions(this,
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

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public boolean isActive() {
        return !isFinishing();
    }

    @Override
    public void setPresenter(BarsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
