package study.study;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sungju on 2017-07-12.
 */

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private EditText editText;
    private Handler handler = new Handler();
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewmain);

        webView = (WebView) findViewById(R.id.webView);
        button = (Button) findViewById(R.id.loadBtn);
        editText = (EditText) findViewById(R.id.urlInput);

  /*      WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebBrowserClient());
        webView.addJavascriptInterface(new JavaSriptMethods(),"sample");
        webView.loadUrl("file:///android_asset/www/sample.html");
*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),editText.getText().toString(),Toast.LENGTH_SHORT).show();
                webView.loadUrl(editText.getText().toString());
            }
        });
    }

    final class JavaSriptMethods {
        JavaSriptMethods() {

        }

        @android.webkit.JavascriptInterface
        public void clickOnFace() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    button.setText("클릭 후 열기");
                    webView.loadUrl("javascript:changeFace()");
                }
            });
        }
    }

    final class WebBrowserClient extends WebChromeClient {
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            result.confirm();
            return true;
        }
    }
}
