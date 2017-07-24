package study.handlerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean running = false;
    int value = 0;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.showBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("스레드에서 받은 값 : " + value);
            }
        });
    }

    protected void onResume() {
        super.onResume();

        running = true;

        Thread thread = new BackgroundThread();
        thread.start();
    }

    protected void onPause() {
        super.onPause();

        running = false;
        value = 0;
    }

    class BackgroundThread extends Thread {
        public void run() {
            while(running) {
                try {
                    Thread.sleep(1000);
                    value++;
                } catch (InterruptedException e) {
                    Log.e("SampleJavaThread","Exception in thread" + e);
                }
            }
        }
    }
}
