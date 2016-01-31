package com.chord.topnews;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;

import com.chord.topnews.utils.LogUtils;

/**
 * Created by AllanCL on 2016/1/25.
 */
public class MainActivity extends FragmentActivity {

    private static final String TAG = "MainActivity";

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createViewsAndFragments();
    }

    private void createViewsAndFragments() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("news")
                .setIndicator(getString(R.string.news), getResources().getDrawable(R.drawable.tab_news)),
                NewsFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("stories")
                .setIndicator(getString(R.string.stories), getResources().getDrawable(R.drawable.tab_stories)),
                StoriesFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("me")
                .setIndicator(getString(R.string.me), getResources().getDrawable(R.drawable.tab_me)),
                MeFragment.class, null);
    }
}
