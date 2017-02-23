package com.cst2301.hwk11proff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class ShowStudents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);

        //defining the objects on the screen
        ImageView sIV = (ImageView) findViewById(R.id.studentIV);
        EditText sET = (EditText) findViewById(R.id.outputET);

        //let's get the variables
        //first, create an Intent
        Intent getVars = getIntent();

        //getting the variables
        String name = getVars.getExtras().getString("selectedName");
        int pIndex = getVars.getExtras().getInt("selectedIndex");

        //displaying the picture in the ImageView object
        sIV.setImageResource(pIndex);

        //writing the selected name onto the EditText object
        sET.setText(name);
    }
}

