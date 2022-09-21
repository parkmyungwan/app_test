package co.weirdsector.androidnativefirebasetest;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView wb = findViewById(R.id.webView);
        wb.getSettings().setSupportMultipleWindows(true);
        wb.setWebChromeClient(new WebChromeClient());
        wb.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
        wb.getSettings().setJavaScriptEnabled(true);
        wb.loadUrl("http://mywanpark.dothome.co.kr/");

    }
}