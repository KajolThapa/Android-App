package com.example.pat.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OutputDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_display);

        TextView output = (TextView) findViewById(R.id.outputState);

        Intent getData = getIntent();

        String userName = getData.getExtras().getString("user");

        output.setText("Welcome " + userName + "!");
    }
}
