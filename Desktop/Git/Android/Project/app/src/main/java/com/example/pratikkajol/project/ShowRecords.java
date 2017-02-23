package com.example.pratikkajol.project;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ShowRecords extends AppCompatActivity

{
    //global variables
    SQLiteDatabase userinfoDB;

    //pointer to the database records
    Cursor c;

    //declaring the TextView objects (used for output)
    TextView outnumRecs, outTV;

    //search key word
    String userSearchWord = "";
    String pwdSearchWord = "";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_records);

        //openning the database for read/write
        openDatabase();

        //getting the passing variable inputSearch
        Intent getInput = getIntent();

        //getting the string inputSearch
        userSearchWord = getInput.getExtras().getString("searchKey1").trim();
        pwdSearchWord = getInput.getExtras().getString("searchKey2").trim();

        //creating a SQL select string to extract record(s) that match
        //the search key
        String SQLselect2 = "select * from loginapp_table where userid like " + userSearchWord +
                             " or password like " + userSearchWord  + " ";

        //running SQLselect2
        //define the pointer type Cursor to the first record if any
        c = userinfoDB.rawQuery(SQLselect2,null);

        //defining  textview

        outTV = (TextView) findViewById(R.id.outputTV);
        outnumRecs = (TextView)findViewById(R.id.outrecsTV);

        //counting the number of records that match the inputSearch
        int countrec = c.getCount();

        if (countrec != 0)
        {
            outnumRecs.setText("Number of Records: " + countrec);
            {


                        showmatchRecords();


            }
        }
        else
            outnumRecs.setText("");
            outTV.setText("No records found");


    }//end of onCreate

    //defining openDatabase()
    public void openDatabase()
    {
        userinfoDB = openOrCreateDatabase("books", Context.MODE_PRIVATE,null);
    }

    //defining showmatchRecords()
    public void showmatchRecords()
    {
        //getting all fields' values
        String mUser = c.getString(0);
        String mPassword = c.getString(1);
        //showing the matched record(s) -- sorry only the last match for multiple matches
        outTV.setText("User Name: " + mUser + "\nPassword: " + mPassword + "\n");
    }



}


