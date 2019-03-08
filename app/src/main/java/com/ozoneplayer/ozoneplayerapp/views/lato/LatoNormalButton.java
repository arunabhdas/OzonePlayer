package com.ozoneplayer.ozoneplayerapp.views.lato;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.ozoneplayer.ozoneplayerapp.utils.Constants;
import com.ozoneplayer.ozoneplayerapp.utils.FontHelper;


/**
 * LatoNormalButton
 */

public class LatoNormalButton extends Button {
    public LatoNormalButton(Context context) {
        this(context, null);
    }

    public LatoNormalButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LatoNormalButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(FontHelper.createTypeface(context, Constants.LATO_REGULAR_FONT_FILE));
    }
}
