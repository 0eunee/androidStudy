package study.test;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 /*       LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );

        Button btn = new Button(this);
        btn.setText("Button01");
        btn.setLayoutParams(params);
        mainLayout.addView(btn);
        setContentView(mainLayout);*/
    }

    public void test(View v) {
        Toast.makeText(getApplicationContext(),"안녕",Toast.LENGTH_LONG).show();
    }

    public void internetBtn(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }

    public void menuBtn(View v) {
        Intent myIntent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(myIntent);
    }
}
