package study.handlerapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RunnableMainActivity extends AppCompatActivity {
    ProgressBar bar;
    TextView textView;
    boolean isRunning = false;

    ProgressRunnable runnable;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = (ProgressBar) findViewById(R.id.progress);
        textView = (TextView) findViewById(R.id.textView);

        runnable = new ProgressRunnable();
        handler = new Handler();
    }

    @Override
    protected void onStart() {
        super.onStart();
        bar.setProgress(0);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20 && isRunning; i++) {
                        Thread.sleep(1000);

                        handler.post(runnable);
                    }
                } catch (Exception e) {
                    Log.e("MainActivity","Exception in processing message.", e);
                }
            }
        });

        isRunning = true;
        thread.start();

    }

    @Override
    protected void onStop() {
        super.onStop();

        isRunning = false;
    }

    public class ProgressRunnable implements Runnable {
        @Override
        public void run() {
            bar.incrementProgressBy(5);

            if (bar.getProgress() == bar.getMax()) {
                textView.setText("done...");
            } else {
                textView.setText("Working ..." + bar.getProgress());
            }
        }
    }
}
