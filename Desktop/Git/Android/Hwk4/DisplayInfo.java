package com.cst2301.hwk4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        //defining the outputs ETs
        TextView outID = (TextView) findViewById(R.id.outputIDTV);
        TextView level = (TextView) findViewById(R.id.outputLevelTV);


        //creating an Intent to get Inputs passed by
        //the first screen
        //Intent getInputs = getIntent();

        //getting inputs
        int studentID = getIntent().getIntExtra("inputID",0);
        String studentLevel = getIntent().getStringExtra("levelRead");

        /*Toast.makeText(DisplayInfo.this,"ID: " + studentID +
                "\n\nLevel: " + studentLevel,Toast.LENGTH_LONG).show();*/

        //write these inputs to the TextView lines
        outID.setText(""+studentID);
        level.setText(studentLevel);

    }
}








