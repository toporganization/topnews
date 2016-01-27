package com.chord.topnews.utils;

import android.util.Log;

/**
 * Created by AllanCL on 2016/1/25.
 */
public class LogUtils {

    private static final String APP_TAG = "TopNews";

    public static void v(String tag, String msg) {
        Log.v(APP_TAG, "[" + tag + "]" + msg);
    }

    public static void d(String tag, String msg) {
        Log.d(APP_TAG, "[" + tag + "]" + msg);
    }

    public static void i(String tag, String msg) {
        Log.i(APP_TAG, "[" + tag + "]" + msg);
    }

    public static void w(String tag, String msg) {
        Log.w(APP_TAG, "[" + tag + "]" + msg);
    }

    public static void e(String tag, String msg) {
        Log.e(APP_TAG, "[" + tag + "]" + msg);
    }

    public static void wtf(String tag, String msg) {
        Log.wtf(APP_TAG, "[" + tag + "]" + msg);
    }
}
