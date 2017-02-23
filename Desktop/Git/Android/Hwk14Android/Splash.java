package com.cst2301.hwk14;

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

        Timer splashTime = new Timer();
        splashTime.schedule(splashTask,3000);
    }//end of onCreate

    //defining object splashTask of the class TimerTask
    TimerTask splashTask = new TimerTask()
    {
        @Override
        public void run()
        {
            finish();

            //going to the next screen
            Intent gotoNextScreen = new Intent(Splash.this,MainActivity.class);
            startActivity(gotoNextScreen);
        }
    };
}










