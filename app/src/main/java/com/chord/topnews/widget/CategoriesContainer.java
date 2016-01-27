package com.chord.topnews.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.chord.topnews.utils.LogUtils;

/**
 * Created by AllanCL on 2016/1/28.
 */
public class CategoriesContainer extends ViewGroup implements CategoryItem.OnPickedListener {

    private static final String TAG = "CategoriesContainer";

    private static final int PADDING = 20;

    public CategoriesContainer(Context context) {
        super(context);
    }

    public CategoriesContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        LogUtils.d(TAG, "onLayout: width = " + getWidth() + ", height = " + getHeight());
        LogUtils.d(TAG, "onLayout: changed = " + changed + ", l = " + l + ", r = " + r);

        int viewLeft = l + PADDING;
        int viewTop = t + PADDING;
        int viewRight = viewLeft;
        int viewBottom = viewTop;
        int viewWidth = 0;
        int viewHeight = 0;

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            viewWidth = view.getMeasuredWidth();
            viewHeight = view.getMeasuredHeight();
            LogUtils.d(TAG, "onLayout: viewWidth = " + viewWidth + ", viewHeight = " + viewHeight);
            viewRight = viewLeft + viewWidth;
            viewBottom = viewTop + viewHeight;

            if (viewRight > r && viewLeft > PADDING) {
                viewTop = viewBottom + PADDING;
                viewBottom = viewTop + viewHeight;
                viewLeft = PADDING;
                viewRight = viewLeft + viewWidth;
            }

            view.layout(viewLeft, viewTop, viewRight, viewBottom);
            viewLeft = viewRight + PADDING;
        }
    }

    public void addCategory(String category) {
        CategoryItem item = new CategoryItem(getContext(), category);
        item.setOnPickedListener(this);
        addView(item);
    }

    @Override
    public void onPicked(View v) {
        removeView(v);
    }
}
