package com.cst2301.swipephotoalbum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //global variables
    //1. integer array of image indexes
    int bikesID[]={R.drawable.bike1,
                    R.drawable.bike2,
                    R.drawable.bike3,
                    R.drawable.bike4};

    //2. String array with the names of bike
    //brands
    String bikesBrand[]={"BMC Commuter",
                         "Look765",
                         "Muirwoods",
                         "Ritchie RoadLogic"};

    //size of index array bikesID
    int bikesID_size = bikesID.length;

    //Linear Layout
    LinearLayout bikesLL;

    //ImageButton so to make each bike image
    //touch-sensitive
    ImageButton bikesIB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference to the LinearLayout
        bikesLL = (LinearLayout) findViewById(R.id.scrollableLL);

        //storing and displaying each image onto the LinearLayout
        //as image buttons
        for(int i=0; i<bikesID_size;i++)
        {
            bikesIB = new ImageButton(this);

            //loading each ImageButton to the LL
            bikesIB.setImageResource(bikesID[i]);

            //displaying it with an addView
            bikesLL.addView(bikesIB);

            //displaying each bikes' brand
            bikesIB.setContentDescription(bikesBrand[i]);

            //defining a Listener as the user clicks
            //(taps) on the ImageButton
            bikesIB.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View currentBTN)
                {
                  //getting the array element corresponding
                  //to the current ImageButton
                    String bikebrand = (String) currentBTN.getContentDescription();

                    //displaying the description in a Toast
                    Toast.makeText(MainActivity.this,bikebrand,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
