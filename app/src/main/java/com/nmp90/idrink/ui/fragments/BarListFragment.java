package com.nmp90.idrink.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nmp90.idrink.R;
import com.nmp90.idrink.api.models.Bar;
import com.nmp90.idrink.api.models.LatLng;
import com.nmp90.idrink.ui.adapters.BarsListAdapter;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by joro on 11.08.16.
 */

public class BarListFragment extends BaseFragment {
    public static final int POSITION = 0;

    private Unbinder unbinder;

    @BindView(R.id.rv_bars)
    RecyclerView rvBars;

    public static BarListFragment newInstance() {
        BarListFragment fragment = new BarListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bars_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvBars.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    public void setBars(List<Bar> bars) {
        BarsListAdapter adapter = new BarsListAdapter(getResources(), bars);
        adapter.getPositionClicks().subscribe((bar) -> {
            LatLng barLocation = bar.getGeometry().getLocation();
            String uri = String.format(Locale.ENGLISH, "geo:%f,%f?q=%s", barLocation.getLat(), barLocation.getLng(), Uri.encode(bar.getVicinity()));
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        });

        rvBars.setAdapter(adapter);
    }
}
