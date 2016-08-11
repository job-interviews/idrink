package com.nmp90.idrink.mvp.bars;

import com.nmp90.idrink.api.models.Bars;
import com.nmp90.idrink.mvp.BaseContract;

import java.util.List;

/**
 * Created by joro on 05.08.16.
 */

public interface BarsContract {

    interface View extends BaseContract.BaseView<Presenter> {
        void displayBars(List<Bars> bars);
    }

    interface Presenter extends BaseContract.BasePresenter {
        void loadMeetings();
    }
}