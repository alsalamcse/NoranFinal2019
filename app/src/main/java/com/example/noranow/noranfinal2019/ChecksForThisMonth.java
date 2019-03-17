package com.example.noranow.noranfinal2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class ChecksForThisMonth extends AppCompatActivity {
    private EditText edtname;
    private TextView tvcheck;
    private CheckBox checkBox,checkBox3,checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checks_for_this_month);
        edtname=findViewById(R.id.edtPname);
        tvcheck=findViewById(R.id.tvcheck);
        checkBox=findViewById(R.id.checkBox);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
    }
}
