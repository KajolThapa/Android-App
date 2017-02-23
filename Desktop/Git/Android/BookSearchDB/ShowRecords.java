package com.cst2301.booksearchdb;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowRecords extends AppCompatActivity
{
    //global variables
    SQLiteDatabase booksDB;

    //pointer to the database records
    Cursor c;

    //declaring the TextView objects (used for output)
    TextView keyTV, norecsTV,outputresultTV, outnumRecs;

    //declaring the buttons
    Button prevB, nextB;

    //search key word
    String userSearchWord = "";


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
        userSearchWord = getInput.getExtras().getString("searchKey").trim();

        //creating a SQL select string to extract record(s) that match
        //the search key
        String SQLselect2 = "select * from books_table where ISBN like '%" + userSearchWord +
                            "%' or title like '%" + userSearchWord  + "%' or " +
                            "author like '%" + userSearchWord + "%'";

        //running SQLselect2
        //define the pointer type Cursor to the first record if any
        c = booksDB.rawQuery(SQLselect2,null);

        //defining the buttons and the textviews
        prevB = (Button) findViewById(R.id.prevBTN);
        nextB = (Button) findViewById(R.id.nextBTN);
        outputresultTV = (TextView) findViewById(R.id.outResultTV);
        outnumRecs = (TextView) findViewById(R.id.outrecsTV);

        //counting the number of records that match the inputSearch
        int countrec = c.getCount();

        if (countrec != 0)
        {
            outnumRecs.setText("Number of Records: " + countrec);

            if (c.moveToFirst())
            {
                if (countrec == 1)
                {
                    //Hiding both buttons (prev and next)
                    prevB.setVisibility(View.INVISIBLE);
                    nextB.setVisibility(View.INVISIBLE);
                    showmatchRecords();
                }
                else
                {
                    for (int i=0; i < countrec; i++)
                    {
                        showmatchRecords();

                        //creating a single button listener for the two buttons (prev and next)
                        prevB.setOnClickListener(buttonListener);
                        nextB.setOnClickListener(buttonListener);
                    }
                }
            }
        }
        else
        {
            //Hiding both buttons (prev and next)
            prevB.setVisibility(View.INVISIBLE);
            nextB.setVisibility(View.INVISIBLE);

            //showing negative result
            outnumRecs.setText("");
            outputresultTV.setText("No records found");
        }
    }//end of onCreate

    //defining openDatabase()
    public void openDatabase()
    {
        booksDB = openOrCreateDatabase("books", Context.MODE_PRIVATE,null);
    }

    //defining showmatchRecords()
    public void showmatchRecords()
    {
        //getting all fields' values
        String mISBN = c.getString(0);
        String mtitle = c.getString(1);
        String mauthor = c.getString(2);

        //showing the matched record(s) -- sorry only the last match for multiple matches
        outputresultTV.setText("ISBN: " + mISBN + "\nTitle: " + mtitle + "\nAuthor: " + mauthor + "\n");
    }

    //defining Listener for the previous and next buttons
    View.OnClickListener buttonListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if (v == prevB)
            {
                if (!c.isFirst())
                {
                    c.moveToPrevious();
                    showmatchRecords();
                }
            }
            if (v == nextB)
            {
                if (!c.isLast())
                {
                    c.moveToNext();
                    showmatchRecords();
                }
            }
        }
    };
}










