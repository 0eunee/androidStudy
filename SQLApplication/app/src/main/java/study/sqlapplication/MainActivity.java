package study.sqlapplication;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String dbName, tableName;
    EditText createDB, createTable;
    Button DBBtn, tableBtn;
    TextView textView;
    SQLiteDatabase db;
    boolean databaseCreated = false;
    boolean tableCreated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDB = (EditText) findViewById(R.id.createDB);
        DBBtn =(Button) findViewById(R.id.createDBBtn);
        createTable = (EditText) findViewById(R.id.createTable);
        tableBtn = (Button) findViewById(R.id.createTableBtn);
        textView = (TextView) findViewById(R.id.stateTxt);

        DBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbName = createDB.getText().toString();
                createDB(dbName);
            }
        });

        tableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableName = createTable.getText().toString();
                createTable(tableName);
            }
        });
    }

    public void createDB(String dbName) {

        db = openOrCreateDatabase(dbName, Activity.MODE_PRIVATE,null);

        databaseCreated = true;

        Log.d("MainActivity","db생성 : " + dbName);
    }

    public void createTable(String tableName) {
        db.execSQL("create table if not exists " + tableName + "("
                + " _id integer PRIMARY KEY autoincrement, "
                + " name text, "
                + " age integer, "
                + " phone text);" );

        Log.d("MainActivity","table 생성 : " + tableName);
    }
}
