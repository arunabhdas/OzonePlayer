package com.ozoneplayer.ozoneplayerapp.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

/**
 * FontHelper caches the typefaces in a static HashMap so that it can be re-used
 * throught the app
 * Created by das on 02/09/16.
 */

public class FontHelper {
    private static final Map<String, Typeface> TYPEFACES = new HashMap<>();
    public static Typeface createTypeface(Context context, String fontFileName){
        Typeface typeface = TYPEFACES.get(fontFileName);
        if(typeface == null){
            typeface = Typeface.createFromAsset(context.getResources().getAssets(), fontFileName);
            TYPEFACES.put(fontFileName, typeface);
        }
        return typeface;
    }

}
