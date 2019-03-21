package com.example.noranow.noranfinal2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.noranow.noranfinal2019.data.Baby;
import com.example.noranow.noranfinal2019.data.Parent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ParentAdd extends AppCompatActivity {
    private EditText edtPname, edtEmail, edtPhone, edtID;
    private Button btnAddP;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_add);
        edtEmail = findViewById(R.id.edtEmail);
        edtPname = findViewById(R.id.edtPname);
        edtID = findViewById(R.id.edtID);
        edtPhone = findViewById(R.id.edtPhone);
        btnAddP = findViewById(R.id.btnAddP);

        btnAddP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();

                Intent i = new Intent(getApplicationContext(), CardActivity.class);
                startActivity(i);
            }
        });


    }



    private void dataHandler() {
        boolean isok = true;
        String name = edtPname.getText().toString();
        String id = edtID.getText().toString();
        // String date = edtdate.getText().toString();
        String phone = edtPhone.getText().toString();
        String email = edtEmail.getText().toString();
        if (name.length() == 0) {
            edtPname.setError("Name can not be empty");
            isok = false;

        }
        if (id.length() == 0) {
            edtID.setError("Id can not be empty");
            isok = false;

        }
        if (phone.length() == 0) {
            edtPhone.setError("Phone can not be empty");
            isok = false;
        }
        if (email.length() < 4 ||
                email.indexOf('@') < 0 ||
                email.indexOf('.') < 0) {
            edtEmail.setError("Wrong Eamil");
            isok = false;

            if (isok) {
                ///MyTask task = new MyTask();
                Parent parent = new Parent();
                parent.setEmail(email);
                parent.setId(id);
                parent.setName(name);
                parent.setPhone(phone);


                //get user email to set is as the owner of this task
                FirebaseAuth auth = FirebaseAuth.getInstance();

// to get the database root reference
                reference = FirebaseDatabase.getInstance().getReference();

                //to get uid(universal id)
                String key = reference.child("Parent").push().getKey();
                parent.setKey(key);

                reference.child("Parent").child(key).setValue(parent).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(ParentAdd.this, "Add Successful", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ParentAdd.this, "Add Faild"+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            task.getException().printStackTrace();
                        }
                    }
                });
            }
        }

            }
        }

