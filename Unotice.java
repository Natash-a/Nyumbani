package com.example.nyumbani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Unotice extends AppCompatActivity {

    EditText editTextTextPersonName2;
    EditText editTextTextPersonName3;
    EditText getEditTextTextPersonName5;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unotice);

        EditText title=findViewById(R.id.editTextTextPersonName2);
        EditText desc=findViewById(R.id.editTextTextPersonName3);
        TextView date=findViewById(R.id.editTextTextPersonName5);

        DB= new DBHelper(this);


        FloatingActionButton fab = findViewById(R.id.fab);
        FloatingActionButton fab1=findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title=title.getText().toString();
                String Desc= desc.getText().toString();
                String Date=date.getText().toString();

                Boolean checkinsertdata= DB.insertdata(Title,Desc,Date);
                if(checkinsertdata==true)
                {
                    Toast.makeText(Unotice.this,"Notice uploaded",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Unotice.this,"Upload failed",Toast.LENGTH_SHORT).show();
                }
                Intent intent19=new Intent(getApplicationContext(),Admin.class);
                startActivity(intent19);

            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title=title.getText().toString();

                Boolean checkdeletedata  = DB.deleteuserdata(Title);
                if(checkdeletedata==true)
                {
                    Toast.makeText(Unotice.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Unotice.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}