package com.nmp90.idrink.ui.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nmp90.idrink.R;
import com.nmp90.idrink.api.models.Bar;
import com.nmp90.idrink.ui.fragments.BarListFragment;
import com.nmp90.idrink.ui.fragments.MapFragment;

import java.util.List;

/**
 * Created by joro on 11.08.16.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[2];
    private List<Bar> bars;

    public MainPagerAdapter(FragmentManager fm, Context context, List<Bar> bars) {
        super(fm);
        this.bars = bars;
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
                return BarListFragment.newInstance(bars);
            case 1:
                return MapFragment.newInstance(bars);
            default:
                return BarListFragment.newInstance(bars);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
