package com.example.nyumbani;

import static com.example.nyumbani.Home.closeDrawer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GBcollection extends AppCompatActivity {

    FloatingActionButton fab3;
    DrawerLayout drawerLayout;
    AlertDialog dialog;
    dhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gbcollection);


        drawerLayout=findViewById(R.id.drawer_layout);
        fab3=findViewById(R.id.fab3);

        db=new dhelper(this);



                fab3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        AlertDialog.Builder builder=new AlertDialog.Builder(GBcollection.this);
                        builder.setTitle("Garbage Bag collection confirmation");
                        View v=getLayoutInflater().inflate(R.layout.custom_dialog, null);
        EditText hse=v.findViewById(R.id.hse);
        Button submit=v.findViewById(R.id.submit);
        Button cancel=v.findViewById(R.id.cancel);
        EditText cl= v.findViewById(R.id.cl);
        EditText dt=v.findViewById(R.id.dt);

        submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String house=hse.getText().toString();
               String Col=cl.getText().toString();
                String dte=dt.getText().toString();
               Boolean checkinsertdata= db.insertdata(house,Col,dte);
               if(checkinsertdata==true)
               {
                   Toast.makeText(GBcollection.this," Uploaded",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(GBcollection.this,"Upload failed",Toast.LENGTH_SHORT).show();
               }



           dialog.dismiss();

           }
       });

        builder.setView(v);
        dialog= builder.create();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            dialog.cancel();
            }
        });
                        dialog.show();
    }
});
    }

    public void ClickMenu(View view){
        Home.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        Home.redirectActivity(this,Home.class);
    }
    public void ClickGB(View view){
        recreate();
    }
    public void ClickNotice(View view){
        Home.redirectActivity(this,Notice.class);
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