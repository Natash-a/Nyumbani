package com.example.nyumbani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {
 ListView ilistview;
 TextView txtview;

 ArrayList<String> iArraylist= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        txtview=findViewById(R.id.txtview);

        iArraylist.add("Upload Notices");
        iArraylist.add("Check Notices");
        iArraylist.add("Contacts");
        iArraylist.add("GB collection");
        ArrayAdapter<String> iArrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,iArraylist);
        ilistview=(ListView) findViewById(R.id.listview2);

        ilistview.setAdapter(iArrayAdapter);

        ilistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent20=new Intent(getApplicationContext(),Unotice.class);
                    startActivity(intent20);
                }else if(i==1){
                    Intent intent21=new Intent(getApplicationContext(),Notice.class);
                    startActivity(intent21);
                }else if(i==2){
                    Intent intent12=new Intent(getApplicationContext(),Contact.class);
                    startActivity(intent12);
                }else{
                    Intent intent22=new Intent(getApplicationContext(),AdGBcollection.class);
                    startActivity(intent22);
                }
            }
        });
    }

}