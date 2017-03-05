package com.cst2301.hwk5and6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class UserInfo extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        //getting the inputs passed by the first screen
        //we need to create an Intent to do this
        Intent getInputs = getIntent();

        //getting the inputs with the created Intent
        String inputName = getInputs.getStringExtra("userName");
        String inputPassword = getInputs.getStringExtra("password");

        Toast.makeText(UserInfo.this,"Welcome, " + inputName,Toast.LENGTH_LONG).show();
    }
}
