package com.cst2301.midterma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    //global variables
    EditText inputLastName, inputFirstName, inputZipCode;
    Button clickBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //references to the input objects
        inputFirstName = (EditText) findViewById(R.id.fNameET);
        inputLastName = (EditText) findViewById(R.id.lNameET);
        inputZipCode = (EditText) findViewById(R.id.zipET);
        clickBTN = (Button) findViewById(R.id.showBTN);

        //let's bring the listener
        clickBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //reading the inputs
                String iFirstName = inputFirstName.getText().toString();
                String iLastName = inputLastName.getText().toString();
                String iZipCode = inputZipCode.getText().toString();

                //all the calculation will be done in the 2nd screen
                //so passing the inputs to the 2nd screen
                //first, creating an Intent to go to the 2nd screen
                Intent gotoSecondScreen = new Intent(MainActivity.this,ShowValues.class);

                //second, pack the inputs with the created Intent
                gotoSecondScreen.putExtra("firstName",iFirstName);
                gotoSecondScreen.putExtra("lastName",iLastName);
                gotoSecondScreen.putExtra("zipCode",iZipCode);

                //start going to 2nd screen
                startActivity(gotoSecondScreen);
            }
        });

    }
}
