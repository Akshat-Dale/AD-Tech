package com.akshatdale.adtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class signUpActivity extends AppCompatActivity {

    Intent intent;
    EditText editTextSignUpName, editTextSignUpEmail,editTextSignUpPassword, editTextSignUpConfirmPassword;
    Button buttonSignup;
    ImageView signUpGoogle, signUpFacebook, signUpTwitter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        FINDING ALL ID'S
        editTextSignUpName =findViewById(R.id.editTextSignUpName);
        editTextSignUpEmail = findViewById(R.id.editTextSignUpEmail);
        editTextSignUpPassword = findViewById(R.id.editTextSignUpPassword);
        editTextSignUpConfirmPassword = findViewById(R.id.editTextSignUpConfirmPassword);
        signUpGoogle = findViewById(R.id.signUpGoogle);
        signUpFacebook = findViewById(R.id.signUpFacebook);
        signUpTwitter = findViewById(R.id.signUpTwitter);
        buttonSignup = findViewById(R.id.buttonSignup);

         intent = new Intent(signUpActivity.this,MainActivity.class);
         databaseHelper = new DatabaseHelper(this);

    }

//    IF CLICK ON ALREADY USER
    public void alreadyUserLogin(View view) {
        startActivity(intent);
    }


//    ADDING DATA IN DATABASE WHILE ADDING DETAILS AND CLICK ON SIGNUP BUTTON


    public void signUpButtonClicked(View view){
        String name = editTextSignUpName.getText().toString();
        String email = editTextSignUpEmail.getText().toString();
        String password = editTextSignUpPassword.getText().toString();
        String confirmPassword = editTextSignUpConfirmPassword.getText().toString();

//        CHECK ALL FIELDS ALL FIELD OR NOT
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(getApplicationContext(), "fill all fields..!", Toast.LENGTH_LONG).show();

        }
        else {
//            CONFIRM PASSWORD
            if (password.equals(confirmPassword)) {

                Log.i("SIGNUP DATA", "name: " + name + " email: " + email);
                databaseHelper.signUpData(name, email, password);
                Toast.makeText(getApplicationContext(), "Sign up successful !", Toast.LENGTH_LONG).show();

                Intent intentSignUpSuccess = new Intent(signUpActivity.this, HomeActivity.class);
                startActivity(intentSignUpSuccess);
            }
            else {
                Toast.makeText(getApplicationContext(), "Password Incorrect", Toast.LENGTH_LONG).show();
            }
        }
    }
}