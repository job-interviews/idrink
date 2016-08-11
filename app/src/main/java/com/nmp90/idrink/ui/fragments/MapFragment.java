package com.nmp90.idrink.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by joro on 11.08.16.
 */

public class MapFragment extends Fragment {
    public static MapFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
