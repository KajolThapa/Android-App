package com.cst2301.hwk15;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //creating a Timer
        Timer splashtime = new Timer();
        splashtime.schedule(showIcon, 5000);
    }

    //creating an object showIcon of class TimerTask
    TimerTask showIcon = new TimerTask()
    {
        @Override
        public void run()
        {
            finish();

            //go to Main screen
            Intent gotoMain = new Intent(Splash.this,MainActivity.class);
            startActivity(gotoMain);
        }
    };
}













