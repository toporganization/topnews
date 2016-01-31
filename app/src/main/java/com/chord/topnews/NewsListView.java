package com.chord.topnews;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by AllanCL on 2016/1/26.
 */
public class NewsListView extends ListView implements AdapterView.OnItemClickListener {

    private static final String TAG = "NewsListView";

    private Context mContext;

    public NewsListView(Context context) {
        super(context);

        mContext = context;
        setVerticalScrollBarEnabled(false);
        setAdapter(new NewsListAdapter(context));
        setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(mContext, CommentListActivity.class);
        mContext.startActivity(intent);
    }
}
