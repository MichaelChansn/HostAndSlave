package com.example.test;

import android.content.Context;
import android.util.DisplayMetrics;

public class Utils {
	
	private static DisplayMetrics sDisplayMetrics;
	public static int px2dip(Context context, float pxValue) {
        // final float scale = context.getResources().getDisplayMetrics().density;
        final float scale = getDensity(context);
        return (int) (pxValue / scale);
    }
	
	public static int dp2pix(Context context, float dpValue) {
        // final float scale = context.getResources().getDisplayMetrics().density;
        final float scale = getDensity(context);
        return (int) (dpValue * scale);
    }
	
	public static float getDensity(Context context) {
        // 使用框的Context，防止插件调用接口时传入自己的Context
        initDisplayMetrics(context);
        return sDisplayMetrics.density;
    }
	
	private static void initDisplayMetrics(Context context) {
        if (null == sDisplayMetrics) {
            Context appContext = context.getApplicationContext();
            if (null == appContext) {
                appContext = context;
            }
            sDisplayMetrics = appContext.getResources().getDisplayMetrics();
        }
    }

}