package com.cst2301.hwk15;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    //global variables
    ListView moviesLV;

    //String array of movies' titles
    String[] moviesArray = {"Avatar","Titanic","Harry Potter 2","Transformer 2",
                            "The Lord of the Rings","Pirates of the Caribbean",
                            "Toy Story 3","Pirates of the Caribbean 3",
                            "Alice in Wonderland","The Dark Knight 1"};

    //String array of movies' web pages (not all of them)
    String[] webpageArray = {"http://www.imdb.com/title/tt0499549/?ref_=nv_sr_1",
                             "http://www.imdb.com/title/tt0120338/?ref_=nv_sr_1",
                             "http://www.imdb.com/title/tt1201607/?ref_=fn_al_tt_1",
                             "http://www.imdb.com/title/tt1055369/?ref_=fn_al_tt_1"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining ListView moviesLV
        moviesLV = (ListView) findViewById(R.id.top10LV);

        //to display moviesLV one needs an Adapter, an ArrayAdapter
        ArrayAdapter<String> movieAdapter = new ArrayAdapter<String>(this,R.layout.imagetextlist,
                                                                     R.id.movieTV,moviesArray);

        //setting movieAdapter as the Adapter for the moviesLV
        moviesLV.setAdapter(movieAdapter);

        //setting a Listener for the moviesLV
        moviesLV.setOnItemClickListener(movieListener);
    }

    //defining movieListener
    AdapterView.OnItemClickListener movieListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String URL = webpageArray[position];
            Intent openWebPage = new Intent(Intent.ACTION_VIEW);
            openWebPage.setData(Uri.parse(URL));
            startActivity(openWebPage);
        }
    };

}













