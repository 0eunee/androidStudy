package study.studyapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgress(80);

        Button btn = (Button) findViewById(R.id.btn);
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("데이터 확인 중");

                dialog.show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(dialog != null) {
                    dialog.dismiss();
                }
            }
        });
    }
}
