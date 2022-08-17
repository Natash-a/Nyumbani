package com.example.nyumbani;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Contact extends AppCompatActivity {
    ListView  mylistview;
    SearchView searchview;

    ArrayList<String> myArraylist=new ArrayList<>();
    DatabaseReference mRef;
    ArrayAdapter<String> myArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        searchview=(SearchView) findViewById(R.id.search_bar);
        mylistview=(ListView)findViewById(R.id.listview1);
       myArrayAdapter=new ArrayAdapter<String>(Contact.this, android.R.layout.simple_list_item_1,myArraylist);
        mylistview.setAdapter(myArrayAdapter);
        mRef= FirebaseDatabase.getInstance().getReference("USers");

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String c_housenumber=snapshot.child("housenumber").getValue(String.class);
                String c_contact=snapshot.child("contact").getValue(String.class);
                myArraylist.add("House number:" +" "+ c_housenumber +"\n" +"Contact:"+" "+ c_contact);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                myArrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myArrayAdapter.getFilter().filter(newText);

                return false;
            }
        });

    }

}