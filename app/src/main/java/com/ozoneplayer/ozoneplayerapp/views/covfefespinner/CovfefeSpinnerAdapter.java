package com.ozoneplayer.ozoneplayerapp.views.covfefespinner;

import android.content.Context;

import java.util.List;

/**
 * Created by das on 18/07/17.
 */

public class CovfefeSpinnerAdapter<T> extends CovfefeSpinnerBaseAdapter {
    private final List<T> items;

    public CovfefeSpinnerAdapter(Context context, List<T> items) {
        super(context);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size() - 1;
    }

    @Override
    public T getItem(int position) {
        if (position >= getSelectedIndex()) {
            return items.get(position + 1);
        } else {
            return items.get(position);
        }
    }

    @Override
    public T get(int position) {
        return items.get(position);
    }

    @Override
    public List<T> getItems() {
        return items;
    }
}
