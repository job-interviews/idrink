# idrink

Sample app for bar locations around you

# Libs & Technologies

* RxJava, MVP, Dagger2, Retrofit, Jackson, LeakCanary, Timber, Butterknife.

# Some words on the libs and technologies

1. The app uses MVP to transfer data to the activity.
2. Dependency injection using Dagger2 is used to allow loose coupling between components and to easily replace them
3. RxJava is used to additionaly sort the data and to replace the interface usage for listeners
4. ButterKnife and LeakCanary are helper libs to make devs life easy
5. DataBinding is not used although it could be

# How stuff works? And some tricky moments

1. We have a single view which is the MainActivity view. It is connected with a BarPresenter which supplies bars to it through API calls.
2. The MainAcitivty delivers the data to the fragment by directly passing the data to them.
3. The presenter tells the acitivity when to request permission for location and what to do if the permission is denied.
4. Calling "super.instantiateItem(container, position);" in the ViewPagerAdapter is one of the two ways to get the current active fragment from the adapter and pass data to it.
5. LocationUtils.getDistanceFromLatLngInKm can be replaced with Location.distanceBetween().
6. We inject the view to the presenter when we are building the AppComponent: "getApplicationComponent().plus(new BarsModule(this)).inject(this);".
