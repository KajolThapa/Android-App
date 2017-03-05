package com.cst2301.hwk10listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ShowValues extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_values);

        //reference to the TextView
        TextView outTV = (TextView) findViewById(R.id.outputTV);

        //getting the passing variable
        //create first the intent to get the variable
        Intent getVar = getIntent();

        int qty = getVar.getExtras().getInt("quantity");

        double disc = 0, discount, unitPrice=20, tPrice;

        if (qty >= 5 && qty<=10) disc = 0.2;
        else if (qty >10 && qty<=15) disc = 0.3;
        else if (qty >15 && qty<=20) disc = 0.4;

        discount = qty * unitPrice * disc;

        tPrice = qty * unitPrice - discount;

        //ready to write to the TextView
        outTV.setText("For the quantity: " + qty +
                       "\n\nDiscount: $"+discount +
                       "\n\nPrice: $" + tPrice);


    }
}










