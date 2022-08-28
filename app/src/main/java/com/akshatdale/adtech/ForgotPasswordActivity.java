package com.akshatdale.adtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText editTextForgotPassEmail,editTextForgotPassNewPassword,editTextForgotPassConfirmPassword;
    DatabaseHelper databaseHelper;
    Button buttonForgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editTextForgotPassEmail = findViewById(R.id.editTextForgotPassEmail);
        editTextForgotPassNewPassword = findViewById(R.id.editTextForgotPassNewPassword);
        editTextForgotPassConfirmPassword = findViewById(R.id.editTextForgotPassConfirmPassword);
        buttonForgotPassword = findViewById(R.id.buttonForgotPassword);
        databaseHelper = new DatabaseHelper(this);
    }

    public void passwordChangedConfirmButtonClicked(View view) {

        String email = editTextForgotPassEmail.getText().toString();
        String newPassword = editTextForgotPassNewPassword.getText().toString();
        String newPasswordConfirm = editTextForgotPassConfirmPassword.getText().toString();

//        CHECKING ALL FIELD ARE FILL OR NOT
        if (email.isEmpty() || newPassword.isEmpty() || newPasswordConfirm.isEmpty()){
            Toast.makeText(getApplicationContext(),"Fill all fields",Toast.LENGTH_SHORT).show();
        }
        else {
            UserDetails userDetails = new UserDetails();
            if (newPassword.equals(newPasswordConfirm)) {

//                STORING EMAIL AND NEW PASSWORD IN USERDETAILS STRUCTURE (EMAIL,PASSWORD) UPDATE METHOD TAKE DATA FROM USERDETAILS
                userDetails.email = email;
                userDetails.password = newPasswordConfirm;
//                CALLING UPDATE METHOD IN DatabaseHelper CLASS TO UPDATE PASSWORD
                databaseHelper.forgotPasswordData(userDetails);
                Toast.makeText(getApplicationContext(), "Password changed successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Password incorrect !", Toast.LENGTH_SHORT).show();
            }
        }
    }
}