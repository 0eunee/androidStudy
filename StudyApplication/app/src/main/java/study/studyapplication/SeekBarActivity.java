package study.studyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends AppCompatActivity {
    private int brightness = 100;
    SeekBar seekBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        textView = (TextView) findViewById(R.id.seekTxt);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        Button btn = (Button) findViewById(R.id.seekBtn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                LinearLayout seekBarPanel = (LinearLayout) findViewById(R.id.seekBarpanel);
                seekBarPanel.setVisibility(View.VISIBLE);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setBrightness(i);
                textView.setText("시크바의 값 : " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setBrightness(int value) {
        if (value < 10) {
            value = 10;
        } else if (value >= 100) {
            value = 100;
        }

        brightness = value;

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = (float) value/100;
        getWindow().setAttributes(params);
    }
}
