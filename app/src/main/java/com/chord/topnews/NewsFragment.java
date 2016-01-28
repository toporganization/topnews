package com.chord.topnews;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chord.topnews.utils.LogUtils;
import com.chord.topnews.widget.CategoriesContainer;
import com.chord.topnews.widget.CategoryPicker;
import com.chord.topnews.widget.CategoryView;

import java.util.ArrayList;

/**
 * Created by AllanCL on 2016/1/22.
 */
public class NewsFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "NewsFragment";

    private LinearLayout mCategoriesBar;

    private ImageView mBtnAdd;

    private ViewPager mViewPager;

    private ViewPagerAdapter mViewPagerAdapter;

    private LinearLayout mCategoryPickerLayout;

    private TextView mBtnDone;

    private CategoriesContainer mCategoriesContainer;

    private View mTransparentView;

    private CategoryPicker mCategoryPicker;

    private ArrayList<NewsListView> mPageList = new ArrayList<NewsListView>();

    private String[] mCategories = {
            "Top News", "Cricket", "Economics", "Entertainment", "Technology", "Shen Zhen", "Premier League"
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        LogUtils.d(TAG, "onAttach");
        mPageList.add(new NewsListView(getContext()));
        mPageList.add(new NewsListView(getContext()));
        mPageList.add(new NewsListView(getContext()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtils.d(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_news, null);

        mCategoriesBar = (LinearLayout) rootView.findViewById(R.id.categories_bar);

        for (String category : mCategories) {
            CategoryView categoryView = new CategoryView(getContext());
            categoryView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            categoryView.setText(category);
            mCategoriesBar.addView(categoryView);
        }

        mBtnAdd = (ImageView) rootView.findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(this);

        mViewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
        mViewPagerAdapter = new ViewPagerAdapter();
        mViewPager.setAdapter(mViewPagerAdapter);

        mCategoryPickerLayout = (LinearLayout) rootView.findViewById(R.id.category_picker_layout);
        mCategoryPickerLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        mBtnDone = (TextView) rootView.findViewById(R.id.btn_done);
        mBtnDone.setOnClickListener(this);
        mCategoriesContainer = (CategoriesContainer) rootView.findViewById(R.id.categories_container);
        mCategoriesContainer.addCategory("Sports");
        mCategoriesContainer.addCategory("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        mCategoriesContainer.addCategory("HAHAHAHHAHAHAHAHAHHAHHHAHAHAHAHAHHA");
        mCategoriesContainer.addCategory("Wuhan University");
        mCategoriesContainer.addCategory("通信工程");
        mTransparentView = rootView.findViewById(R.id.transparent_view);
        mTransparentView.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.d(TAG, "onPause");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                //showCategoryPicker();
                showCategoryPickerLayout();
                break;
            case R.id.btn_done:
                hideCategoryPickerLayout();
                break;
            case R.id.transparent_view:
                hideCategoryPickerLayout();
                break;
        }
    }

    private void showCategoryPicker() {
        LogUtils.d(TAG, "showCategoryPicker");
        if (mCategoryPicker == null) {
            mCategoryPicker = new CategoryPicker(getContext());
        }
        mCategoryPicker.showAtLocation(mCategoriesBar, Gravity.TOP, 0, 72);
    }

    private void showCategoryPickerLayout() {
        LogUtils.d(TAG, "showCategoryPickerLayout");
        mCategoryPickerLayout.setVisibility(View.VISIBLE);
    }

    private void hideCategoryPickerLayout() {
        LogUtils.d(TAG, "hideCategoryPickerLayout");
        mCategoryPickerLayout.setVisibility(View.GONE);
    }

    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mPageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mPageList.get(position));
            return mPageList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mPageList.get(position));
        }
    }
}
