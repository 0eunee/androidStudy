package study.rssapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungju on 2017-07-28.
 */

public class RSSListAdapter extends BaseAdapter {
    private Context mContext;

    private List<RSSNewsItem> mItems = new ArrayList<>();

    public RSSListAdapter(Context context) {
        mContext = context;
    }

    public void addItem(RSSNewsItem item) {
        mItems.add(item);
    }

    public void setListItems(List<RSSNewsItem> lit) {
        mItems = lit;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public boolean areAllItemsSelectable() {
        return false;
    }

    public boolean isSelectable(int position) {
        return true;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        RSSNewsItemView itemView;
        if (view == null) {
            itemView = new RSSNewsItemView(mContext, mItems.get(i));
        } else {
            itemView = (RSSNewsItemView) view;
            RSSNewsItem ri = mItems.get(i);
            itemView.setIcon(ri.getmIcon());
            itemView.setText(0, ri.getTitle());
            itemView.setText(1, ri.getPubDate());
            itemView.setText(2, ri.getCategory());
            itemView.setText(3, ri.getDescription());
        }
        return itemView;
    }
}
