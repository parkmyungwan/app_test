package co.weirdsector.androidnativefirebasetest;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView wb = findViewById(R.id.webView);
        wb.getSettings().setSupportMultipleWindows(false);
        wb.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
        wb.loadUrl("http://mywanpark.dothome.co.kr/");

    }
}