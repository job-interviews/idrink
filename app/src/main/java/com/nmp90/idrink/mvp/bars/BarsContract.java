package com.nmp90.idrink.mvp.bars;

import android.location.Location;

import com.nmp90.idrink.api.models.Bar;
import com.nmp90.idrink.mvp.BaseContract;

import java.util.List;

/**
 * Created by joro on 05.08.16.
 */

public interface BarsContract {

    interface View extends BaseContract.BaseView<Presenter> {
        void displayBars(List<Bar> bars);
        void displayNoBars();
        void requestLocationPermissionFromUser();
    }

    interface Presenter extends BaseContract.BasePresenter {
        void loadBars();
        Location getLocation();
        void locationApproved();
        void locationDeclined();
    }
}