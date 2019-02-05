package com.xstudioo.mylovequotes;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class lovemsgcat extends AppCompatActivity {

    ListView list;
    MyAdapter myAdapter;


   ArrayList<String> data = new ArrayList<>();
   String a;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovemsgcat);

       list = findViewById(R.id.lovemsglist);
       myAdapter = new MyAdapter();





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
                data.add(quote);





            }




        } catch (IOException e) {
            e.printStackTrace();
        }





// https://github.com/ishwor013/mylove-quote








       data.add("I love u");
        data.add("I miss u");
       data.add("I kiss u");
         data.add("I hold u");


        list.setAdapter(myAdapter);



    }



// creating new myadapter class for list view

     class MyAdapter extends BaseAdapter{


         @Override
         public int getCount() {
             return data.size();
         }

         @Override
         public Object getItem(int position) {



             return null;
         }

         @Override
         public long getItemId(int position) {
             return 0;
         }

         @Override
         public View getView(final int position, View convertView, ViewGroup parent) {

            View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.itemlayout,null);
             TextView title = v.findViewById(R.id.itemtextid);
             title.setText(data.get(position));



             v.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     Intent intent = new Intent(getApplicationContext(),test.class);
                     //intent.putExtra("fullqt",list.getItemAtPosition(position).toString());

                  //   intent.putExtra("fullqt",list.getItemAtPosition(position).toString());


                     startActivity(intent);

                 }
             });


             return v;
         }
     }










}
