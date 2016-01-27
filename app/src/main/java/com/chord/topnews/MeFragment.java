package com.chord.topnews;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chord.topnews.utils.LogUtils;

/**
 * Created by AllanCL on 2016/1/25.
 */
public class MeFragment extends Fragment {

    private static final String TAG = "MeFragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtils.d(TAG, "onAttach");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtils.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_me, null);
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
}
