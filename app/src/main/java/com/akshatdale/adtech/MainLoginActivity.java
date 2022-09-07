package com.akshatdale.adtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainLoginActivity extends AppCompatActivity {

    TextView textViewNewUser;
   EditText editTextLoginEmail,editTextLoginPassword;
   Button buttonLogin;
    DatabaseHelper databaseHelper;
    UserDetails userDetails;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        textViewNewUser = findViewById(R.id.textViewNewUser);
        editTextLoginEmail = findViewById(R.id.editTextLoginEmail);
        editTextLoginPassword = findViewById(R.id.editTextLoginPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        databaseHelper = new DatabaseHelper(this);
        userDetails = new UserDetails();


    }

    public void signUpText(View view) {
        Intent intentSignup = new Intent(MainLoginActivity.this, SignUpActivity.class);
        startActivity(intentSignup);
  }

    public void forgotPasswordText(View view) {
        Intent intentForgotPassword = new Intent(MainLoginActivity.this, ForgotPasswordActivity.class);
        startActivity(intentForgotPassword);


    }



    //    CLICKING LOGIN BUTTON THEN CHECK USER EMAIL AND PASSWORD IN DATABASE
    public void loginButtonClicked(View view){

        //    DATA IS FETCHED FROM DATABASE IN BELOW ARRAYLIST ||||| USE LOOP AND CHECK ALL DATA IN DATABASE
        ArrayList<UserDetails> checkDataArrayList = databaseHelper.fetchData();

        String email = editTextLoginEmail.getText().toString();
        String password = editTextLoginPassword.getText().toString();
        Log.i("LoginData"," email: "+email+" password: "+ password);


        for (int i = 0; i < checkDataArrayList.size(); i++) {
            if (email.equals(checkDataArrayList.get(i).email) && password.equals(checkDataArrayList.get(i).password)){
//                IF ENTERED LOGIN AND PASSWORD ARE STORE IN DATABASE ALREADU USER LOGIN SUCCESSFULL
                Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_LONG).show();

                Intent intentLoginSuccess = new Intent(MainLoginActivity.this, HomeActivity.class);
                startActivity(intentLoginSuccess);
                Log.i("LoginData",checkDataArrayList.get(i).email);

            }
//            else {
//                Toast.makeText(getApplicationContext(),"Incorrect email or password!",Toast.LENGTH_LONG).show();
//            }
        }
    }



}