package com.nmp90.idrink.ui.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;

import com.nmp90.idrink.R;
import com.nmp90.idrink.api.models.Bar;
import com.nmp90.idrink.di.bars.BarsModule;
import com.nmp90.idrink.mvp.bars.BarsContract;
import com.nmp90.idrink.ui.adapters.MainPagerAdapter;
import com.nmp90.idrink.ui.fragments.BarListFragment;
import com.nmp90.idrink.ui.fragments.MapFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements BarsContract.View {

    private static final int RC_GET_LOCATION = 124;

    @Inject
    BarsContract.Presenter presenter;

    @BindView(R.id.tab_layout_main)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplicationComponent().plus(new BarsModule(this)).inject(this);

        unbinder = ButterKnife.bind(this);

        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), this));

        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
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
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_CONTACTS)) {
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setMessage("We need your location to display the bars around you!")
                    .setPositiveButton("OK", (dialogInterface, i) -> {})
                    .create();
            alertDialog.show();
        } else {
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
