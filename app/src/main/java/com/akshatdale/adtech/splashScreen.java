package com.akshatdale.adtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class splashScreen extends AppCompatActivity {

    TextView textViewAD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textViewAD = findViewById(R.id.textViewAD);
        textViewAD.setAlpha(0);

        Intent intent = new Intent(splashScreen.this,MainActivity.class);


        textViewAD.animate().alpha(1).setDuration(3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },4000);

    }
}