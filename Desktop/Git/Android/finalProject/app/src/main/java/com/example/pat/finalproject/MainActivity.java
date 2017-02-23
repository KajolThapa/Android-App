package com.example.pat.finalproject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText userID, password;
    Button searchBtn;
    SQLiteDatabase userBaseDB;
    String SQL_Create, SQL_Insert, SQL_Check, userInput, passInput;
    @Override
    //Unlike in class, the onCreate should be relatively clean. Logic for queries, maths, etc
    //should be in their own respective class' / methods
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userID = (EditText) findViewById(R.id.userID);
        password = (EditText) findViewById(R.id.passwd);

        searchBtn = (Button) findViewById(R.id.submitBtn);

        createDatabase();

        addInitialRecords();

        searchBtn.setOnClickListener(searchButtonListener);
    }

    public void createDatabase(){
        //Check if database users is present. If not, create.
        userBaseDB = openOrCreateDatabase("users", Context.MODE_PRIVATE,null);
        SQL_Create = "CREATE TABLE IF NOT EXISTS user_table(userID varchar"+
                        "not null unique on conflict replace, password varchar)";
        userBaseDB.execSQL(SQL_Create);
        System.out.println("Database created using QUERY " + SQL_Create);
    }

    public void addInitialRecords(){
        //user 1
        SQL_Insert = "INSERT INTO user_table VALUES('jane123','password!')";
        userBaseDB.execSQL(SQL_Insert);
        //user 2
        SQL_Insert = "INSERT INTO user_table VALUES('Mr.Cow', 'Moooo')";
        userBaseDB.execSQL(SQL_Insert);
        //user 3
        SQL_Insert = "INSERT INTO user_table VALUES('CST_Pat', 'someValue')";
        userBaseDB.execSQL(SQL_Insert);
        //user 4
        SQL_Insert = "INSERT INTO user_table VALUES('test', 'tester')";
        userBaseDB.execSQL(SQL_Insert);

        System.out.println("Insert query cleared!!");
    }

    View.OnClickListener searchButtonListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            userInput = userID.getText().toString().trim();
            passInput = password.getText().toString().trim();
            System.out.println(userInput + "\n" + passInput);

            SQL_Check = "SELECT userID, password FROM user_table WHERE userID = '"+
                        userInput + "' AND password = '"+passInput+"'";

            Cursor cursor = userBaseDB.rawQuery(SQL_Check, null);
            int ct = cursor.getCount();
            //this value will only evaluate as true if there is a returned query.
            if(ct>0){
                System.out.println("User is valid since user/pass matched returning an N>1 value");
                Toast.makeText(MainActivity.this,"Welcome "+userInput+"! You credentials are valid.", Toast.LENGTH_LONG).show();

                //Create intent for second screen
                //To be safe, don't do Intent(this, ClassName.class); It may try and pass button listener instead
                Intent gotoOutput = new Intent(MainActivity.this, OutputDisplay.class);
                //give the intent a tag to pair the value you want to send to the next screen
                gotoOutput.putExtra("user", userInput);
                //make a request to the system to build the next screen
                startActivity(gotoOutput);

            }
            //Just a catch to notify you if the cred's sent in are invalid.
            //Should be a try/catch, but I doubt Pinto cares about that...
            else{
                System.out.println("invalid user");
                Toast.makeText(MainActivity.this,"Invalid user name and password. Try agian!", Toast.LENGTH_LONG).show();
            }

        }
    };
}
