package study.aniapplication;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Button startBtn;
    Button stopBtn;
    ImageSwitcher switcher;
    Thread thread;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        switcher = (ImageSwitcher) findViewById(R.id.switcher);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setBackgroundColor(0xFF000000);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAnimation();
            }
        });
    }

    private void startAnimation() {
        switcher.setVisibility(View.VISIBLE);

        thread = new ImageThread();
        thread.start();
    }

    private void stopAnimation() {
        running = false;
        try {
            thread.join();
        } catch (Exception e) {}

        switcher.setVisibility(View.INVISIBLE);
    }

    class ImageThread extends Thread {
        int duration = 250;
        final int imageId[] = {R.drawable.emo_im_crying, R.drawable.emo_im_happy, R.drawable.emo_im_laughing, R.drawable.emo_im_sad, R.drawable.emo_im_surprised};
        int index = 0;
        @Override
        public void run() {
            running = true;
            while(running) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        switcher.setImageResource(imageId[index]);
                    }
                });

                index++;

                if (index == imageId.length) {
                    index = 0;
                }

                try {
                    Thread.sleep(duration);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
