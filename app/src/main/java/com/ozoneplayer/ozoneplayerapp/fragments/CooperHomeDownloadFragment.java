package com.ozoneplayer.ozoneplayerapp.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import com.ozoneplayer.ozoneplayerapp.R;
import com.ozoneplayer.ozoneplayerapp.adapters.CooperAdapter;
import com.ozoneplayer.ozoneplayerapp.model.Data;


/**
 * Created by das on 13/06/17.
 */
public class CooperHomeDownloadFragment extends Fragment {
    private static final int CONDITION_OF_USE_NOT_SATISFIED = 0x6985;
    private static final int CAT_BUSY = 0x05;
    private TextView vToolbarTitle;
    private View vRootLayout;
    // ANDROID-813 private RecyclerView vRecyclerView;
    private ListView vCooperListView;
    private TextView tvEmptyList;
    // ANDROID-813 private ProfilesAdapter mProfilesAdapter;
    private CooperAdapter mCooperAdapter;

    // private AndroidProfile[] cardProfile;
    List<Data> mCardProfiles = new ArrayList<>();
    private Context mContext;



    private Spinner vCooperSpinner;
    private CooperEndpointSpinnerAdapter mCooperEndpointsSpinnerAdapter;
    private Dialog vCooperDialog;

    private Button vButtonDownloadProfile;

    private String mButtonDownloadTitle;

    private List<String> mCooperEndpointFriendlyNames = new ArrayList<>();
    private List<String> mCooperEndpointKeys = new ArrayList<>();



    private class CooperEndpointSpinnerAdapter extends ArrayAdapter<String> {
        private Context ctx;
        List<String> mEndpointList;
        public CooperEndpointSpinnerAdapter(Context context, int textViewResourceId,
                                            List<String> provincesList) {
            super(context, textViewResourceId, provincesList);
            ctx = context;
            mEndpointList = provincesList;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final int rownumber = position;
            View row = convertView;
            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row_item_endpoint, parent, false);
            }
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vCooperSpinner.setSelection(position);
                    if (vCooperDialog != null) {
                        vCooperDialog.dismiss();
                    }
                }
            });

            final TextView endpointNameTextView = (TextView) row.findViewById(R.id.endpointName);
            endpointNameTextView.setText(mEndpointList.get(position));

            return row;
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_download_cooper_home, null);
        mContext = getActivity();

        return view;
    }





}
