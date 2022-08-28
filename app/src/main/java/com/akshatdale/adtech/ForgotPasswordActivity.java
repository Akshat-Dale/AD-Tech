package com.akshatdale.adtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText editTextForgotPassEmail,editTextForgotPassNewPassword,editTextForgotPassConfirmPassword;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editTextForgotPassEmail = findViewById(R.id.editTextForgotPassEmail);
        editTextForgotPassNewPassword = findViewById(R.id.editTextForgotPassNewPassword);
        editTextForgotPassConfirmPassword = findViewById(R.id.editTextForgotPassConfirmPassword);

        databaseHelper = new DatabaseHelper(this);
    }

    public void passwordChangedConfirmButtonClicked(View view) {

        String email = editTextForgotPassEmail.getText().toString();
        String newPassword = editTextForgotPassNewPassword.getText().toString();
        String newPasswordConfirm = editTextForgotPassConfirmPassword.getText().toString();

        UserDetails userDetails = new UserDetails();
        if (newPassword.equals(newPasswordConfirm)){

            userDetails.email = email;
            userDetails.password = newPasswordConfirm;

            databaseHelper.forgotPasswordData(userDetails);
            Toast.makeText(getApplicationContext(),"Password changed successfully",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Password incorrect !",Toast.LENGTH_SHORT).show();
        }
    }
}