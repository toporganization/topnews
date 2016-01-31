package com.chord.topnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AllanCL on 2016/1/31.
 */
public class CommentListAdapter extends BaseAdapter {

    private static final String TAG = "CommentListAdapter";

    private Context mContext;

    public CommentListAdapter(Context context) {
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
        ViewCache cache;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.comment_list_item, null);
            cache = new ViewCache(convertView);
            convertView.setTag(cache);
        }

        cache = (ViewCache) convertView.getTag();
        cache.avatarView.setBackgroundResource(R.drawable.facebook);
        cache.usernameView.setText("David Beckham");
        cache.datetimeView.setText("2016-02-08 09:00");
        cache.bodyView.setText("Happy New Year!\n同志们辛苦了!\nGod like!");

        return convertView;
    }

    private class ViewCache {
        public ImageView avatarView;
        public TextView usernameView;
        public TextView datetimeView;
        public ImageView praiseView;
        public TextView bodyView;

        public ViewCache(View view) {
            avatarView = (ImageView) view.findViewById(R.id.img_avatar);
            usernameView = (TextView) view.findViewById(R.id.text_username);
            datetimeView = (TextView) view.findViewById(R.id.text_datetime);
            praiseView = (ImageView) view.findViewById(R.id.img_praise);
            bodyView = (TextView) view.findViewById(R.id.text_body);
        }
    }
}
