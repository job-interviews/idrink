package com.nmp90.idrink.ui.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.nmp90.idrink.R;
import com.nmp90.idrink.ui.fragments.BarListFragment;
import com.nmp90.idrink.ui.fragments.BarMapFragment;

/**
 * Created by joro on 11.08.16.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[2];
    private SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

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
            case BarListFragment.POSITION:
                return BarListFragment.newInstance();
            case BarMapFragment.POSITION:
                return BarMapFragment.newInstance();
            default:
                return BarListFragment.newInstance();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}
