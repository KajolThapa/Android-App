package com.cst2301.hwk11proff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{

    //global variables
    ListView sLV;

    //storing the names and the pictures' indexes in arrays
    String[] nameArray = {"Anthony Jayson", "John Smith","Kate Khan","Lisa Chen",
            "Mary Ash","Peter Chow","Raymond Perez",
            "Richard Hamslah","Rita Vasquez","Tanya Stevens"};
    int[] picIndex = {R.drawable.anthony_jayson,R.drawable.john_smith,
            R.drawable.kate_kahn, R.drawable.lisa_chen,
            R.drawable.mary_ash, R.drawable.peter_chow,
            R.drawable.raymond_perez,R.drawable.richard_hamslah,
            R.drawable.rita_vasquez,R.drawable.tanya_stevens
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining the ListView object
        sLV = (ListView) findViewById(R.id.studentLV);

        //creating an ArrayAdapter that draws each item on the screen
        ArrayAdapter<String> studentAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_expandable_list_item_1,nameArray);

        //setting this ArrayAdapter studentAdapter as the Adapter for the ListView
        sLV.setAdapter(studentAdapter);

        //putting a Listener on the ListView
        sLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //reading the name clicked(tapped) and the corresponding picture index
                String sName = nameArray[position];
                int spicIndex = picIndex[position];

                //let's send this name to the second screen
                //first, create an Intent
                Intent gotoSecondScreen = new Intent(MainActivity.this,ShowStudents.class);

                //pack the selected name and index with the Intent
                gotoSecondScreen.putExtra("selectedName",sName);
                gotoSecondScreen.putExtra("selectedIndex",spicIndex);

                //let's go to the second screen
                startActivity(gotoSecondScreen);
            }
        });

    }
}
