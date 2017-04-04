package com.example.gkpatel.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by gkpatel on 30/3/17.
 */

public class FontStyle {

    public static void digital_font(Context context,TextView textView)
    {
        Typeface typeface =Typeface.createFromAsset(context.getAssets(),"digital-7.ttf");
        textView.setTypeface(typeface);
    }
    public static void digital_italic_font(Context context,TextView textView)
    {
        Typeface typeface =Typeface.createFromAsset(context.getAssets(), "digital_italic.ttf");
        textView.setTypeface(typeface);
    }
    public static void robot_bold_font(Context context, TextView textView)
    {
        Typeface typeface =Typeface.createFromAsset(context.getAssets(), "Roboto_Bold.ttf");
        textView.setTypeface(typeface);
    }
    public  static  void robot_regular_font(Context context , TextView textView)
    {
        Typeface typeface =Typeface.createFromAsset(context.getAssets(), "Roboto_Regular.ttf");
        textView.setTypeface(typeface);
    }
}
