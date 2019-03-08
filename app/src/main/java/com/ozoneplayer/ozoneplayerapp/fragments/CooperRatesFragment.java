package com.ozoneplayer.ozoneplayerapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ozoneplayer.ozoneplayerapp.R;
import com.ozoneplayer.ozoneplayerapp.adapters.SubTabAdapter;
import com.ozoneplayer.ozoneplayerapp.views.covfefespinner.CovfefeSpinner;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by das on 13/06/17.
 */

public class CooperRatesFragment extends Fragment {

    // views
    private TextView vToolbarTitle;
    // ANDROID-813 private CovfefeSegmentedTabs vSegmentedTabs;
    private SubTabAdapter mSubTabAdapter;
    private ViewPager vViewPager;
    private CovfefeSpinner vSpinner;
    private Context mContext;

    //lists
    private ArrayList<String> mCountryFlagKeys;
    private List<String> mAllCountries = new ArrayList<>();

    private class LoadCountriesTask extends AsyncTask<String, Integer, Long> {
        protected Long doInBackground(String... str) {
            long lineNumber = 0;
            InputStreamReader inputStreamReader;
            try {
                inputStreamReader = new
                        InputStreamReader(mContext.getAssets().open(str[0]));
                Scanner inputStream = new Scanner(inputStreamReader);
                inputStream.nextLine(); // Ignores the first line

                while (inputStream.hasNext()) {
                    lineNumber++;
                    String data = inputStream.nextLine(); // Gets a whole line
                    String[] line = data.split(","); // Splits the line up into a string array

                    if (line.length > 1) {
                        mAllCountries.add(line[0]);
                    }
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lineNumber;
        }

        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(Long result) {
            vSpinner.setItems(mAllCountries);
            vSpinner.setOnItemSelectedListener(new CovfefeSpinner.OnItemSelectedListener<String>() {

                @Override
                public void onItemSelected(CovfefeSpinner view, int position, long id, String item) {
                    // TODO : Implement this
                }
            });
            vSpinner.setOnNothingSelectedListener(new CovfefeSpinner.OnNothingSelectedListener() {

                @Override
                public void onNothingSelected(CovfefeSpinner spinner) {
                    // TODO : Implement this
                }
            });
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_cooper_rates, null);
        // ANDROID-813 vToolbarTitle = (TextView) view.findViewById(R.id.toolbar_title);
        // ANDROID-813 vSegmentedTabs = (CovfefeSegmentedTabs) view.findViewById(R.id.segmented_tabs);
        // ANDROID-813 vViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        // ANDROID-813 vToolbarTitle.setText(Constants.MIFI_TAB_RATES_TITLE);
        // ANDROID-813 vSpinner = (CovfefeSpinner) view.findViewById(R.id.spinner);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private ArrayList<String> getCountryFlagList() {
        if (mCountryFlagKeys == null) {
            mCountryFlagKeys = new ArrayList<String>();
        }
        return mCountryFlagKeys;
    }

}
