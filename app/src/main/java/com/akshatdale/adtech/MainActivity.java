package com.akshatdale.adtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewNewUser;
    Intent intentSignup;
    Intent  intentForgotPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNewUser = findViewById(R.id.textViewNewUser);
        intentSignup = new Intent(MainActivity.this,signUpActivity.class);
        intentForgotPassword = new Intent(MainActivity.this,forgotPasswordActivity.class);

    }

    public void signUp(View view) {
        startActivity(intentSignup);
  }

    public void login(View view) {
        Toast.makeText(getApplicationContext(), "Successfuly login", Toast.LENGTH_SHORT).show();
    }

    public void forgotPassword(View view) {
        startActivity(intentForgotPassword);
    }




}