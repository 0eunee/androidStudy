# 웹뷰

## 1. 웹뷰

- 웹뷰를 사용하려면 `AndroidManifest.xml`에 퍼미션을 설정해줘야 사용할 수 있음
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## 2. 웹뷰 사용

- 사용하려는 액티비티 레이아웃에 WebView 설정
```xml
<WebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

- 액티비티.java 에서 웹뷰 객체 참조
```java
webView = (WebView) findViewById(R.id.webView);
```

- 웹뷰에 웹셋팅 설정
```java
WebSettings webSettings = webView.getSettings();
webSettings.setJavaScriptEnabled(true);
```

- 웹뷰에 클라이언트 객체 지정
```java
webView.setWebChromeClient(new WebBrowserClient());
webView.addJavascriptInterface(new JavaSriptMethods(),"sample");
```
- WebBrowserClient
```java
final class WebBrowserClient extends WebChromeClient {
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            result.confirm();
            return true;
        }
}
```

-JavaSriptMethods
```java
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
```

- 웹뷰에 페이지 로딩
```java
webView.loadUrl("file:///android_asset/www/sample.html");
```
