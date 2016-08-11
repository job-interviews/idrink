package com.nmp90.idrink.mvp;

import java.lang.ref.WeakReference;

/**
 * Created by joro on 05.08.16.
 */

public abstract class BasePresenter<T> implements BaseContract.BasePresenter {
    protected  WeakReference<T> view;

    protected boolean viewExists(WeakReference reference) {
        return reference != null && reference.get() != null;
    }
}
