package study.layouttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TableLayout extends AppCompatActivity {
    EditText et;
    Button btn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        et = (EditText) findViewById(R.id.name);
        btn = (Button) findViewById(R.id.yesBtn);
        btn.setOnClickListener(btnClick);
    }

    Button.OnClickListener btnClick = new View.OnClickListener() {
        public void  onClick(View v) {
            String text = et.getText().toString();
            if (text.equals("")) {
                Toast.makeText(getApplicationContext(),"이름 입력해라",Toast.LENGTH_LONG).show();
            } else {
                intent = new Intent(getApplicationContext(),ImageActivity.class);
                intent.putExtra("name",text);
                startActivity(intent);
            }
            System.out.println(et.getText());
        }
    };

}
