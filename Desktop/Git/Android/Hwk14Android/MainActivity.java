package com.cst2301.hwk14;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    //global variables
    MediaPlayer xmasMP, rsMP, ssMP;
    Button xmasBTN, rsBTN, ssBTN;

    int playing = 0; //not playing

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining the objects
        xmasMP = new MediaPlayer();
        xmasMP = MediaPlayer.create(this,R.raw.christmas_ringtone);

        rsMP = new MediaPlayer();
        rsMP = MediaPlayer.create(this,R.raw.rising_sun);

        ssMP = new MediaPlayer();
        ssMP = MediaPlayer.create(this,R.raw.suicide_squad);

        //now the buttons
        xmasBTN = (Button) findViewById(R.id.button1);
        rsBTN = (Button) findViewById(R.id.button2);
        ssBTN = (Button) findViewById(R.id.button3);

        //creating a common listener to all of the three buttons
        xmasBTN.setOnClickListener(buttonListener);
        rsBTN.setOnClickListener(buttonListener);
        ssBTN.setOnClickListener(buttonListener);
    }//end of onCreate

    //defining the buttonListener
    View.OnClickListener buttonListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (v == xmasBTN)
            {
                switch(playing)
                {
                    case 0: //now it is playing
                        playing = 1;
                        xmasMP.start();
                        xmasBTN.setText("Pause");

                        //setting the two other buttons invisible
                        rsBTN.setVisibility(View.INVISIBLE);
                        ssBTN.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        playing = 0; //now it is playing
                        xmasMP.pause();
                        xmasBTN.setText("Play");

                        //setting the two other buttons invisible
                        rsBTN.setVisibility(View.VISIBLE);
                        ssBTN.setVisibility(View.VISIBLE);
                        break;
                }
            }
            if (v == rsBTN)
            {
                switch(playing)
                {
                    case 0: //now it is playing
                        playing = 1;
                        rsMP.start();
                        rsBTN.setText("Pause");

                        //setting the two other buttons invisible
                        xmasBTN.setVisibility(View.INVISIBLE);
                        ssBTN.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        playing = 0; //now it is playing
                        rsMP.pause();
                        rsBTN.setText("Play");

                        //setting the two other buttons invisible
                        xmasBTN.setVisibility(View.VISIBLE);
                        ssBTN.setVisibility(View.VISIBLE);
                        break;
                }
            }
        }
    };
}











