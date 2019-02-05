package com.xstudioo.mylovequotes;

import android.content.res.AssetManager;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();



        ArrayList<Quote> list = new ArrayList<>();

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

                Quote qt = new Quote(quote);
                list.add(qt);




            }




        } catch (IOException e) {
            e.printStackTrace();
        }


        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        QuotePagerAdapter adapter = new QuotePagerAdapter(list, this);
        viewPager.setAdapter(adapter);





    }


    }

