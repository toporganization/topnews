package com.chord.topnews.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;

import com.chord.topnews.R;

/**
 * Created by AllanCL on 2016/1/27.
 */
public class CategoryPicker extends PopupWindow {

    private static final String TAG = "CategoryPicker";

    private CategoriesContainer mCategoriesContainer;

    public CategoryPicker(Context context) {
        super(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View contentView = inflater.inflate(R.layout.category_picker, null);
        setContentView(contentView);
        setWidth(LayoutParams.MATCH_PARENT);
        setHeight(LayoutParams.MATCH_PARENT);
        setOutsideTouchable(true);

        mCategoriesContainer = (CategoriesContainer) contentView.findViewById(R.id.categories_container);
        mCategoriesContainer.addCategory("Sports");
        mCategoriesContainer.addCategory("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        mCategoriesContainer.addCategory("HAHAHAHHAHAHAHAHAHHAHHHAHAHAHAHAHHA");
        mCategoriesContainer.addCategory("Wuhan University");
        mCategoriesContainer.addCategory("通信工程");
    }
}
