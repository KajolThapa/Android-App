package com.cst2301.countrylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    String[] countryArray={"Austria","Bulgaria","China"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference to ListView
        ListView cLV = (ListView) findViewById(R.id.countryLV);

        //adapter
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(
                MainActivity.this,android.R.layout.simple_list_item_1,countryArray);

        //display ListView by setting the adapter countryAdapter to the ListView
        cLV.setAdapter(countryAdapter);

        //set a Listener to the ListView
        cLV.setOnItemClickListener(countryListener);
    }

    AdapterView.OnItemClickListener countryListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            //reading the selected country
            String selectedCountry = countryArray[position];

            String capital = "";

            if (selectedCountry.equalsIgnoreCase("Austria")) capital="Vienna";
            else if (selectedCountry.equalsIgnoreCase("Bulgaria")) capital="Sofia";

            Toast.makeText(MainActivity.this,"Selected Country: " + selectedCountry +
                    "\nCapital: " + capital,
                    Toast.LENGTH_SHORT).show();
        }
    };
}
