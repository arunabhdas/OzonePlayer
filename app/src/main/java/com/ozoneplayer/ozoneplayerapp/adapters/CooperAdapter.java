package com.ozoneplayer.ozoneplayerapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.ozoneplayer.ozoneplayerapp.R;
import com.ozoneplayer.ozoneplayerapp.model.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Das on 10/5/17.
 */

public class CooperAdapter extends ArrayAdapter<Data> {
    private Context ctx;
    private List<Data> mCardProfiles = new ArrayList<>();
    private CooperCallback mCooperCallback;


    public CooperAdapter(Context context, int textViewResourceId,
                         List<Data> list) {
        super(context, textViewResourceId, list);
        ctx = context;
        mCardProfiles = list;
    }

    public void setCooperCallback(CooperCallback mCallback) {
        this.mCooperCallback = mCallback;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int rownumber = position;
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(ctx);
            row = inflater.inflate(R.layout.row_item_layout, parent, false);
        }
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        final Data profile = mCardProfiles.get(position);

        final TextView titleTextView = (TextView) row.findViewById(R.id.title);
        titleTextView.setText(profile.getDisplayName());

        final TextView descriptionTextView = (TextView) row.findViewById(R.id.description);
        descriptionTextView.setText(profile.getDescription());

        final ImageView ivIcon = (ImageView) row.findViewById(R.id.imgIcon);
        // Set the icon

        final Switch switchState = (Switch) row.findViewById(R.id.switchState);
        // temporarily remove the listener so that it will not trigger the checkedChanged
        switchState.setOnCheckedChangeListener(null);
        // Set state
        switchState.setChecked(true);
        switchState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton compoundButton, final boolean checked) {
                // TODO
            }
        });

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCooperCallback != null) {
                    // TODO
                }
            }
        });

        return row;
    }

    public interface CooperCallback {
        void onProfileStateSwitched(final Data profile, final boolean enabling);

        void onProfileSelected(final Data profile);
    }
}