package com.cst2301.hwk8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //global variables
    double unitPrice = 20.;
    int minQty = 5;
    int maxQty = 20;
    int inputQ;
    double disc5_10 = 0.2;
    double disc10_15 = 0.3;
    double disc15_20 = 0.4;

    double disc, tPrice;
    EditText inputQty, outputDisc, outputTP;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define the references to the screen's objects
        inputQty = (EditText) findViewById(R.id.qtyET);
        outputDisc = (EditText) findViewById(R.id.discET);
        outputTP = (EditText) findViewById(R.id.tpriceET);

        //define a Listener to when the user enters a number in
        //the quantity EditText field: TextWatcher
        inputQty.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable userInput)
            {
                //clearing any previous outputs
                outputDisc.setText("");
                outputTP.setText("");

                //ensuring something is entered
                if (userInput.length() != 0)
                {
                    //converting userInput to String and then to Integer
                    inputQ = Integer.parseInt(userInput.toString());

                    //inputQ must be >= minQty and <=maxQty
                    if (inputQ >= minQty && inputQ <= maxQty)
                    {
                        if (inputQ >=5 && inputQ <=10)
                            disc = inputQ * unitPrice * disc5_10;
                        else
                        if (inputQ >10 && inputQ <=15)
                            disc = inputQ * unitPrice * disc10_15;
                        else
                        if (inputQ >15 && inputQ <=20)
                            disc = inputQ * unitPrice * disc15_20;

                        tPrice = unitPrice * inputQ - disc;

                        /*writing the outputs
                        outputDisc.setText(Double.toString(disc));
                        outputTP.setText(Double.toString(tPrice)); */

                        //creating an Intent to go to the second screen
                        Intent gotoSecondScreen = new Intent(MainActivity.this, ShowValues.class);

                        //passing the data (disc, totalprice) to the second screen
                        gotoSecondScreen.putExtra("discount",disc);
                        gotoSecondScreen.putExtra("price",tPrice);

                        //start the second screen activity
                        startActivity(gotoSecondScreen);
                    }
                    else
                        Toast.makeText(MainActivity.this,"MinQuantity=5 and MaxQuantity=20",
                                Toast.LENGTH_SHORT).show();
                }
           }
        });
    }
}










