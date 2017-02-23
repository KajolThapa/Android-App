package com.cst2301.midtermb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ShowValues extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_values);

        //references
        EditText outputID = (EditText) findViewById(R.id.outIDET);
        EditText outputCity = (EditText) findViewById(R.id.outCityET);
        TextView outputAtt = (TextView) findViewById(R.id.outAttractionsTV);

        //creating Intent to get the variables
        Intent getVars = getIntent();

        //getting the variables
        String outID = getVars.getExtras().getString("id");
        String outCity = getVars.getExtras().getString("City");

        //writing the ID and city in the EditText fields
        outputID.setText(outID);
        outputCity.setText(outCity);

        if (outCity.equalsIgnoreCase("New York City"))
            outputAtt.setText("Empire State Building\n" +
                    "Statue of Liberty\n"
                    +"Madison Square Garden");
        else
        if (outCity.equalsIgnoreCase("Newark"))
            outputAtt.setText("New Jersey Performing Arts Center\n" +
                    "IronBound\n"
                    +"Branch Brook Park");
    }
}












