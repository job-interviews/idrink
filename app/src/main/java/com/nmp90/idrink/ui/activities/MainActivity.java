package com.nmp90.idrink.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.nmp90.idrink.R;
import com.nmp90.idrink.ui.adapters.MainPagerAdapter;
import com.nmp90.idrink.ui.fragments.BarListFragment;
import com.nmp90.idrink.ui.fragments.MapFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tab_layout_main)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), this));

        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
