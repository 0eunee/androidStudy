package study.rssmissionapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by sungju on 2017-07-31.
 */

public class RSSListAdapter extends BaseAdapter {
    private Context context;
    ArrayList<RSSItem> items = new ArrayList<>();

    public RSSListAdapter(Context mContext) {
        this.context = mContext;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public void addItem(RSSItem item) {
        items.add(item);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        RSSItemView itemView = new RSSItemView(context);
        RSSItem item = items.get(i);
        itemView.setTitle(item.getTitle());
        itemView.setDate(item.getDate());
        itemView.setContent(item.getContent());
        itemView.setImg(item.getIcon());
        return itemView;
    }
}
