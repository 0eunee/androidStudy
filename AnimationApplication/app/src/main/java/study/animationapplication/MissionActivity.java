package study.animationapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sungju on 2017-07-26.
 */

public class MissionActivity extends AppCompatActivity {
    ImageView player;
    Random r = new Random();
    FrameLayout frameLayout;
    TextView scoreText;
    Handler handler = new Handler();
    Button button;
    LinearLayout linearLayout;
    boolean running = true;
    int displayW, displayY;
    int score = 0;
    List<RainVO> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        displayW = point.x;
        displayY = point.y;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missionmain);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        linearLayout = (LinearLayout) findViewById(R.id.startLayout);
        button = (Button) findViewById(R.id.startBtn);
        scoreText = (TextView) findViewById(R.id.score);
        player = (ImageView) findViewById(R.id.player);

        init("notStart");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init("start");
            }
        });


        player.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_MOVE :
                        player.setX(motionEvent.getRawX());
                        //player.setY(motionEvent.getRawY());
                        break;
                }

                return true;
            }
        });
    }

    private void init(String state) {
        if (state.equals("notStart")) {
            scoreText.setVisibility(View.GONE);
            player.setVisibility(View.GONE);
        } else if (state.equals("start")) {
            linearLayout.setVisibility(View.GONE);
            scoreText.setVisibility(View.VISIBLE);
            player.setVisibility(View.VISIBLE);
            gameInit();
            Thread move = new moveEvent();
            move.start();
        }
    }

    private void gameInit() {
        for (int i = 0; i < 10; i++) {
            RainVO rv = new RainVO();
            ImageView imageView = new ImageView(this);
            imageView.setId(R.id.waterImg + i);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setBackgroundResource(R.drawable.waterdrop);
            //frameLayout.addView(imageView);
            //imageView.setX(i * 60);
            rv.setImageView(imageView);
            rv.setSpeed(setSpeed());
            list.add(rv);
        }
        scoreText.setText("점수 : " + score);
    }

    private int setSpeed() {
        Random r = new Random();
        return r.nextInt(5) + 1;
    }

    class moveEvent extends Thread {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < list.size(); i++) {
                        RainVO rv = list.get(i);
                        rv.getImageView().setX((i + 1) * 80);
                        frameLayout.addView(rv.getImageView());
                    }
                }
            });
            while(running) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < list.size(); i++) {
                            RainVO rv = list.get(i);
                            rv.getImageView().setY(rv.getImageView().getY() + rv.getSpeed() + 1);

                            if (rv.getImageView().getY() > displayY) {
                                score++;
                                Random r = new Random();
                                int rX = r.nextInt(displayW) + 1;
                                rv.getImageView().setX(rX);
                                rv.getImageView().setY(0);
                                rv.setSpeed(setSpeed());
                                scoreText.setText("점수 : " + score);
                            }
                        }
                    }
                });
            }
        }
    }
}
