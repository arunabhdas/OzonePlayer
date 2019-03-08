package com.ozoneplayer.ozoneplayerapp.views.lato;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.ozoneplayer.ozoneplayerapp.utils.Constants;
import com.ozoneplayer.ozoneplayerapp.utils.FontHelper;


/**
 * Created by das on 01/09/16.
 */

public class LatoLightTextView extends AppCompatTextView {


    public LatoLightTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setType(context);
    }

    public LatoLightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setType(context);
    }

    public LatoLightTextView(Context context) {
        super(context);
        setType(context);
    }

    private void setType(Context context){
        this.setTypeface(FontHelper.createTypeface(context, Constants.LATO_LIGHT_FONT_FILE));
        setIncludeFontPadding(false);
    }
}
