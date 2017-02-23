package com.cst2301.midtermb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //global variables
    EditText IDET;
    RadioGroup citiesRG;
    RadioButton selectedRB;
    Button clickBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining the references to the objects
        IDET = (EditText) findViewById(R.id.idET);
        citiesRG = (RadioGroup) findViewById(R.id.cityRG);
        clickBTN = (Button) findViewById(R.id.showBTN);

        //set Listener to the clickBTN
        clickBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //reading the user ID
                String userID = IDET.getText().toString();

                //ensuring the user did not leave blank the user ID field
                if (userID.length()!= 6)
                    IDET.setError(Html.fromHtml("<font color='red'>6-digit long</font>"));
                else
                {
                    //reading the selected radio button
                    //first, finding the index of the selected radio button
                    int indexSelectedRB = citiesRG.getCheckedRadioButtonId();

                    //finding the corresponding Radio Button with the selected index
                    selectedRB = (RadioButton) findViewById(indexSelectedRB);

                    //last step, uncovering the text of this Radio Button
                    String city = selectedRB.getText().toString();

                    //creating Intent to go to  second screen
                    Intent gotoSecondScreen = new Intent(MainActivity.this, ShowValues.class);

                    //packing the ID and the city with the Intent
                    gotoSecondScreen.putExtra("id", userID);
                    gotoSecondScreen.putExtra("City",city);

                    //going to second screen
                    startActivity(gotoSecondScreen);
                }
            }
        });
    }
}













