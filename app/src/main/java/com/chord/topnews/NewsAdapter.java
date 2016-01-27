package com.chord.topnews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by AllanCL on 2016/1/25.
 */
public class NewsAdapter extends BaseAdapter {

    private Context mContext;

    public NewsAdapter(Context context) {
        super();
        mContext = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(mContext);
        textView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 200));
        textView.setText("News-" + position);
        return textView;
    }
}
