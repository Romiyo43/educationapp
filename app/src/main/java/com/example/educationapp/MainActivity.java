package com.example.educationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    TextView appname;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appname = findViewById(R.id.appname);
        lottie = findViewById(R.id.logo);
        appname.animate().translationY(-500).setDuration(2400).setStartDelay(0);
        lottie.animate().translationX(1800).setDuration(1900).setStartDelay(2700);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,school_code.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }
}