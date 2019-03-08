package com.ozoneplayer.ozoneplayerapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.ozoneplayer.ozoneplayerapp.activities.MainDownloadCooperActivity;
import com.ozoneplayer.ozoneplayerapp.activities.MainManageCooperActivity;
import com.ozoneplayer.ozoneplayerapp.fragments.CooperHomeDownloadFragment;
import com.ozoneplayer.ozoneplayerapp.fragments.CooperHomeFragment;
import com.ozoneplayer.ozoneplayerapp.fragments.CooperHomeManageFragment;
import com.ozoneplayer.ozoneplayerapp.fragments.CooperMoreFragment;

import com.ozoneplayer.ozoneplayerapp.fragments.CooperPackagesFragment;
import com.ozoneplayer.ozoneplayerapp.fragments.CooperRatesFragment;
import com.ozoneplayer.ozoneplayerapp.fragments.CooperUsageFragment;
import com.ozoneplayer.ozoneplayerapp.utils.Constants;
import com.ozoneplayer.ozoneplayerapp.views.BottomNavigationViewEx;


public class MainActivity extends AppCompatActivity {

    private static final String BACKSTACK_COOPER_ROOT_TAG = "BACKSTACK_COOPER_ROOT";

    private Context mContext;
    BottomNavigationViewEx mNavigation;
    private CooperUsageFragment mUsageFragment;
    private CooperRatesFragment mRatesFragment;
    private CooperHomeFragment mHomeFragment;
    private CooperPackagesFragment mPackagesFragment;
    private CooperMoreFragment mMoreFragment;
    private CooperHomeManageFragment mHomeManageFragment;
    private CooperHomeDownloadFragment mHomeDownloadFragment;
    private FragmentManager mFragmentManager;
    private FrameLayout mMenuPanel;
    private boolean isMenuPanelVisible;

    private static final int BOTTOM_NAV_SMALL_TEXT_SIZE = 9;
    private static final int BOTTOM_NAV_LARGE_TEXT_SIZE = 16;

    private static final int MIFI_HOME_TAB_INDEX = 2;
    private static final int MIFI_MORE_TAB_INDEX = 4;

    private BottomNavigationViewEx.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationViewEx.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_usage:
                    doUsage();
                    return true;
                case R.id.navigation_rates:
                    doRates();
                    return true;
                case R.id.navigation_home:
                    doHome();
                    return true;
                case R.id.navigation_packages:
                    doPackages();
                    return true;
                case R.id.navigation_more:
                    doMore();
                    return true;
            }
            return true;
        }

    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cooper);
        mContext = this;
        mNavigation = (BottomNavigationViewEx) findViewById(R.id.bottom_navigation);
        mNavigation.enableShiftingMode(false);
        mNavigation.enableAnimation(true);
        mNavigation.enableItemShiftingMode(false);
        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mNavigation.setSmallTextSize(BOTTOM_NAV_SMALL_TEXT_SIZE);
        mNavigation.setLargeTextSize(BOTTOM_NAV_LARGE_TEXT_SIZE);

        mFragmentManager = getSupportFragmentManager();

        mUsageFragment = new CooperUsageFragment();
        mRatesFragment = new CooperRatesFragment();
        mHomeFragment = new CooperHomeFragment();
        mPackagesFragment = new CooperPackagesFragment();
        mMoreFragment = new CooperMoreFragment();

        mHomeManageFragment = new CooperHomeManageFragment();
        mHomeDownloadFragment = new CooperHomeDownloadFragment();

        mNavigation.setSelectedItemId(R.id.navigation_home);
        doHome();


    }

    public void onCooperHomeFragmentManageButtonClick(View v) {

        /* ANDROID-813
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.cooper_enter_anim, R.anim.cooper_exit_anim);
        transaction.replace(R.id.fragment_container, mHomeManageFragment);
        transaction.addToBackStack(BACKSTACK_COOPER_ROOT_TAG);
        transaction.commit();
        */

        final Intent intent = new Intent(MainActivity.this, MainManageCooperActivity.class);
        startActivity(intent);

    }
    public void onCooperHomeFragmentDownloadButtonClick(View v) {

        /* ANDROID-813
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.cooper_enter_anim, R.anim.cooper_exit_anim);
        transaction.replace(R.id.fragment_container, mHomeDownloadFragment);
        transaction.addToBackStack(BACKSTACK_COOPER_ROOT_TAG);
        transaction.commit();
        */

        final Intent intent = new Intent(MainActivity.this, MainDownloadCooperActivity.class);
        startActivity(intent);

    }

    public void onAddCreditButtonClick(View v) {
        if (Constants.LPA_ENABLE) {
            final Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void doUsage() {
        // TODO : Implement this
        if (isMenuPanelVisible) {
            // ANDROID-813 slideUpDown();
        }
        if (mFragmentManager != null) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, mUsageFragment);
            transaction.commit();
        }
    }

    private void doRates() {
        // TODO : Implement this
        if (isMenuPanelVisible) {
            // ANDROID-813 slideUpDown();
        }
        if (mFragmentManager != null) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, mRatesFragment);
            transaction.commit();
        }
    }

    private void doHome() {
        // TODO : Implement this
        if (isMenuPanelVisible) {
            // ANDROID-813 slideUpDown();
        }
        if (mFragmentManager != null) {

            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, mHomeFragment);
            transaction.commit();
        }

        Menu menu = mNavigation.getMenu();
        MenuItem item = menu.getItem(MIFI_HOME_TAB_INDEX);
        item.setChecked(true);
    }

    private void doPackages() {
        // TODO : Implement this
        if (isMenuPanelVisible) {
            // ANDROID-813 slideUpDown();
        }
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, mPackagesFragment);
        transaction.commit();
    }

    private void doMore() {
        // TODO : Implement this
        // ANDROID-813 slideUpDown();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, mMoreFragment);
        transaction.commit();


    }

    public void slideUpDown() {
        Menu menu = mNavigation.getMenu();
        MenuItem item = menu.getItem(MIFI_MORE_TAB_INDEX);
        if(!isMenuPanelVisible) {
            // Show the panel
            Animation bottomUp = AnimationUtils.loadAnimation(this,
                    R.anim.anim_menu_panel_bottom_up);

            mMenuPanel.startAnimation(bottomUp);
            mMenuPanel.setVisibility(View.VISIBLE);
            isMenuPanelVisible = true;
            item.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.mifi_more_selected, null));
        }
        else {
            // Hide the Panel
            Animation bottomDown = AnimationUtils.loadAnimation(this,
                    R.anim.anim_menu_panel_bottom_down);

            mMenuPanel.startAnimation(bottomDown);
            mMenuPanel.setVisibility(View.INVISIBLE);
            isMenuPanelVisible = false;
            item.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.mifi_more, null));
        }
    }

    @Override
    public void onBackPressed(){
        if (mFragmentManager.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            mFragmentManager.popBackStack();
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }
}