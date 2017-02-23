package com.example.pratikkajol.project;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //global variables
    EditText userET, pwdET;
    Button sBTN;

    boolean goodinputs = false;

    SQLiteDatabase userinfoDB;

    String SQLcreate, SQLinsert;
    String inputSearchUser, inputSearchPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define screen's objects
        userET = (EditText) findViewById(R.id.inputUserET);
        pwdET = (EditText) findViewById(R.id.inputPwdET);
        sBTN = (Button) findViewById(R.id.submitBTN);

        //calling the method to create the database booksDB
        createDatabase();

        //adding records to the database table books_table
        //calling the add records method
        addInitialRecords();

        //setting up a Listener to the Search button
        sBTN.setOnClickListener(searchButtonListener);
    }//end of onCreate()

    public void createDatabase() {
        //creating or openning the database: object booksDB and instance books
        userinfoDB = openOrCreateDatabase("login", Context.MODE_PRIVATE, null);

        //create the table associated with the database books
        SQLcreate = "create table if not exists loginapp_table(userid varchar " +
                "not null unique on conflict replace, password varchar)";

        //running this SQL command
        userinfoDB.execSQL(SQLcreate);
        Toast.makeText(this, "table created/opened", Toast.LENGTH_SHORT).show();
    }

    public void addInitialRecords() {
        //creating a SQL insert command
        SQLinsert = "insert into loginapp_table values('PratikBhusal', " + " '881872')";

        //running the above SQL command
        userinfoDB.execSQL(SQLinsert);

        //inserting a second record
        //creating a SQL insert command
        SQLinsert = "insert into loginapp_table values('RoshanPandey'," + " '035165')";

        //running the above SQL command
        userinfoDB.execSQL(SQLinsert);

        //inserting a third record
        //creating a SQL insert command
        SQLinsert = "insert into loginapp_table values('KajolThapa'," + " '333333')";

        //running the above SQL command
        userinfoDB.execSQL(SQLinsert);

        //inserting a fourth record
        //creating a SQL insert command
        SQLinsert = "insert into loginapp_table values('RadhikaBartaula'," + " '902789')";

        //running the above SQL command
        userinfoDB.execSQL(SQLinsert);

        Toast.makeText(this, "insertion done", Toast.LENGTH_SHORT).show();
    }

    //defining the Search button Listener called searchButtonListener
    View.OnClickListener searchButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //reading the input search string
            inputSearchUser = userET.getText().toString();
            inputSearchPwd = pwdET.getText().toString();

            if ((!inputSearchUser.equalsIgnoreCase("")) && (!inputSearchPwd.equalsIgnoreCase(""))) {

                //checking if the pair of inputs is one of the acceptable ones
                //The acceptable ones will be stored in an 2D string array
                String[][] logonArray = new String[4][2];

                //populating the array
                logonArray[0][0] = "PratikBhusal";
                logonArray[0][1] = "881872";
                logonArray[1][0] = "RoshanPandey";
                logonArray[1][1] = "035165";
                logonArray[2][0] = "KajolThapa";
                logonArray[2][1] = "333333";
                logonArray[3][0] = "RadhikaBartaula";
                logonArray[3][1] = "902789";

                //boolean found a pair
                boolean found = false;

                //checking for valid pairs - looping all rows
                for (int row = 0; row < 4; row++) {
                    if (inputSearchUser.equalsIgnoreCase(logonArray[row][0]) &&
                            inputSearchPwd.equalsIgnoreCase(logonArray[row][2])) {
                        found = true;
                        break;
                    }
                }

                if (found == true) {


                    //going to the second screen to display search results
                    Intent gotoSecondScreen = new Intent(MainActivity.this, ShowRecords.class);

                    //packing inputSearch with the Intent
                    gotoSecondScreen.putExtra("searchKey1",inputSearchUser);
                    gotoSecondScreen.putExtra("searchKey2",inputSearchPwd);



                    //going to 2nd screen
                    startActivity(gotoSecondScreen);
                } else
                    Toast.makeText(MainActivity.this, "Invalid user and password", Toast.LENGTH_SHORT).show();


            }
        }};
    }















