package com.example.noranow.noranfinal2019;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.noranow.noranfinal2019.data.Baby;
import com.example.noranow.noranfinal2019.data.MyTask;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class AddBaby extends AppCompatActivity {
    private EditText edtNameBaby, edtDateBirth, edtWeight, edtLength;
    private Button btnSaveBaby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_baby);
        edtDateBirth = findViewById(R.id.edtDateBirth);
        edtLength = findViewById(R.id.edtLength);
        edtNameBaby = findViewById(R.id.edtNameBaby);
        edtWeight = findViewById(R.id.edtWeight);
        btnSaveBaby = findViewById(R.id.btnSaveBaby);

        btnSaveBaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });


    }

    private void dataHandler() {
        boolean isok = true;
        String name = edtNameBaby.getText().toString();
        String weight = edtWeight.getText().toString();
        String date = edtDateBirth.getText().toString();
        String length = edtLength.getText().toString();
        if (name.length() == 0) {
            edtNameBaby.setError("Name can not be empty");
            isok = false;

        }
        if (weight.length() == 0) {
            edtWeight.setError("Weight can not be empty");
            isok = false;

        }
        if (length.length() == 0) {
            edtLength.setError("Length can not be empty");
            isok = false;
        }
        if (date.length() == 0) {
            edtDateBirth.setError("Date can not be empty");
            isok = false;
        }
        if (isok) {
            MyTask task = new MyTask();
            Baby baby = new Baby();
            baby.setDate(new Date(date));
            baby.setLenght(length);
            baby.setName(name);
            baby.setWeight(weight);

            //get user email to set is as the owner of this task
            FirebaseAuth auth = FirebaseAuth.getInstance();
            task.setOwner(auth.getCurrentUser().getEmail());
// to get the database root reference
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

            //to get uid(universal id)
            String key = reference.child("MyTasks").push().getKey();
            task.setKey(key);

            reference.child("MyTasks").child(key).setValue(task).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(AddBaby.this, "Add Successful", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(AddBaby.this, "Add Faild", Toast.LENGTH_LONG).show();

                    }
                }
            });
        }
    }
}












