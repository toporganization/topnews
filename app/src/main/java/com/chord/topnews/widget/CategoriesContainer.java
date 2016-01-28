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
        final int specWidth = resolveSize(0, widthMeasureSpec);
        LogUtils.d(TAG, "specWidth = " + specWidth);

        int width = PADDING;
        int height = PADDING;
        int lastWidth = PADDING;

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            width += childWidth + PADDING;

            LogUtils.d(TAG, "lastWidth = " + lastWidth + ", width = " + width);
            if (height == PADDING) {
                height += childHeight + PADDING;
            } else if (width > specWidth) {
                width = lastWidth = PADDING + childWidth + PADDING;
                height += childHeight + PADDING;
            }
            LogUtils.d(TAG, "height = " + height);
        }

        setMeasuredDimension(specWidth, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        LogUtils.d(TAG, "onLayout: width = " + getWidth() + ", height = " + getHeight());
        LogUtils.d(TAG, "onLayout: changed = " + changed + ", l = " + l + ", t = " + t + ", r = " + r + ", b = " + b);

        int viewLeft = PADDING;
        int viewTop = PADDING;
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
