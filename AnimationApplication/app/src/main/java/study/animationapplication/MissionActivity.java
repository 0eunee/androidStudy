package study.animationapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by sungju on 2017-07-26.
 */

public class MissionActivity extends AppCompatActivity {
    Animation shakeAnimation, flowAnimation, dropAnimation;
    ImageView skyImg, swingImg, waterImg;
    Random r = new Random();
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int count = r.nextInt(10);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

        skyImg = (ImageView) findViewById(R.id.skyImage);
        swingImg = (ImageView) findViewById(R.id.swingImage);
        waterImg = (ImageView) findViewById(R.id.waterImg);
        shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        flowAnimation = AnimationUtils.loadAnimation(this, R.anim.flow);
        dropAnimation = AnimationUtils.loadAnimation(this, R.anim.drop);
        skyImg.setAnimation(flowAnimation);
        swingImg.setAnimation(shakeAnimation);
        waterImg.setAnimation(dropAnimation);

        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(this);
            Animation dropAni = AnimationUtils.loadAnimation(this, R.anim.drop);
            Log.d("빗방울 : ",String.valueOf(i));
            imageView.setId(R.id.waterImg + i);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setBackgroundResource(R.drawable.waterdrop);
            frameLayout.addView(imageView);
            imageView.setX(i * 60);
            dropAni.setDuration(i * 500);
            imageView.setAnimation(dropAni);
        }

        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res,R.drawable.sky_background);

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        ViewGroup.LayoutParams params = skyImg.getLayoutParams();

        params.width = w;
        params.height = h;

        skyImg.setImageBitmap(bitmap);

        flowAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Toast.makeText(getApplicationContext(),"onWindowFocusChanged : " + hasFocus,Toast.LENGTH_SHORT).show();

        if(hasFocus) {
            shakeAnimation.start();
            flowAnimation.start();
            dropAnimation.start();
        } else {
            shakeAnimation.reset();
            flowAnimation.reset();
            dropAnimation.reset();
        }

    }
}
