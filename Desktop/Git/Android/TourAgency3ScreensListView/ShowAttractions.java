package com.cst2301.touragency3screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class ShowAttractions extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_attractions);

        //declare and define references to the screen object
        EditText choiceCity =(EditText)findViewById(R.id.outputCityET);
        ImageView choiceCityAttraction = (ImageView)findViewById(R.id.outputAttractionIV);

        //creating an Intent to get the variables
        Intent getInputs = getIntent();

        //get the selected city and the index
        String outCity = getInputs.getExtras().getString("City");
        int cIndex = getInputs.getExtras().getInt("Index");

        //writing the city into the EditText
        choiceCity.setText(outCity);
        choiceCityAttraction.setImageResource(cIndex);
    }
}
