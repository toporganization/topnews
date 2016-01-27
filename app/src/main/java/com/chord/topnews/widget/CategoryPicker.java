package com.chord.topnews.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;

import com.chord.topnews.R;

/**
 * Created by AllanCL on 2016/1/27.
 */
public class CategoryPicker extends PopupWindow {

    private static final String TAG = "CategoryPicker";

    public CategoryPicker(Context context) {
        super(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        setContentView(inflater.inflate(R.layout.category_picker, null));
        setWidth(LayoutParams.MATCH_PARENT);
        setHeight(500);
        setOutsideTouchable(true);
    }
}
