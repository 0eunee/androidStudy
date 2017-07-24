package study.layouttest;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity {
    Intent intent;
    Button button;
    TextView textView;
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmapDrawable;
    private int i = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        intent = getIntent();
        textView = (TextView) findViewById(R.id.imgTxt);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        imageView = (ImageView) findViewById(R.id.imgView);
        button = (Button) findViewById(R.id.imgBtn);

        scrollView.setHorizontalScrollBarEnabled(true);
        textView.setText(intent.getStringExtra("name"));

        Resources res = getResources();
        bitmapDrawable = (BitmapDrawable) res.getDrawable(R.drawable.test);
        int bWidth = bitmapDrawable.getIntrinsicWidth();
        int bHeight = bitmapDrawable.getIntrinsicHeight();

        imageView.setImageDrawable(bitmapDrawable);
        imageView.getLayoutParams().width = bWidth;
        imageView.getLayoutParams().height = bHeight;

        button.setOnClickListener(backEvent);
    }
    Button.OnClickListener backEvent = new View.OnClickListener() {
        public void onClick(View v) {
            int value = 0;
            if (i == 1) {
                value = R.drawable.test2;
                i = 2;
            } else {
                value = R.drawable.test;
                i = 1;
            }
            changImg(value);
        }
    };

    private void changImg(int value) {
        Resources res = getResources();
        bitmapDrawable = (BitmapDrawable) res.getDrawable(value);
        int bWidth = bitmapDrawable.getIntrinsicWidth();
        int bHeight = bitmapDrawable.getIntrinsicHeight();

        imageView.setImageDrawable(bitmapDrawable);
        imageView.getLayoutParams().width = bWidth;
        imageView.getLayoutParams().height = bHeight;

        button.setOnClickListener(backEvent);
    }
}
