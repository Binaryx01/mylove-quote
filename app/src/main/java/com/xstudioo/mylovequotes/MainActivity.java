package com.xstudioo.mylovequotes;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    CardView loveMessages,lovePoems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // For Toolbar
        Toolbar toolbar  = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        loveMessages = (CardView) findViewById(R.id.love_messages);
        lovePoems = (CardView) findViewById(R.id.love_poem);

        loveMessages.setOnClickListener(this);
        lovePoems.setOnClickListener(this);






        // To read data from assets folder

        AssetManager manager = getAssets();
        try {
            InputStream in = manager.open("data");
            Scanner scn = new Scanner(in);

            while (scn.hasNext()){

                String temp = scn.nextLine();
                // Splitting the data

                String quote = temp.split("[|]")[0];
                String author = temp.split("[|]")[1];

                Log.d("MainActivity",quote +"------" +author);




            }




        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void onClick(View v) {

        Intent i;


        switch (v.getId()){


            case R.id.love_messages: i = new Intent(getApplicationContext(),test.class);
            startActivity(i);
            break;

            case R.id.love_poem: i= new Intent(getApplicationContext(),test.class);
            
                startActivity(i);
                break;
                


      default:

        }





    }
}
