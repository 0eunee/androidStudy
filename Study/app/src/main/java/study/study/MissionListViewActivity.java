package study.study;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by sungju on 2017-07-24.
 */

public class MissionListViewActivity extends AppCompatActivity {
    ListView listView;
    CustomerAdaptor adaptor;
    Button btn;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missionlistviewmain);
        listView = (ListView) findViewById(R.id.missionList);
        btn = (Button) findViewById(R.id.missionListBtn);
        text = (EditText) findViewById(R.id.missionListEditText);

        adaptor = new CustomerAdaptor();

        adaptor.addItem(new MissionListItem("a","r",1,R.drawable.singer));
        adaptor.addItem(new MissionListItem("b","r",1,R.drawable.singer));
        adaptor.addItem(new MissionListItem("c","r",1,R.drawable.singer));
        adaptor.addItem(new MissionListItem("ab","r",1,R.drawable.singer));
        adaptor.addItem(new MissionListItem("abc","r",1,R.drawable.singer));

        listView.setAdapter(adaptor);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adaptor.searchKeyword(text.getText().toString());
                text.setText("");
                listView.setAdapter(adaptor);
            }
        });
}

    class CustomerAdaptor extends BaseAdapter {
        ArrayList<MissionListItem> items = new ArrayList<MissionListItem>();
        ArrayList<MissionListItem> list = new ArrayList<MissionListItem>();
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

        public void addItem(MissionListItem item) {
            items.add(item);
            list.add(item);
        }

        public void init() {
            items.removeAll(list);
            items.addAll(list);
        }

        public void searchKeyword(String keyWord) {
            ArrayList<MissionListItem> resultItem = new ArrayList<>();
            init();
            if (keyWord == null || keyWord.equals("")) {

            } else {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    int index = items.get(i).getName().indexOf(keyWord);

                    if (index == -1) {
                        resultItem.add(items.get(i));
                    }
                }
                items.removeAll(resultItem);
            }
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            MissionListView listView = new MissionListView(getApplicationContext());
            MissionListItem ml = items.get(i);
            listView.setName(ml.getName());
            listView.setPhone(ml.getPhone());
            listView.setImg(ml.getResId());
            listView.setAge(ml.getAge());
            return listView;
        }
    }
}
