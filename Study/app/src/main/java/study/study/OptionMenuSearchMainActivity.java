package study.study;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sungju on 2017-07-12.
 */

public class OptionMenuSearchMainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu_main, menu);

        View v = menu.findItem(R.id.searchmenu_search).getActionView();

        if (v != null) {
            editText = (EditText) v.findViewById(R.id.searchEditText);

            if (editText != null) {
                editText.setOnEditorActionListener(onSearchListener);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();

        switch (curId) {
            case R.id.menu_refresh :
                Toast.makeText(getApplicationContext(),"새로고침 선택",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_search :
                Toast.makeText(getApplicationContext(),"검색 선택",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_settings :
                Toast.makeText(getApplicationContext(),"설정 선택",Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private TextView.OnEditorActionListener onSearchListener = new TextView.OnEditorActionListener() {
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
          if (event == null || event.getAction() == KeyEvent.ACTION_UP) {
              search();

              InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
              manager.hideSoftInputFromWindow(v.getWindowToken(), 0);
          }
          return (true);
      }
    };

    public void search() {
        String text = editText.getEditableText().toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optiionmain);
    }
}
