package com.nmp90.idrink.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by joro on 11.08.16.
 */

public class BarListFragment extends Fragment {
    public static BarListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        BarListFragment fragment = new BarListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
