package com.ozoneplayer.ozoneplayerapp.views.lato;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ozoneplayer.ozoneplayerapp.utils.Constants;
import com.ozoneplayer.ozoneplayerapp.utils.FontHelper;


/**
 * Created by das on 01/09/16.
 */

public class LatoNormalTextView extends TextView {

    public LatoNormalTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setType(context);
    }

    public LatoNormalTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setType(context);
    }

    public LatoNormalTextView(Context context) {
        super(context);
        setType(context);
    }

    private void setType(Context context){
        this.setTypeface(FontHelper.createTypeface(context, Constants.LATO_REGULAR_FONT_FILE));
        setIncludeFontPadding(false);
    }
}
