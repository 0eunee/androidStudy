package study.selectorapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;
    Button button;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                name = editText.getText().toString();
                showMessage();
            }
        });

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
        }
    }

    private void showMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage(name + "님 종료하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"예 버튼 누름", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"취소 버튼 누름", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"아니오 버튼 누름", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name",name);
    }

}
