package com.ozoneplayer.ozoneplayerapp.views.lato;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.Gravity;

import com.ozoneplayer.ozoneplayerapp.utils.Constants;
import com.ozoneplayer.ozoneplayerapp.utils.FontHelper;


/**
 * LatoLightEditText
 */

public class LatoLightEditText extends AppCompatEditText {
    public LatoLightEditText(Context context) {
        this(context, null);
    }

    public LatoLightEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LatoLightEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(FontHelper.createTypeface(context, Constants.LATO_LIGHT_FONT_FILE));
        setFocusableInTouchMode(true);
        setIncludeFontPadding(false);
        setGravity(Gravity.CENTER| Gravity.START);
    }
}
