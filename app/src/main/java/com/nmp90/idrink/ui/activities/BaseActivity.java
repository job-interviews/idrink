package com.nmp90.idrink.ui.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.nmp90.idrink.di.app.AppComponent;
import com.nmp90.idrink.iDrinkApplication;
import com.nmp90.idrink.ui.fragments.BaseFragment;

/**
 * Created by joro on 05.08.16.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected void addFragment(int containerViewId, BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment, fragment.getTitle());
        fragmentTransaction.commit();
    }

    protected void replaceFragment(int containerViewId, BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment, fragment.getTitle());
        fragmentTransaction.commit();
    }

    protected void showErrorDialog(FragmentManager fragmentManager, String description) {

    }

    protected AppComponent getApplicationComponent() {
        return iDrinkApplication.getApplicationComponent();
    }
}
