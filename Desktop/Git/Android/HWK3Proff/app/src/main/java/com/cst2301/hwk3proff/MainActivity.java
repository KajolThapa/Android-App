package com.cst2301.hwk3proff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button showBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBTN =(Button)findViewById(R.id.showTextBTN);

    }

    public void displayText(View v){
        Toast.makeText(MainActivity.this,"It's fun to create mobile apps", Toast.LENGTH_LONG).show();

    }
}
