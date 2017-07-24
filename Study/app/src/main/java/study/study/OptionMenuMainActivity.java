package study.study;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by sungju on 2017-07-12.
 */

public class OptionMenuMainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optiionmain);
    }
}
