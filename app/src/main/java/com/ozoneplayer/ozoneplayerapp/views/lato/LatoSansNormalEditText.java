package com.ozoneplayer.ozoneplayerapp.views.lato;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.ozoneplayer.ozoneplayerapp.utils.Constants;
import com.ozoneplayer.ozoneplayerapp.utils.FontHelper;


/**
 * LatoSansNormalEditText
 */

public class LatoSansNormalEditText extends EditText {
    public LatoSansNormalEditText(Context context) {
        this(context, null);
    }

    public LatoSansNormalEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LatoSansNormalEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(FontHelper.createTypeface(context, Constants.LATO_REGULAR_FONT_FILE));
    }
}
