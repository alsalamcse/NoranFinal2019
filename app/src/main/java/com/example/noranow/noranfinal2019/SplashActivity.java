package com.example.noranow.noranfinal2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.noranow.noranfinal2019.R;
import com.example.noranow.noranfinal2019.SignInActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
    protected void onResume() {
        MyThread myThread=new MyThread();
        myThread.start();
        super.onResume();
    }
    public  class MyThread extends Thread
    {
        @Override
        public void run() {

            try {
                sleep(3000);
                Intent i=new Intent(getApplicationContext(),SignInActivity.class);
                startActivity(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


