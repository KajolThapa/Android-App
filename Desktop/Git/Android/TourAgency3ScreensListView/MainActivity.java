package com.cst2301.touragency3screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    //Global Variables
    ListView destinationLV;

    //String array with the cities
    String citiesArray[] = {"New York City", "Newark", "Seattle"};

    //integer array  for the index of the corresponding images of cities
    int cityindexArray[]= {R.drawable.newyork,R.drawable.newark,R.drawable.seattle};



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining the cities ListView
        destinationLV = (ListView)findViewById(R.id.citiesLV);

        //We need an Adapter to display a listview
        //lets's create an ArrayAdapter( an agent(object) that draws each item on thge list0
        final ArrayAdapter<String> citiesAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,citiesArray);

        //setting citiesAdapter for the destinationLV
        destinationLV.setAdapter(citiesAdapter);

        //putting a Listener to a ListView
        destinationLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //reading the selected city and the corresponding image index
                String selectedCity = citiesArray[position];
                int selectedCityIndex = cityindexArray[position];

                //lets pass these two variables to the third screen
                // first create an Intent to go to third screen
                Intent gotoShowAttractions = new Intent(MainActivity.this,ShowAttractions.class);

                //packing all variables with the Intent
                gotoShowAttractions.putExtra("City", selectedCity);
                gotoShowAttractions.putExtra("Index",selectedCityIndex);

                //start the third screen
                startActivity(gotoShowAttractions);

            }
        });

    }
}
