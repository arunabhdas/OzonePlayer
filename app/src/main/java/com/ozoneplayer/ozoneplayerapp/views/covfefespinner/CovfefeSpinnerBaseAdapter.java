package com.ozoneplayer.ozoneplayerapp.views.covfefespinner;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.ozoneplayer.ozoneplayerapp.R;

import java.util.List;

/**
 * Created by das on 18/07/17.
 */

public abstract class CovfefeSpinnerBaseAdapter<T> extends BaseAdapter {

    private final Context context;
    private int selectedIndex;
    private int textColor;

    public CovfefeSpinnerBaseAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TextView textView;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.covfefe_spinner_list_item, parent, false);
            textView = (TextView) convertView.findViewById(R.id.covfefe_spinner_item_tinted_spinner);
            textView.setTextColor(textColor);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                Configuration config = context.getResources().getConfiguration();
                if (config.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL) {
                    textView.setTextDirection(View.TEXT_DIRECTION_RTL);
                }
            }
            convertView.setTag(new CovfefeSpinnerBaseAdapter.ViewHolder(textView));
        } else {
            textView = ((CovfefeSpinnerBaseAdapter.ViewHolder) convertView.getTag()).textView;
        }
        textView.setText(getItem(position).toString());
        return convertView;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void notifyItemSelected(int index) {
        selectedIndex = index;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract T getItem(int position);

    @Override
    public abstract int getCount();

    public abstract T get(int position);

    public abstract List<T> getItems();

    public CovfefeSpinnerBaseAdapter<T> setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    private static class ViewHolder {

        private TextView textView;

        private ViewHolder(TextView textView) {
            this.textView = textView;
        }

    }

}
