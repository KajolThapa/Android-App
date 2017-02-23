package com.cst2301.intentsimplemath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    //global variables
    EditText inputNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference to the EditText object
        inputNumber = (EditText)findViewById(R.id.number1ET);

        //creating a Listener to the EditText object
        //a TextWatcher Listener
        inputNumber.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable enteredNumber)
            {
                //ensuring there is at least a digit in the enteredNumber
                if (enteredNumber.length() != 0)
                {
                    //extracting the number from the object inputNumber
                    int n1 = Integer.parseInt(inputNumber.getText().toString());

                    //sending the number to the second screen
                    //1. create an Intent to go to the second screen
                    Intent gotoSecondScreen = new Intent(MainActivity.this,ShowValue.class);

                    //packing the passing variable with the Intent
                    gotoSecondScreen.putExtra("varnum",n1);

                    //start activity of going to the second screen
                    startActivity(gotoSecondScreen);
                }

            }
        });
    }
}
