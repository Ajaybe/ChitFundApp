package com.example.cmfs1.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.cmfs1.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //noinspection deprecation
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = (new Intent(getApplicationContext(), Login.class));
                startActivity(intent);
                finish();
            }
        },2000);
    }
}