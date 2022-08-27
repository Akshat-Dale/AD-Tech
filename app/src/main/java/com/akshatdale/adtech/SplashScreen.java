package com.akshatdale.adtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

//    TextView textViewAD;
    ImageView imageViewlogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        textViewAD = findViewById(R.id.textViewAD);
//        textViewAD.setAlpha(0);

        imageViewlogo = findViewById(R.id.imageViewlogo);
        imageViewlogo.setAlpha(0f);


        Intent intent = new Intent(SplashScreen.this, MainLoginActivity.class);


//        textViewAD.animate().alpha(1).setDuration(3000);
        imageViewlogo.animate().alpha(1).setDuration(3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },4000);

    }
}