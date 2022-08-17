package com.example.nyumbani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.database.Cursor;
import android.os.Bundle;

import android.widget.Toast;

import java.util.ArrayList;

public class AdGBcollection extends AppCompatActivity {

    RecyclerView recyclerView1;
    dhelper db;
    myadd add;
    ArrayList<String> hnumber, status, date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_gbcollection);

        db = new dhelper(this);
        hnumber = new ArrayList<>();
        status = new ArrayList<>();
        date = new ArrayList<>();
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview1);
        add = new myadd(this, hnumber, status, date);
        recyclerView1.setAdapter(add);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        displaydata();




    }

    private void displaydata() {
        Cursor cursor = db.getdata();
        if (cursor.getCount() == 0) {
            Toast.makeText(AdGBcollection.this, "No upload exists", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                hnumber.add(cursor.getString(0));
                status.add(cursor.getString(1));
                date.add(cursor.getString(2));

            }
        }
    }
}
