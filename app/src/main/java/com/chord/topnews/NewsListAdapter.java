package com.chord.topnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by AllanCL on 2016/1/25.
 */
public class NewsListAdapter extends BaseAdapter {

    private static final String TAG = "NewsListAdapter";

    private Context mContext;

    private LayoutInflater mInflater;

    public NewsListAdapter(Context context) {
        super();
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
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
        switch (getItemViewType(position)) {
            case News.TYPE_HEADLINE:
                return getHeadlineNewsView(position, convertView, parent);
            case News.TYPE_PICTURE:
                return getPictureNewsView(position, convertView, parent);
            case News.TYPE_GENERAL:
            default:
                return getGeneralNewsView(position, convertView, parent);
        }
    }

    @Override
    public int getViewTypeCount() {
        return News.TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return News.TYPE_HEADLINE;
        }
        if (position == 3) {
            return News.TYPE_PICTURE;
        }
        return News.TYPE_GENERAL;
    }

    private View getHeadlineNewsView(int position, View convertView, ViewGroup parent) {
        ViewCache cache;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.headline_news, null);
            cache = new ViewCache(News.TYPE_HEADLINE, convertView);
            convertView.setTag(cache);
        }
        cache = (ViewCache) convertView.getTag();
        cache.pictureView.setBackgroundResource(R.drawable.headline_picture);
        cache.titleView.setText("Anne Hathaway");
        return convertView;
    }

    private View getGeneralNewsView(int position, View convertView, ViewGroup parent) {
        ViewCache cache;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.general_news, null);
            cache = new ViewCache(News.TYPE_GENERAL, convertView);
            convertView.setTag(cache);
        }
        cache = (ViewCache) convertView.getTag();
        cache.pictureView.setBackgroundResource(R.drawable.headline_picture);
        cache.titleView.setText("What bad weather");
        cache.summaryView.setText("The bad weather has been fairly general(= has affected most areas).");
        cache.commentCountView.setText("388 comments");
        return convertView;
    }

    private View getPictureNewsView(int position, View convertView, ViewGroup parent) {
        ViewCache cache;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.picture_news, null);
            cache = new ViewCache(News.TYPE_PICTURE, convertView);
            convertView.setTag(cache);
        }
        cache = (ViewCache) convertView.getTag();
        cache.pictureView.setBackgroundResource(R.drawable.headline_picture);
        cache.pictureView2.setBackgroundResource(R.drawable.headline_picture2);
        cache.pictureView3.setBackgroundResource(R.drawable.headline_picture);
        cache.titleView.setText("Anne Hathaway");
        cache.commentCountView.setText("1314 comments");
        return convertView;
    }

    private class ViewCache {
        public ImageView pictureView;
        public TextView titleView;
        public ImageView pictureView2;
        public ImageView pictureView3;
        public TextView commentCountView;
        public TextView summaryView;

        public ViewCache(int type, View view) {
            titleView = (TextView) view.findViewById(R.id.text_title);
            pictureView = (ImageView) view.findViewById(R.id.img_picture);
            switch (type) {
                case News.TYPE_HEADLINE:
                    break;
                case News.TYPE_GENERAL:
                    summaryView = (TextView) view.findViewById(R.id.text_summary);
                    commentCountView = (TextView) view.findViewById(R.id.text_comment_count);
                    break;
                case News.TYPE_PICTURE:
                    pictureView2 = (ImageView) view.findViewById(R.id.img_picture_2);
                    pictureView3 = (ImageView) view.findViewById(R.id.img_picture_3);
                    commentCountView = (TextView) view.findViewById(R.id.text_comment_count);
                    break;
                default:
            }
        }
    }
}
