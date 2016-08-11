package com.nmp90.idrink.ui.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nmp90.idrink.R;
import com.nmp90.idrink.ui.fragments.BarListFragment;
import com.nmp90.idrink.ui.fragments.MapFragment;

/**
 * Created by joro on 11.08.16.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[2];


    public MainPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        tabTitles[0] = context.getString(R.string.bar_list);
        tabTitles[1] = context.getString(R.string.map);

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return BarListFragment.newInstance();
            case 1:
                return MapFragment.newInstance();
            default:
                return BarListFragment.newInstance();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
