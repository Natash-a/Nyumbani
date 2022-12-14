package com.example.nyumbani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread splashScreenStarter = new Thread() {
            public void run () {
                try {
                    int delay = 0 ;
                    while (delay < 2000 ) {
                        sleep ( 150 ) ;
                        delay = delay + 100 ;
                    }
                    startActivity( new Intent(MainActivity.this, AdminUser. class )) ;

                } catch (InterruptedException e) {
                    e.printStackTrace() ;
                }finally {
                    finish() ;
                }
            }

        } ;
        splashScreenStarter.start() ;


    }
}