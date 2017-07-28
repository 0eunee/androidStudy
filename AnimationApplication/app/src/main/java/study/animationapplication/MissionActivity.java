package study.animationapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
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
    GameController controller = new GameController();
    ImageView player, playerBoom;
    Random r = new Random();
    FrameLayout frameLayout;
    TextView scoreText;
    Handler handler = new Handler();
    Button button;
    LinearLayout linearLayout;
    AnimationDrawable ani;
    boolean running = true;
    int displayW, displayY;
    int score = 0;
    boolean isLife = true;
    List<RainVO> list = new ArrayList<>();
    List<Drawable> aniList = new ArrayList<>();


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
        playerBoom = (ImageView) findViewById(R.id.playerBoom);
        ani = (AnimationDrawable) playerBoom.getDrawable();
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
                float beforePlayerX = player.getX();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_MOVE :

                        if (motionEvent.getRawX() + player.getWidth() >= displayW) {
                            player.setX(displayW - player.getWidth());
                            break;
                        }
                        player.setX(motionEvent.getRawX());

                        if(beforePlayerX < player.getX()) {
                            player.setImageResource(R.drawable.playerright);
                        } else if (beforePlayerX > player.getX()) {
                            player.setImageResource(R.drawable.playerleft);
                        }
                        //player.setY(motionEvent.getRawY());
                        break;
                    case MotionEvent.ACTION_UP : player.setImageResource(R.drawable.player); break;
                }

                return true;
            }
        });
    }

    private void init(String state) {
        if (state.equals("notStart")) {
            Resources res = getResources();
            scoreText.setVisibility(View.GONE);
            player.setVisibility(View.GONE);
            aniList.add(res.getDrawable(R.drawable.boom1));
            aniList.add(res.getDrawable(R.drawable.boom2));
            aniList.add(res.getDrawable(R.drawable.boom3));
            aniList.add(res.getDrawable(R.drawable.boom4));
            aniList.add(res.getDrawable(R.drawable.boom5));
            aniList.add(res.getDrawable(R.drawable.boom6));
            aniList.add(res.getDrawable(R.drawable.boom7));
            aniList.add(res.getDrawable(R.drawable.boom8));
            aniList.add(res.getDrawable(R.drawable.boom9));
            aniList.add(res.getDrawable(R.drawable.boom10));
            aniList.add(res.getDrawable(R.drawable.boom11));
            aniList.add(res.getDrawable(R.drawable.boom12));
            aniList.add(res.getDrawable(R.drawable.boom13));
            aniList.add(res.getDrawable(R.drawable.boom14));
            aniList.add(res.getDrawable(R.drawable.boom15));
            aniList.add(res.getDrawable(R.drawable.boom16));
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
        for (int i = 0; i < 8; i++) {
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
    int cnt = 0;
    class aniEvent extends Thread {
        @Override
        public void run() {
            for(int i = 0; i < aniList.size(); i++) {
                final Drawable drawable = aniList.get(i);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        playerBoom.setImageDrawable(drawable);
                    }
                });
                try {
                    Thread.sleep(70);
                } catch (Exception e) {

                }
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    playerBoom.setVisibility(View.GONE);
                }
            });

        }
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
                            if (controller.collisionCheck(player, rv.getImageView()) && isLife == true) {
                                isLife = false;
                                playerBoom.setX(player.getX());
                                player.setVisibility(View.GONE);
                                playerBoom.setVisibility(View.VISIBLE);
                                //boomAnimation();
                                Thread ani = new aniEvent();
                                ani.start();
                            }

                            if (isLife == false) {
                                rv.getImageView().setVisibility(View.GONE);
                                running = false;
                            }

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
