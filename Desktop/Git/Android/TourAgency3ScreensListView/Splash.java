
//Splash screen will lats only 5 sec(5000 milliseconds)
//usually the image is set to 800x1280 for most screens
package com.cst2301.touragency3screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //creating a timer so the splash screen will last only 5 seconds
        //to do it we need two Java classes:  TimerTask and Timer
        //First we create a TimerTask object

        TimerTask splashTimer  = new TimerTask() {
            @Override
            public void run()
            {
                //releasing the resources used to create the splash Activity
                //and closing the splash screen
                finish();

                //after finishing the splash let's go to the Main Activity
                Intent gotoMain = new Intent(Splash.this,MainActivity.class);

                //start Main
                startActivity(gotoMain);

            }
        };

        //creating a timer object and set it to last 5 sec = 5000 millisec
        Timer splashduration = new Timer();

        splashduration.schedule(splashTimer,5000);


    }
}
