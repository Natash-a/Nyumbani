package com.example.nyumbani;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private EditText editTextTextPersonName;
    private Button button4;
    DatabaseReference userdbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        button4 = findViewById(R.id.button4);

        userdbref = FirebaseDatabase.getInstance().getReference().child("USers");

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ucontact=editText3.getText().toString();
                String uusername = editText4.getText().toString();
                String upassword = editText5.getText().toString();
                String hnumber = editText6.getText().toString();
                String Cpassword = editTextTextPersonName.getText().toString();


                if (TextUtils.isEmpty(uusername) && TextUtils.isEmpty(upassword) && TextUtils.isEmpty(hnumber)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(SignUp.this, "Please add some data.", Toast.LENGTH_SHORT).show();

                }else if (ucontact.length()>10){
                    editText3.setError("Invalid phonenumber");
                }
                else if (!upassword.equals(Cpassword)) {
                    Toast.makeText(SignUp.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    editTextTextPersonName.setError("Passwords do not match");
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase();

                }

            }
        });

    }
        private void addDatatoFirebase () {
            String name = editText.getText().toString();
            String email = editText2.getText().toString();
            String contact = editText3.getText().toString();
            String username = editText4.getText().toString();
            String password = editText5.getText().toString();
            String housenumber = editText6.getText().toString();

            userinfo Users = new userinfo(name, email, contact, username, password, housenumber);

            userdbref.child(username).setValue(Users);
            Toast.makeText(SignUp.this, "Profile created", Toast.LENGTH_SHORT).show();

            Intent intent7 = new Intent(getApplicationContext(),AdminUser.class);
            startActivity(intent7);


        }

    }


