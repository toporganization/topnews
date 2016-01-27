package com.chord.topnews.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by AllanCL on 2016/1/28.
 */
public class CategoryItem extends TextView implements View.OnClickListener {

    private OnPickedListener mOnPickedListener;

    public CategoryItem(Context context, String title) {
        super(context);
        setBackgroundResource(android.R.drawable.btn_default);
        setText(title);

        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mOnPickedListener != null) {
            mOnPickedListener.onPicked(v);
        }
    }

    public interface OnPickedListener {
        void onPicked(View v);
    }

    public void setOnPickedListener(OnPickedListener listener) {
        mOnPickedListener = listener;
    }
}
