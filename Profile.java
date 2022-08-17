package com.example.nyumbani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity {

    TextInputLayout fullname,email,contact,username,password,housenumber;
   TextView fullnamelabel,usernamelabel;
   String _USERNAME,_NAME,_PASSWORD,_CONTACT,_EMAIL,_HOUSENUMBER;
   DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ref= FirebaseDatabase.getInstance().getReference("USers");

        fullname=findViewById(R.id.fullname_profile);
        email=findViewById(R.id.email_profile);
        contact=findViewById(R.id.contact_profile);
        username=findViewById(R.id.username_profile);
        password=findViewById(R.id.password_profile);
        housenumber=findViewById(R.id.housenumber_profile);
        fullnamelabel=findViewById(R.id.full_name);
        usernamelabel=findViewById(R.id.user_name);
        showAllUserData();



    }

    private void showAllUserData() {
        Intent intent9=getIntent();
      _NAME=intent9.getStringExtra("name");
         _USERNAME=intent9.getStringExtra("username");
      _EMAIL=intent9.getStringExtra("email");
         _CONTACT=intent9.getStringExtra("contact");
         _PASSWORD=intent9.getStringExtra("password");
        _HOUSENUMBER=intent9.getStringExtra("housenumber");


        fullnamelabel.setText(_NAME);
        usernamelabel.setText(_USERNAME);
        fullname.getEditText().setText(_NAME);
        username.getEditText().setText(_USERNAME);
        password.getEditText().setText(_PASSWORD);
        housenumber.getEditText().setText(_HOUSENUMBER);
        email.getEditText().setText(_EMAIL);
        contact.getEditText().setText(_CONTACT);

    }
    public void update(View view){
        if(isNameChanged() || isPasswordChanged() || isContactChanged() || isHousenumberChanged() || isEmailChanged() || isUserNameChanged()){
            Toast.makeText(this,"Data has been updated",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Data is the same and can not be updated",Toast.LENGTH_SHORT).show();
        }
    }
    private boolean isContactChanged() {
        if (!_CONTACT.equals(contact.getEditText().getText().toString())) {

            ref.child(_CONTACT).child("contact").setValue(contact.getEditText().getText().toString());
            _CONTACT=contact.getEditText().getText().toString();
            return true;
        }
        else {
            return false;
        }

    }
    private boolean isHousenumberChanged() {
        if (!_HOUSENUMBER.equals(housenumber.getEditText().getText().toString())) {

            ref.child(_HOUSENUMBER).child("housenumber").setValue(housenumber.getEditText().getText().toString());
            _HOUSENUMBER=housenumber.getEditText().getText().toString();
            return true;
        }
        else {
            return false;
        }

    }
    private boolean isEmailChanged() {
        if (!_EMAIL.equals(email.getEditText().getText().toString())) {

            ref.child(_EMAIL).child("email").setValue(email.getEditText().getText().toString());
            _EMAIL=email.getEditText().getText().toString();
            return true;
        }
        else {
            return false;
        }

    }
    private boolean isUserNameChanged() {
        if (!_USERNAME.equals(username.getEditText().getText().toString())) {

            ref.child(_USERNAME).child("username").setValue(username.getEditText().getText().toString());
            _USERNAME=username.getEditText().getText().toString();
            usernamelabel.setText(_USERNAME);
            return true;
        }
        else {
            return false;
        }

    }




    private boolean isPasswordChanged() {
        if (!_PASSWORD.equals(password.getEditText().getText().toString())) {

            ref.child(_PASSWORD).child("password").setValue(password.getEditText().getText().toString());
           _PASSWORD=password.getEditText().getText().toString();
            return true;
        }
        else {
            return false;
        }

    }

    private boolean isNameChanged() {
        if (!_NAME.equals(fullname.getEditText().getText().toString())) {

            ref.child(_NAME).child("name").setValue(fullname.getEditText().getText().toString());
           _NAME=fullname.getEditText().getText().toString();
           fullnamelabel.setText(_NAME);
            return true;
        } else {
            return false;
        }
    }
    public void back(View view){
        Intent intent11=new Intent(getApplicationContext(),Home.class);
        startActivity(intent11);
    }
}
