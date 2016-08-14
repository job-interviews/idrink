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

public class BarListFragment extends BaseFragment {

    public static BarListFragment newInstance() {
        Bundle args = new Bundle();
        
        BarListFragment fragment = new BarListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bars_list, container, false);
    }


}
