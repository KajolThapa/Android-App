package com.cst2301.intentsimplemath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowValue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_value);

        //reference
        TextView outTV = (TextView) findViewById(R.id.outputTV);

        //getting the passing number
        //creating an Intent
        Intent getNumber = getIntent();

        //storing the passing number to an integer variable
        int outnumber = getNumber.getExtras().getInt("varnum");

        //writing the number times 10 to the textview
        outTV.setText("Ten times the number: " + outnumber * 10);

    }
}
