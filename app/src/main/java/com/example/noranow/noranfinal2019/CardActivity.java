package com.example.noranow.noranfinal2019;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class CardActivity extends AppCompatActivity {
    private TextView tvcard;
private FloatingActionButton fabadd;
private ListView listV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        tvcard=findViewById(R.id.tvcard);
        fabadd=findViewById(R.id.fabadd);
        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), AddBaby.class);
                startActivity(i);
            }
        });
    }
}
