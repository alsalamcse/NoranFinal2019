package com.example.noranow.noranfinal2019.dummy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.noranow.noranfinal2019.AddBaby;
import com.example.noranow.noranfinal2019.DocSignin;
import com.example.noranow.noranfinal2019.R;
import com.example.noranow.noranfinal2019.SignInActivity;

public class First extends AppCompatActivity {
    private Button docbtn, pbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        docbtn= findViewById(R.id.docbtn);
        pbtn= findViewById(R.id.pbtn);


        docbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),DocSignin.class);
                startActivity(i);
            }
        });


        pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SignInActivity.class);
                startActivity(i);
            }
        });
    }
}
