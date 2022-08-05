package com.akshatdale.adtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class signUpActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
         intent = new Intent(signUpActivity.this,MainActivity.class);
    }

    public void alreadyUserLogin(View view) {
        startActivity(intent);
    }

    public void successfulSignUp(View view) {
        Toast.makeText(getApplicationContext(), "Sign up successful !", Toast.LENGTH_SHORT).show();
    }
}