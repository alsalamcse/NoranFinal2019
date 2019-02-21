package com.example.noranow.noranfinal2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.noranow.noranfinal2019.CardActivity;
import com.example.noranow.noranfinal2019.R;

public class BabyCard extends AppCompatActivity {
    private EditText edtname, edtdate, edtlength, edtweight;
    private Button btnS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_card);
        edtdate=findViewById(R.id.edtdate);
        edtlength=findViewById(R.id.edtlength);
        edtname=findViewById(R.id.edtname);
        edtweight=findViewById(R.id.edtweight);
        btnS=findViewById(R.id.btnS);

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), CardActivity.class);
                startActivity(i);
            }
        });
    }
}
