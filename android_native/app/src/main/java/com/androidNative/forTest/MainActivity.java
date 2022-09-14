package com.androidNative.forTest;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v9.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);
        setContentView(R.layout.activity_main);

        // logginBtn이 클릭되면 아래의 메서드가 실행된다.
        Button button = findViewById(R.id.logginBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logCustomEvent();
                EditText userId = findViewById(R.id.userId);
                EditText password = findViewById(R.id.password);
                Log.d("MainActivity", "userId : "+ userId);
                Log.d("MainActivity", "password : "+ password);

                // 아이디, 비밀번호 null일 경우 체크하여 return
                if ( userId.getText().length() < 1 ) {
                    Log.d("MainActivity", "================ userId null");
                    Toast.makeText(MainActivity.this, "아이디를 입력하세요(아무값 입력).", Toast.LENGTH_LONG).show();
                    return;
                }
                if ( password.getText().length() < 1 ){
                    Log.d("MainActivity", "================ password null");
                    Toast.makeText(MainActivity.this, "비밀번호를 입력하세요(아무값 입력).", Toast.LENGTH_LONG).show();
                    return;
                }

                // intent 새로운 activity 연결
                Intent intent = new Intent(MainActivity.this, MainViewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void logCustomEvent() {
        Bundle params = new Bundle();
        String name = "webview_button_clicks";
        // [START custom_event]
        params.putString("android_event_name", name);
        mFirebaseAnalytics.logEvent("is_webview_clicked", params);
        // [END custom_event]
    }
}