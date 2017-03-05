package com.cst2301.hwk8;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowValues extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_values);

        //reference to the output TextView
        TextView displayText = (TextView) findViewById(R.id.outputTV);

        //creating Intent to get passing parameters
        Intent getParameters = getIntent();

        //get the parameters
        double yourdisc = getParameters.getExtras().getDouble("discount");
        double totalprice = getParameters.getExtras().getDouble("price");

        //writing to textview
        displayText.setText("Your discount is $" + String.format("%.1f",yourdisc) +
                "\nYour price is $" + String.format("%.1f",totalprice));



    }
}
