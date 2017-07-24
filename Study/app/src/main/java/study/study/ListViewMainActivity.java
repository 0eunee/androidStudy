package study.study;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sungju on 2017-07-19.
 */

public class ListViewMainActivity extends AppCompatActivity {
    EditText editText;
    ListView listView;
    SingerAdapter adapter;
    LinearLayout linearLayout;
    InputMethodManager imm;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewmain);
        editText = (EditText) findViewById(R.id.listViewEditText);
        linearLayout = (LinearLayout) findViewById(R.id.listViewLayout);
        listView = (ListView) findViewById(R.id.listViewList);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        button = (Button) findViewById(R.id.listViewBtn);

        adapter = new SingerAdapter();

        adapter.addItem(new SingerItem("에이","010-1000-1111",30,R.drawable.singer));
        adapter.addItem(new SingerItem("비","010-1000-1111",25,R.drawable.singer2));
        adapter.addItem(new SingerItem("씨","010-1000-1111",28,R.drawable.singer3));
        adapter.addItem(new SingerItem("디","010-1000-1111",23,R.drawable.singer4));
        adapter.addItem(new SingerItem("이","010-1000-1111",22,R.drawable.singer5));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                hideKeyboard();
                SingerItem item = (SingerItem) adapter.getItem(i);
                Toast.makeText(getApplicationContext(),"선택 : " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });


        linearLayout.setOnClickListener(clickEvent);
        button.setOnClickListener(clickEvent);
    }

    View.OnClickListener clickEvent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            hideKeyboard();
        }
    };

    private void hideKeyboard() {
        imm.hideSoftInputFromWindow(editText.getWindowToken(),0);
    }

    @Override
    protected void onResume() {
        super.onResume();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            SingerItemView view = new SingerItemView(getApplicationContext());
            SingerItem item = items.get(i);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setAge(item.getAge());
            view.setImg(item.getResId());

            return view;
        }
    }

}
