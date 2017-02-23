package com.cst2301.midterma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowValues extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_values);

        //reference to the output TextView
        TextView outTV = (TextView) findViewById(R.id.outputTV);

        //let's get the inputs passed by the first screen
        //first creating an Intent to get the inputs
        Intent getInputs = getIntent();

        //getting them
        String fn = getInputs.getExtras().getString("firstName");
        String ln = getInputs.getExtras().getString("lastName");
        String zc = getInputs.getExtras().getString("zipCode");

        //extracting the first 3 characters of the input Zip code
        String first3chars = zc.substring(0,3);   //start position 0 and 3 chars long

        //creating an output zip code string
        String outZipCode = "";

        switch (first3chars)
        {
            case "100":
                outZipCode = "Manhattan";
                break;
            case "103":
                outZipCode = "Staten Island";
                break;
            case "104":
                outZipCode = "Bronx";
                break;
            case "112":
                outZipCode = "Brooklyn";
                break;
            case "110":case "111":case "113":case "114":case "116":
                outZipCode = "Queens";
                break;
            default:
                outZipCode = "Not a NY Borough";
        }

        //writing the outputs to the TextView
        outTV.setText(fn + " " + ln + " your zip code of " + zc +
                        " is " + outZipCode);
    }
}












