package com.cst2301.bitmap0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //creating an object of class LinearLayout
        LinearLayout myLL = new LinearLayout(MainActivity.this);

        //setting myLL parameters (to be used later)
        LinearLayout.LayoutParams myLP = new LinearLayout.LayoutParams(100,100);

        //setting the layout margins to 20 pixels all around:
        //top, bottom, left, right
        myLP.setMargins(80,20,20,20);

        //putting one button on the screen
        Button button1 = new Button(MainActivity.this);

        //putting a text on the button1
        button1.setText("Button 1");

        //showing button1 in a view on the layout
        myLL.addView(button1);

        //adding another button 100x100 pixels to the screen
        Button button2 = new Button(this);
        button2.setLayoutParams(myLP);
        button2.setText("Button 2"); //it will only shows letter B
        myLL.addView(button2);

        //displaying the layout
        setContentView(myLL);

        //putting a Listener to button1
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //if this button is pressed we are going
                //to the second screen without using Intent
                setContentView(R.layout.activity_show_bitmap);

                //displaying a TextView saying that we are
                //in the second screen
                TextView page2TV = (TextView) findViewById(R.id.outTV);
                page2TV.setText("This is second screen");

                //creating a Bitmap 100x100 pixels (width and height)
                Bitmap mybmp = Bitmap.createBitmap(100,100,Bitmap.Config.ARGB_8888);

                //coloring the Bitmap mybmp
                mybmp.eraseColor(Color.RED);

                //we need a ImageView to display the Bitmap mybmp
                ImageView sc2IV = (ImageView) findViewById(R.id.bmpIV);

                //displaying the Bitmap mybmp in the ImageView
                sc2IV.setImageBitmap(mybmp);

                //creating another Bitmap 300x300
                Bitmap mybmp2 = Bitmap.createBitmap(300,300,Bitmap.Config.ARGB_8888);

                //setting the color of the second bitmap to Blue
                mybmp2.eraseColor(Color.BLUE);

                //defining the second ImageView
                ImageView sc2IVTwo = (ImageView) findViewById(R.id.sc2IV2);

                //putting the second Bitmap into the second ImageView
                sc2IVTwo.setImageBitmap(mybmp2);

                //now let's draw something, like a rectangle
                //drawing the rectangle (Green) inside of the second bitmap (Blue)
                //We need a Canvas to do it
                //my Canvas will be the second Bitmap
                //creating a Canvas object
                Canvas mycanvas = new Canvas(mybmp2);

                //getting my pallete (Paint)
                Paint mypaint = new Paint();

                //setting the type of brush
                mypaint.setStrokeWidth(6F); //size requires a float measure

                //setting the color to green
                mypaint.setColor(Color.WHITE);

                //setting the type of stroke as line
                mypaint.setStyle(Paint.Style.STROKE);

                mycanvas.drawRect(20F,200F,180F,40F,mypaint);



            }
        });
    }
}
