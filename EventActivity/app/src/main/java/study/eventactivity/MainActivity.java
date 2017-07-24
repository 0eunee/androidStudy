package study.eventactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detector = new GestureDetector(this, gestureListener);
        textView = (TextView) findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        View view = findViewById(R.id.view1);
        View view2 = findViewById(R.id.view2);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if (action == motionEvent.ACTION_DOWN) {
                    println("눌림 이벤트 : " + curX + "," + curY);
                } else if (action == motionEvent.ACTION_MOVE) {
                    println("움직임 이벤트 : " + curX + "," + curY);
                } else if (action == motionEvent.ACTION_UP) {
                    println("손가락 땜 : " + curX + "," + curY);
                }

                return true;
            }
        });

        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return false;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(getApplicationContext(),"물리 back 눌림", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    GestureDetector.OnGestureListener gestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent motionEvent) {
            println("onDown 호출");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            println("onShowPress 호출");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            println("onSingleTapUp 호출");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            println("onScroll 호출");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            println("onLongPress 호출");
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            println("onFling 호출 : " + v + "," + v1);
            return true;
        }
    };

    public void println(String data) {
        textView.append(data + "\n");
    }
}
