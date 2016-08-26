package com.nmp90.idrink.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nmp90.idrink.R;

/**
 * Created by joro on 26.08.16.
 */

public class NoBarsFragment extends BaseFragment {
    public static NoBarsFragment newInstance() {
        return new NoBarsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_no_bars, container, false);
        return view;
    }
}
