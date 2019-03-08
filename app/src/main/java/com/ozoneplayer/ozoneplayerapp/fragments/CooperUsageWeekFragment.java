package com.ozoneplayer.ozoneplayerapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ozoneplayer.ozoneplayerapp.R;


/**
 * Created by das on 13/07/17.
 */
public class CooperUsageWeekFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_mifi_usage_week, null);
        return view;
    }
}
