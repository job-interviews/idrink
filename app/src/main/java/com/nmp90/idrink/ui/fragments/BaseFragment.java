package com.nmp90.idrink.ui.fragments;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.nmp90.idrink.di.HasComponent;
import com.nmp90.idrink.di.app.AppComponent;
import com.nmp90.idrink.iDrinkApplication;

/**
 * Created by joro on 05.08.16.
 */

public abstract class BaseFragment extends Fragment {
    public static final String TAG = BaseFragment.class.getSimpleName();
    /**
     * Shows a {@link android.widget.Toast} message.
     *
     * @param message An string representing a message to be shown.
     */
    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    protected AppComponent getAppComponent() {
        return iDrinkApplication.getApplicationComponent();
    }

    public String getTitle() {
        return TAG;
    }
}
