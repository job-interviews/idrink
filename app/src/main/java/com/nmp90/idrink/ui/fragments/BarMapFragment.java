package com.nmp90.idrink.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nmp90.idrink.R;
import com.nmp90.idrink.api.models.Bar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by joro on 11.08.16.
 */

public class BarMapFragment extends BaseFragment implements OnMapReadyCallback {

    public static final int POSITION = 1;

    @BindView(R.id.map)
    MapView mapView;

    private GoogleMap googleMap;
    private Unbinder unbinder;
    private List<Bar> bars;

    public static BarMapFragment newInstance() {
        BarMapFragment fragment = new BarMapFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        unbinder = ButterKnife.bind(this, view);

        setupMap(savedInstanceState);

        return view;
    }

    private void setupMap(@Nullable Bundle savedInstanceState) {
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        mapView = null;
        googleMap.clear();
        googleMap = null;

        unbinder.unbind();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        if(bars != null) {
            setBarLocationsView();
        }
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
        if(googleMap != null) {
            setBarLocationsView();
        }
    }

    private void setBarLocationsView() {
        LatLng firstBarLocation = bars.get(0).getGeometry().getGoogleLocation();

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(firstBarLocation));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(firstBarLocation, 12.0f));

        for(Bar bar : bars) {
            googleMap.addMarker(new MarkerOptions()
                    .position(bar.getGeometry().getGoogleLocation())
                    .snippet(getBarDistanceString(bar))
                    .title(bar.getName()));
        }
    }

    private String getBarDistanceString(Bar bar) {
        return String.format(getString(R.string.bar_distance_format), bar.getDistance());
    }
}
