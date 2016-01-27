package com.chord.topnews.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

/**
 * Created by AllanCL on 2016/1/26.
 */
public class CategoryView extends TextView implements View.OnClickListener {

    private static final String TAG = "CategoryView";

    private boolean mChecked;

    public CategoryView(Context context) {
        super(context);

        setTextColor(Color.WHITE);
        setTypeface(Typeface.DEFAULT_BOLD);
        setPadding(50, 10, 50, 10);
        setOnClickListener(this);
    }

    private void setChecked(boolean checked) {
        mChecked = checked;
    }

    private boolean isChecked() {
        return mChecked;
    }

    @Override
    public void onClick(View v) {
        setChecked(true);
    }
}
