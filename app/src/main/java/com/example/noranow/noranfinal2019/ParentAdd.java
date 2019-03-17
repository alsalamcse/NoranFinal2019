package com.example.noranow.noranfinal2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ParentAdd extends AppCompatActivity {
    private EditText edtPname,edtEmail,edtPhone,edtID;
    private Button btnAddP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_add);
        edtEmail=findViewById(R.id.edtEmail);
        edtPname=findViewById(R.id.edtPname);
        edtID=findViewById(R.id.edtID);
        edtPhone=findViewById(R.id.edtPhone);
        btnAddP=findViewById(R.id.btnAddP);

        btnAddP.setOnClickListener(View);
    }
}
