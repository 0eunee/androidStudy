package study.fragmentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    MenuFragment menuFragment;
    String msg = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);

        menuFragment = new MenuFragment();
    }

    public  void onFragmentChanged(int i, String msg) {
        if (i == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,menuFragment).commit();
        } else if (i == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();
        }
    }
}
