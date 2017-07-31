package study.rssapplication;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by sungju on 2017-07-28.
 */

public interface OnDataSelectionListener {

    public void onDataSelected(AdapterView parent, View v, int position, long id);
}
