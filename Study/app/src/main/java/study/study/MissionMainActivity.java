package study.study;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by sungju on 2017-07-14.
 */

public class MissionMainActivity extends AppCompatActivity {

    Button button;
    Button urlBtn;
    EditText urlInput;
    LinearLayout linearLayout;
    WebView webView;
    boolean isInputBox = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missionmain);

        button = (Button) findViewById(R.id.webBtn);
        linearLayout = (LinearLayout) findViewById(R.id.inputLayout);
        webView = (WebView) findViewById(R.id.missionWebView);
        urlBtn = (Button) findViewById(R.id.moveUrlBtn);
        urlInput = (EditText) findViewById(R.id.urlText);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return true;
            }
        });

        webView.loadUrl("http://www.naver.com");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInputBox) {
                    linearLayout.setVisibility(View.GONE);
                    button.setText("↓");
                    isInputBox = false;
                } else {
                    linearLayout.setVisibility(View.VISIBLE);
                    button.setText("↑");
                    isInputBox = true;
                }
            }
        });

        urlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://" + urlInput.getText().toString();
                urlInput.setText("");
                linearLayout.setVisibility(View.GONE);
                isInputBox = false;
                webView.loadUrl(url);
            }
        });
    }
}
