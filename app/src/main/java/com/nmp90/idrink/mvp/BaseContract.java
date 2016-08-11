package com.nmp90.idrink.mvp;

/**
 * Created by joro on 05.08.16.
 */

public interface BaseContract {
    interface BasePresenter {
        void start();
        void stop();
    }

    interface BaseView<T> {
        boolean isActive();
        void setPresenter(T presenter);
    }
}
