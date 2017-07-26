package study.animationapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Animation shakeAnimation, flowAnimation, dropAnimation;
    ImageView skyImg, swingImg, waterImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skyImg = (ImageView) findViewById(R.id.skyImage);
        swingImg = (ImageView) findViewById(R.id.swingImage);
        waterImg = (ImageView) findViewById(R.id.waterImg);
        shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        flowAnimation = AnimationUtils.loadAnimation(this, R.anim.flow);
        dropAnimation = AnimationUtils.loadAnimation(this, R.anim.drop);
        skyImg.setAnimation(flowAnimation);
        swingImg.setAnimation(shakeAnimation);
        waterImg.setAnimation(dropAnimation);

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
