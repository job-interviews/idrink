package com.nmp90.idrink.mvp;

/**
 * Created by joro on 05.08.16.
 */

public interface BaseContract {
    interface BasePresenter {
    }

    interface BaseView<T> {
        void setPresenter(T presenter);
    }
}
