package com.cst2301.homeworkthreeinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    // Global variable
    TextView quoteTV;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference to the output TextView
        quoteTV = (TextView)findViewById(R.id.outputTV);


    }
    // coding the method called by the Onclick property of the device's screen
    public void showQuote(View view)
    {


    //storing the quotes in the array
    String[] quoteArray = {"The more you practice \n" +
            "the more you learn \n" +
            "how to create Android Apps", "If you see something \n" +
            "say something", "Smile always"};

    int arraySize = quoteArray.length;


        quoteTV.setText(quoteArray[i]);
        i++;

       if (i > 2) i = 0;
        // or we can do if (i>arraySize-1) i=0


}
}
