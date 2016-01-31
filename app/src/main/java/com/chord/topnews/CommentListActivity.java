package com.chord.topnews;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

/**
 * Created by AllanCL on 2016/1/31.
 */
public class CommentListActivity extends ListActivity {

    private static final String TAG = "CommentListActivity";

    private CommentListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);

        mAdapter = new CommentListAdapter(this);
        setListAdapter(mAdapter);
    }

    private void startLoading() {

    }
}
