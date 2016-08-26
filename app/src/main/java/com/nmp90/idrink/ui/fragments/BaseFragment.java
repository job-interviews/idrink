package com.nmp90.idrink.ui.fragments;

import android.support.v4.app.Fragment;

/**
 * Created by joro on 05.08.16.
 */

public abstract class BaseFragment extends Fragment {
    public static final String TAG = BaseFragment.class.getSimpleName();

    public String getTitle() {
        return TAG;
    }
}
