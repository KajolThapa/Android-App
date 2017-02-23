package com.cst2301.booksearchdb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //global variables
    EditText inSearchET;
    Button sBTN;

    SQLiteDatabase booksDB;

    String SQLcreate, SQLinsert, inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define screen's objects
        inSearchET = (EditText) findViewById(R.id.inputSearchET);
        sBTN = (Button) findViewById(R.id.searchBTN);

        //calling the method to create the database booksDB
        createDatabase();

        //adding records to the database table books_table
        //calling the add records method
        addInitialRecords();

        //setting up a Listener to the Search button
        sBTN.setOnClickListener(searchButtonListener);
    }//end of onCreate()

    public void createDatabase()
    {
        //creating or openning the database: object booksDB and instance books
        booksDB = openOrCreateDatabase("books", Context.MODE_PRIVATE,null);

        //create the table associated with the database books
        SQLcreate = "create table if not exists books_table(ISBN varchar " +
                    "not null unique on conflict replace, title varchar, author varchar)";

        //running this SQL command
        booksDB.execSQL(SQLcreate);
        Toast.makeText(this,"table created/opened",Toast.LENGTH_SHORT).show();
    }

    public void addInitialRecords()
    {
        //creating a SQL insert command
        SQLinsert = "insert into books_table values('123','Android Programming Concepts',"+
                    "'Trish Hornez and Richard Cornez')";

        //running the above SQL command
        booksDB.execSQL(SQLinsert);

        //inserting a second record
        //creating a SQL insert command
        SQLinsert = "insert into books_table values('456','Learning Java by Building Android Games',"+
                "'John Horton')";

        //running the above SQL command
        booksDB.execSQL(SQLinsert);

        //inserting a third record
        //creating a SQL insert command
        SQLinsert = "insert into books_table values('789','Android Boot Camp',"+
                "'Corinne Hoisington')";

        //running the above SQL command
        booksDB.execSQL(SQLinsert);

        Toast.makeText(this,"insertion done",Toast.LENGTH_SHORT).show();
    }

    //defining the Search button Listener called searchButtonListener
    View.OnClickListener searchButtonListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            //reading the input search string
            inputSearch = inSearchET.getText().toString();

            if (!inputSearch.equalsIgnoreCase(""))
            {
                //going to the second screen to display search results
                Intent gotoSecondScreen = new Intent(MainActivity.this, ShowRecords.class);

                //packing inputSearch with the Intent
                gotoSecondScreen.putExtra("searchKey", inputSearch);

                //going to 2nd screen
                startActivity(gotoSecondScreen);
            }
            else
                Toast.makeText(MainActivity.this,"Please enter a search text",Toast.LENGTH_SHORT).show();

        }
    };
}












