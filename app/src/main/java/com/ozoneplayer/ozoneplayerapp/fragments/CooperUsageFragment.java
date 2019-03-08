package com.ozoneplayer.ozoneplayerapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ozoneplayer.ozoneplayerapp.R;
import com.ozoneplayer.ozoneplayerapp.adapters.SubTabAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by das on 13/06/17.
 */
public class CooperUsageFragment extends BaseFragment{
    private static final String TAG = CooperUsageFragment.class.getSimpleName();
    private TextView vToolbarTitle;
    // ANDROID-813 private CovfefeSegmentedTabs vSegmentedTabs;
    private SubTabAdapter mSubTabAdapter;
    private ViewPager vViewPager;
    private Context mContext;
    private CooperUsageDayFragment mUsageDayFragment;
    private CooperUsageWeekFragment mUsageWeekFragment;
    private CooperUsageMonthFragment mUsageMonthFragment;
    private CooperUsageYearFragment mUsageYearFragment;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_cooper_usage, null);
        // ANDROID-813 vToolbarTitle = (TextView) view.findViewById(R.id.toolbar_title);
        // ANDROID-813 vSegmentedTabs = (CovfefeSegmentedTabs) view.findViewById(R.id.segmented_tabs);
        // ANDROID-813 vViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        // ANDROID-813 vToolbarTitle.setText(Constants.MIFI_TAB_USAGE_TITLE);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupSegmentedTabs();

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "MifiUsageFragment onStart");
    }

    protected void setupSegmentedTabs() {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        mUsageDayFragment = new CooperUsageDayFragment();
        mUsageWeekFragment = new CooperUsageWeekFragment();
        mUsageMonthFragment = new CooperUsageMonthFragment();
        mUsageYearFragment = new CooperUsageYearFragment();

        /* ANDROID-813
        fragmentList.add(mUsageDayFragment);
        titles.add(getResources().getString(R.string.mifi_usage_tab_day_title));
        fragmentList.add(mUsageWeekFragment);
        titles.add(getResources().getString(R.string.mifi_usage_tab_week_title));
        fragmentList.add(mUsageMonthFragment);
        titles.add(getResources().getString(R.string.mifi_usage_tab_month_title));
        fragmentList.add(mUsageYearFragment);
        titles.add(getResources().getString(R.string.mifi_usage_tab_year_title));


        this.mSubTabAdapter = new SubTabAdapter(getFragmentManager(), mContext, fragmentList);
        */
        // ANDROID-813 this.vViewPager.setAdapter(this.mSubTabAdapter);
        // ANDROID-813 this.vSegmentedTabs.setupWithViewPager(vViewPager);
        // ANDROID-813 this.vSegmentedTabs.setup(titles);
    }

}
