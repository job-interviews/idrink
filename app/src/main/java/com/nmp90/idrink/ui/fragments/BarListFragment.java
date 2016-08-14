package com.nmp90.idrink.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nmp90.idrink.R;
import com.nmp90.idrink.api.models.Bar;
import com.nmp90.idrink.utils.Constants;

import org.parceler.Parcels;

import java.util.List;

import timber.log.Timber;

/**
 * Created by joro on 11.08.16.
 */

public class BarListFragment extends BaseFragment {

    private List<Bar> bars;

    public static BarListFragment newInstance(List<Bar> bars) {
        Bundle args = new Bundle();
        args.putParcelable(Constants.KEY_BARS, Parcels.wrap(bars));

        BarListFragment fragment = new BarListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bars = Parcels.unwrap(getArguments().getParcelable(Constants.KEY_BARS));
        Timber.d("" + bars.size());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bars_list, container, false);
    }


}
