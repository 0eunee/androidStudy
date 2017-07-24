package study.study;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by sungju on 2017-07-25.
 */

public class GridViewMainActivity extends AppCompatActivity {
    GridAdaptor adaptor;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridviewmain);
        gridView = (GridView) findViewById(R.id.gridViewList);

        adaptor = new GridAdaptor();
        adaptor.addItem(new SingerItem("가","010 0100 0100",15,R.drawable.singer));
        adaptor.addItem(new SingerItem("나","010 0100 0100",15,R.drawable.singer5));
        adaptor.addItem(new SingerItem("다","010 0100 0100",15,R.drawable.singer2));
        adaptor.addItem(new SingerItem("라","010 0100 0100",15,R.drawable.singer3));
        adaptor.addItem(new SingerItem("마","010 0100 0100",15,R.drawable.singer4));

        gridView.setAdapter(adaptor);
    }

    class GridAdaptor extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();
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

        public void addItem(SingerItem item) {items.add(item);}

        @Override
        public View getView(int i, View contentView, ViewGroup viewGroup) {
            GridViewItemView view = new GridViewItemView(getApplicationContext());
            SingerItem item = items.get(i);
            view.setName(item.getName());
            view.setPhone(item.getMobile());
            view.setAge(item.getAge());
            view.setImg(item.getResId());
            return view;
        }
    }
}
