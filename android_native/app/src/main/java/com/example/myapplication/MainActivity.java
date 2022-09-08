package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
//import android.support.v9.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // logginBtn이 클릭되면 아래의 메서드가 실행된다.
        Button button = findViewById(R.id.logginBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userId = findViewById(R.id.userId);
                EditText password = findViewById(R.id.password);
                Log.d("MainActivity", "userId : "+ userId);
                Log.d("MainActivity", "password : "+ password);

                // 아이디, 비밀번호 null일 경우 체크하여 return
                if ( userId.getText().length() < 1 ) {
                    Log.d("MainActivity", "================ userId null");
                    Toast.makeText(MainActivity.this, "아이디를 입력하세요.", Toast.LENGTH_LONG).show();
                    return;
                }
                if ( password.getText().length() < 1 ){
                    Log.d("MainActivity", "================ password null");
                    Toast.makeText(MainActivity.this, "비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
                    return;
                }

                // intent 새로운 activity 연결
                Intent intent = new Intent(MainActivity.this, MainViewActivity.class);
                startActivity(intent);
            }
        });
    }
}