package com.ozoneplayer.ozoneplayerapp.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ozoneplayer.ozoneplayerapp.R;
import com.ozoneplayer.ozoneplayerapp.listeners.OnRecyclerViewItemClickListener;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class UserItemsAdapter extends RecyclerView.Adapter<UserItemsAdapter.DynamicConfigItemsViewHolder> {
    private static final String TAG = UserItemsAdapter.class.getSimpleName();
    private HashMap<String, String> adapterHashMap = new LinkedHashMap<>();
    private String[] hashMapKeys;
    private LayoutInflater layoutInflater;
    private Context context;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public UserItemsAdapter(Context ctx, HashMap<String, String> hashMap) {
        this.context = ctx;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.adapterHashMap = hashMap;
        this.hashMapKeys = hashMap.keySet().toArray(new String[hashMap.size()]);
    }

    @NonNull
    @Override
    public UserItemsAdapter.DynamicConfigItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recyclerview_row, parent, false);
        DynamicConfigItemsViewHolder dciViewHolder = new DynamicConfigItemsViewHolder(view);
        return dciViewHolder;
    }

    @Override
    public void onBindViewHolder(DynamicConfigItemsViewHolder holder, int position) {

        holder.fieldNameTextView.setText(hashMapKeys[position]);
        holder.fieldValueTextView.setText(adapterHashMap.get(hashMapKeys[position]));
    }

    @Override
    public int getItemCount() {
        return adapterHashMap.size();
    }


    public class DynamicConfigItemsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView fieldNameTextView;
        final EditText fieldValueTextView;
        final Button fieldButton;


        DynamicConfigItemsViewHolder(View itemView) {
            super(itemView);
            fieldNameTextView = itemView.findViewById(R.id.fieldName);
            fieldValueTextView = itemView.findViewById(R.id.fieldValue);
            fieldButton = itemView.findViewById(R.id.dynamic_config_save_button);
            fieldButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRecyclerViewItemClickListener != null) {
                        onRecyclerViewItemClickListener.onItemClick(getAdapterPosition(), view);
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            // Do nothing
        }
    }
    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }


}
