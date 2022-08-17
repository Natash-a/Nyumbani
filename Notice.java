package com.example.nyumbani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Notice extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> title,desc,date;
    DBHelper DB;
    MyAdapter adapter;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        drawerLayout=findViewById(R.id.drawer_layout);

        DB=new DBHelper(this);
        title=new ArrayList<>();
        desc=new ArrayList<>();
        date=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        adapter=new MyAdapter(this, title, desc, date);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata() {
        Cursor cursor= DB.getdata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(Notice.this,"No notice exists",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
               title.add(cursor.getString(0));
               desc.add(cursor.getString(1));
               date.add(cursor.getString(2));

            }
        }
    }

    public void ClickMenu(View view){
        Home.openDrawer(drawerLayout);
 }
 public void ClickLogo(View view){
     Home.closeDrawer(drawerLayout);
 }
 public void ClickHome(View view){
        Home.redirectActivity(this,Home.class);
 }
    public void ClickNotice(View view){
     recreate();
    }
    public void ClickGB(View view){
        Home.redirectActivity(this,GBcollection.class);
    }
    public void ClickProfile(View view){
        Home.redirectActivity(this,Profile.class);
    }
    public void ClickLogout(View view){
        Home.logout(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        Home.closeDrawer(drawerLayout);
    }
}