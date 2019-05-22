package com.example.noranow.noranfinal2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChecksForThisMonth extends AppCompatActivity {

    private TextView tvcheck,tvBabyName,tvw,tvl;

    private CheckBox checkBox,checkBox3,checkBox2;
    private Button btnsave3;
    FirebaseAuth auth;//to establish sign in sign up
    FirebaseUser user;//user
    DatabaseReference reference1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checks_for_this_month);
        tvBabyName=findViewById(R.id.tvBabyName);
        tvcheck=findViewById(R.id.tvcheck);
        checkBox=findViewById(R.id.checkBox);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        btnsave3=findViewById(R.id.btnsave3);
       tvl=findViewById(R.id.tvl);
       tvw=findViewById(R.id.tvw);
        String BabyName= getIntent().getStringExtra("BabyName");
     //   DatabaseReference Check = reference1.child("checks");
       // Check.setValue(checkBox.isChecked());
        //Check.setValue(checkBox2.isChecked());
        //Check.setValue(checkBox3.isChecked());
        tvBabyName.setText(BabyName);
        btnsave3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(), CardActivity.class);
                startActivity(i);
            }
        });
    }
  //  private void getMyChecks()
    //{

    //}
}
