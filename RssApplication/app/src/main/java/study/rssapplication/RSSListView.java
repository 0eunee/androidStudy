package study.rssapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by sungju on 2017-07-28.
 */

public class RSSListView extends ListView {

    private RSSListAdapter adapter;

    private OnDataSelectionListener selectionListener;

    public OnDataSelectionListener getSelectionListener() {
        return selectionListener;
    }

    public void setSelectionListener(OnDataSelectionListener selectionListener) {
        this.selectionListener = selectionListener;
    }

    public RSSListView(Context context) {
        super(context);
        init();
    }

    public RSSListView(Context context, AttributeSet set) {
        super(context, set);
        init();
    }

    private void init() {
        setOnItemClickListener(new OnItemClickAdapter());
    }

    class OnItemClickAdapter implements OnItemClickListener {
        public OnItemClickAdapter() {}

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if (selectionListener == null) {
                return;
            }

            int rowIndex = -1;
            int columnIndex = -1;

            selectionListener.onDataSelected(adapterView,view,i,l);
        }
    }
}
