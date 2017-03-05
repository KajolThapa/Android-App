package com.cst2301.hwk4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Registration extends AppCompatActivity
{
    //global variables
    EditText inputID;
    RadioGroup levelRadioGroup;
    RadioButton checkedRadioButton;
    Button clickBTN;
    //inputs
    int inputLevelID, studentID;
    String inputLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //define the references
        inputID = (EditText) findViewById(R.id.idET);
        levelRadioGroup = (RadioGroup) findViewById(R.id.levelRG);
        clickBTN = (Button) findViewById(R.id.submitBTN);

        //creating a listener to the submit button
        clickBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //reading the inputs
                studentID = Integer.parseInt(inputID.getText().toString());

                //reading the radio button that was checked
                //first reading the radio ID of the checked radio button
                inputLevelID = levelRadioGroup.getCheckedRadioButtonId();

                //second, getting the value associate with the checked radio button
                //but before let's define the checked radio button
                checkedRadioButton = (RadioButton)findViewById(inputLevelID);

                //now we can know the value of this button
                inputLevel = checkedRadioButton.getText().toString();

                //creating an Intent to go to the second screen(activity)
                Intent gotoDisplayInfo = new Intent(Registration.this,DisplayInfo.class);

                //packing the inputs with the created Intent
                gotoDisplayInfo.putExtra("inputID",studentID);
                gotoDisplayInfo.putExtra("levelRead",inputLevel);

                //start the Intent
                startActivityForResult(gotoDisplayInfo,1);

                //let's toast
                Toast.makeText(Registration.this,"ID: " + studentID + "\n" +
                "Level: " + inputLevel,Toast.LENGTH_LONG).show();
            }
        });
    }
}








