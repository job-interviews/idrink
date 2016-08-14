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
import com.nmp90.idrink.utils.Constants;

import org.parceler.Parcels;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by joro on 11.08.16.
 */

public class BarListFragment extends BaseFragment {

    private List<Bar> bars;
    private Unbinder unbinder;

    @BindView(R.id.rv_bars)
    RecyclerView rvBars;

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

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bars_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvBars.setLayoutManager(layoutManager);
        BarsListAdapter adapter = new BarsListAdapter(bars);
        adapter.getPositionClicks().subscribe((bar) -> {
            LatLng barLocation = bar.getGeometry().getLocation();
            String uri = String.format(Locale.ENGLISH, "geo:%f,%f?q=%s", barLocation.getLat(), barLocation.getLng(), Uri.encode(bar.getVicinity()));
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        });

        rvBars.setAdapter(adapter);
        
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
