package com.cst2301.hwk10listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    //global variables
    ListView quantityLV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference to the ListView
        quantityLV = (ListView) findViewById(R.id.qtyLV);

        //creating an ArrayList of order quantities
        //to be displayed in the spinner
        List<Integer> qtyArray = new ArrayList<>();

        //let's populate the quantity_array
        for (int i=5; i<21; i++)
        {
            qtyArray.add(i);
        }

        //creating an ArrayAdapter for the qtyArray
        ArrayAdapter<Integer> qtyAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_list_item_1,qtyArray);

        //display the ListView by setting the adapter to the ListView
        quantityLV.setAdapter(qtyAdapter);

        //creating a Listener to the ListView
        //so we find out the selection
        quantityLV.setOnItemClickListener(listviewListener);
    }

    //define the listviewListener
    AdapterView.OnItemClickListener listviewListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            //reading the quantity selected
            int qtySelected = (int) parent.getItemAtPosition(position);

            //Toast.makeText(MainActivity.this,"Quantity Selected: " + qtySelected,Toast.LENGTH_SHORT).show();

            //starting the process of sending the qtySelected to the second screen
            //first create an Intent to go to the second screen
            Intent gotoSecondScreen = new Intent(MainActivity.this,ShowValues.class);

            //second, packing the variable with the Intent
            gotoSecondScreen.putExtra("quantity",qtySelected);

            //start going to second screen
            startActivity(gotoSecondScreen);


        }
    };
}



