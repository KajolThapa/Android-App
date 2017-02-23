package com.cst2301.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    //global variables
    TextView outputTV;
    Button clickBTN;
    ImageView outputIV;

    //counter to control the greeting
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining the references to the objects:
        // textview, image, and button
        outputTV = (TextView) findViewById(R.id.greetingTV);
        clickBTN = (Button) findViewById(R.id.tapmeBTN);
        outputIV = (ImageView) findViewById(R.id.greetingIV);

        //creating a listener to the tapmeBTN
        clickBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //let's say something, i.e., writing a text to the TextView
                if (counter == 0)
                {
                    //displaying the Hello greeting
                    //and corresponding image
                    outputIV.setImageResource(R.drawable.hello);
                    outputTV.setText("Hello");
                    counter++;
                }
                else
                {
                    //displaying the GoodBye greeting and picture
                    outputIV.setImageResource(R.drawable.goodbye);
                    outputTV.setText("GoodBye");
                    counter = 0;
                }
            }
        });
    } //end of onCreate()
}
