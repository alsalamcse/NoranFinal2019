package com.example.noranow.noranfinal2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.noranow.noranfinal2019.data.Doctor;
import com.example.noranow.noranfinal2019.data.Parent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DocSignup extends AppCompatActivity {
    private EditText edtdname,edtdnum,edtdid;
    private Button btndSave;
    FirebaseAuth auth;//to establish sign in sign up
    FirebaseUser user;//user
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_signup);
        edtdname=findViewById(R.id.edtdname);
        edtdnum=findViewById(R.id.edtdnum);
        edtdid=findViewById(R.id.edtdid);
        btndSave=findViewById(R.id.btndSave);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();//
        databaseReference=FirebaseDatabase.getInstance().getReference();
        FirebaseAuth auth;//to establish sign in sign up
        FirebaseUser user;//user
        DatabaseReference databaseReference;

        btndSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }
    private void dataHandler() {
        boolean isok = true;
        String name = edtdname.getText().toString();
        String id = edtdid.getText().toString();
        String licensenumber = edtdnum.getText().toString();


        if (name.length() == 0) {
            edtdname.setError("Name can not be empty");
            isok = false;

        }

        if (id.length() == 0) {
            edtdid.setError("Id can not be empty");
            isok = false;

        }
        if (licensenumber.length() == 0) {
            edtdnum.setError("license number can not be empty");
            isok = false;
        }

        if (isok) {
            creatAcount(name, licensenumber);
        }

        if (isok) {


            /**
             *create firebase user using name and license number
             * @param name user name
             * @param licensenumber user license number
             *///}


        }
    }
        private void creatAcount(final String name, String licensenumber) {
            final String doctorname=edtdnum.getText().toString();

            auth.createUserWithEmailAndPassword(name, licensenumber)
                    .addOnCompleteListener(DocSignup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String name = edtdnum.getText().toString();

                                String id = edtdid.getText().toString();
                                String licensenumber = edtdnum.getText().toString();


                               Doctor doctor = new Doctor();
                                doctor.setId(id);
                                doctor.setName(name);
                                doctor.setLicense(licensenumber);
                                FirebaseAuth auth = FirebaseAuth.getInstance();

// to get the database root reference
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

                                //to get uid(universal id)
                                String key = reference.child("Doctor").push().getKey();
                                doctor.setKey(key);

                                reference.child("Doctor").child(key).setValue(doctor).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), "Add Successful", Toast.LENGTH_LONG).show();
                                            Intent i=new Intent(getApplicationContext(),DocList .class);
                                            startActivity(i);
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Add Faild"+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                            task.getException().printStackTrace();
                                        }
                                    }
                                });
                                Toast.makeText(DocSignup.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                                //updateUserProfile(task.getResult().getUser());
                                finish();
                            } else {
                                Toast.makeText(DocSignup.this, "Authentication failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                task.getException().printStackTrace();
                            }
                        }
                    });


        }


    }


