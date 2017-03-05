package com.cst2301.hwk5and6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //global variables
    EditText userET, pwdET;
    boolean goodinputs = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create references to the screen's objects
        userET = (EditText) findViewById(R.id.inputUserET);
        pwdET = (EditText) findViewById(R.id.inputPwdET);

        //define a TextWatcher for the password EditText field
        pwdET.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s)
            {
                if (s.length()==6)
                {
                    //getting the String values of the EditText inputs
                    String user = userET.getText().toString();
                    String pwd = pwdET.getText().toString();

                    //Toast.makeText(MainActivity.this,"User: " + user + " Password: " + pwd,Toast.LENGTH_LONG).show();

                    //checking if the pair of inputs is one of the acceptable ones
                    //The acceptable ones will be stored in an 2D string array
                    String[][] logonArray = new String[3][2];

                    //populating the array
                    logonArray[0][0] = "bear1";
                    logonArray[0][1] = "allons";
                    logonArray[1][0] = "ilPardo";
                    logonArray[1][1] = "1Jxff2";
                    logonArray[2][0] = "clicker";
                    logonArray[2][1] = "onClau";

                    //boolean found a matching pair
                    boolean found = false;

                    //checking for valid pairs - looping all rows
                    for (int row=0; row <3; row++)
                    {
                        if (user.equalsIgnoreCase(logonArray[row][0]) &&
                                pwd.equalsIgnoreCase(logonArray[row][1]))
                        {
                            found=true;
                            break;
                        }
                    }

                    //now we are ready to check if we stay on the first screen
                    //or go to the second screen
                    if (found == true)
                    {
                        //create an Intent to go to the second screen
                        Intent gotoScreen2 = new Intent(MainActivity.this,UserInfo.class);
                        Toast.makeText(MainActivity.this,"User: " + user + " Password: " + pwd,Toast.LENGTH_LONG).show();

                        //packaging the inputs with the Intent gotoScreen2
                        gotoScreen2.putExtra("userName",user);
                        gotoScreen2.putExtra("password",pwd);

                        //go to second screen by starting the activity
                        startActivity(gotoScreen2);
                    }
                    else
                        Toast.makeText(MainActivity.this,"Invalid user and/or password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}











