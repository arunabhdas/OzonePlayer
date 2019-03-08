package com.ozoneplayer.ozoneplayerapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.View;


import com.ozoneplayer.ozoneplayerapp.R;

import junit.framework.Assert;

/**
 * Created by das on 16/05/17.
 */

public class CooperUtil {

    public static final String TIMESTAMP_PARAM = "_";
    // TODO : FIXME : Remove this hardcoded value later
    public static final String TIMESTAMP_VALUE = "1494611792121";

    public static String constructUrl(String param, Context context) {
        Uri builtUri = Uri.parse(Constants.MIFI_ENDPOINT_BASE_URL)
                .buildUpon()
                .appendQueryParameter(CooperUtil.TIMESTAMP_PARAM, CooperUtil.TIMESTAMP_VALUE)
                .build();
        return builtUri.toString();

    }
    /**
     * Darkens a color by a given factor.
     *
     * @param color
     *     the color to darken
     * @param factor
     *     The factor to darken the color.
     * @return darker version of specified color.
     */
    public static int darker(int color, float factor) {
        return Color.argb(Color.alpha(color), Math.max((int) (Color.red(color) * factor), 0),
                Math.max((int) (Color.green(color) * factor), 0),
                Math.max((int) (Color.blue(color) * factor), 0));
    }

    /**
     * Lightens a color by a given factor.
     *
     * @param color
     *     The color to lighten
     * @param factor
     *     The factor to lighten the color. 0 will make the color unchanged. 1 will make the
     *     color white.
     * @return lighter version of the specified color.
     */
    public static int lighter(int color, float factor) {
        int red = (int) ((Color.red(color) * (1 - factor) / 255 + factor) * 255);
        int green = (int) ((Color.green(color) * (1 - factor) / 255 + factor) * 255);
        int blue = (int) ((Color.blue(color) * (1 - factor) / 255 + factor) * 255);
        return Color.argb(Color.alpha(color), red, green, blue);
    }

    /**
     * Check if layout direction is RTL
     *
     * @param context
     *     the current context
     * @return {@code true} if the layout direction is right-to-left
     */
    public static boolean isRtl(Context context) {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 &&
                context.getResources().getConfiguration().getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
    }

    /**
     * Return a drawable object associated with a particular resource ID.
     *
     * <p>Starting in {@link Build.VERSION_CODES#LOLLIPOP}, the returned drawable will be styled for the
     * specified Context's theme.</p>
     *
     * @param id
     *     The desired resource identifier, as generated by the aapt tool.
     *     This integer encodes the package, type, and resource entry.
     *     The value 0 is an invalid identifier.
     * @return Drawable An object that can be used to draw this resource.
     */
    public static Drawable getDrawable(Context context, int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getDrawable(id);
        }
        return context.getResources().getDrawable(id);
    }

    public static synchronized SharedPreferences getPersistantGlobals(Context context) {
        if (context != null)
            return context.getSharedPreferences(Constants.COOPER_PERSISTENT_GLOBALS, Context.MODE_PRIVATE);
        else
            return null;
    }


    public static synchronized String getSelectedEndpoint(Context context) {
        return getPersistantGlobals(context).getString(Constants.COOPER_SELECTED_ENDPOINT, context.getString(R.string.gd_key_0));
    }
    public static synchronized void setSelectedEndpoint(String selectedEndpoint, Context context) {
        Assert.assertTrue(getPersistantGlobals(context).edit().putString(Constants.COOPER_SELECTED_ENDPOINT, selectedEndpoint).commit());
    }

}
