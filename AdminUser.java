package com.example.nyumbani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AdminUser extends AppCompatActivity {
    private EditText editText6;
    private EditText editText7;
    private TextView textView6;
    private Button button;
    private Button button3;

    DatabaseReference userdbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);
        editText6 = findViewById(R.id.editText6);
        button = findViewById(R.id.button);
        button3 = findViewById(R.id.button3);
        editText7 = findViewById(R.id.editText7);
        textView6 = findViewById(R.id.textView6);





        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent2);
            }
        });
    }
    private Boolean validateUsername(){
        String val = editText6.getText().toString();
        if (val.isEmpty()) {
          editText6.setError("Field cannot be empty");
            return false;
        } else {
            editText6.setError(null);
            return true;
        }
    }
    private Boolean validatepassword(){
        String val = editText7.getText().toString();
        if (val.isEmpty()) {
            editText7.setError("Field cannot be empty");
            return false;
        } else {
            editText7.setError(null);
            return true;
        }
    }
    public void loginUser(View view){
        if(!validateUsername() | !validatepassword()){
            return;
        }
        else{
            isUser();
        }
    }

    private void isUser() {


        String username = editText6.getText().toString();
        String password = editText7.getText().toString();

        if (username.equals("admin") && password.equals("Admin123!")) {
            Intent intent6 = new Intent(getApplicationContext(), Admin.class);
            startActivity(intent6);
        } else if (username.equals("sg") && password.equals("Sg123!")) {
            Intent intent5 = new Intent(getApplicationContext(), Contact.class);
            startActivity(intent5);
        } else {

             String userEnteredUsername = editText6.getText().toString().trim();
             String userEnteredPassword = editText7.getText().toString().trim();

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("USers");

            Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        editText6.setError(null);
                        String passwordfromdb = snapshot.child(userEnteredUsername).child("password").getValue(String.class);
                        if (userEnteredPassword.equals(passwordfromdb)) {
                            editText7.setError(null);
                            String namefromdb = snapshot.child(userEnteredUsername).child("name").getValue(String.class);
                            String emailfromdb = snapshot.child(userEnteredUsername).child("email").getValue(String.class);
                            String contactfromdb = snapshot.child(userEnteredUsername).child("contact").getValue(String.class);
                            String usernamefromdb = snapshot.child(userEnteredUsername).child("username").getValue(String.class);
                            String housenumberfromdb = snapshot.child(userEnteredUsername).child("housenumber").getValue(String.class);



                            Intent intent9 = new Intent(getApplicationContext(), Profile.class);

                            intent9.putExtra("name", namefromdb);
                            intent9.putExtra("email", emailfromdb);
                            intent9.putExtra("contact", contactfromdb);
                            intent9.putExtra("username", usernamefromdb);
                            intent9.putExtra("housenumber", housenumberfromdb);
                            intent9.putExtra("password", passwordfromdb);

                            startActivity(intent9);
                        }
                        else {
                            editText7.setError("Wrong Password");
                            editText7.requestFocus();
                        }

                    } else {
                        editText6.setError("No such User exists");
                        editText6.requestFocus();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }
}





