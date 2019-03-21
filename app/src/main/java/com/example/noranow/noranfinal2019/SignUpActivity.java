package com.example.noranow.noranfinal2019;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.noranow.noranfinal2019.data.Parent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class
SignUpActivity extends AppCompatActivity {
    FirebaseAuth auth;//to establish sign in sign up
    FirebaseUser user;//user
    DatabaseReference databaseReference;

    private EditText edtfirst, edtLast, edtPhone, edtemail, edtpass, edtId;
    private Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtemail = (EditText) findViewById(R.id.edtemail);
        edtfirst = (EditText) findViewById(R.id.edtfirst);
        edtLast = (EditText) findViewById(R.id.edtLast);
        edtpass = (EditText) findViewById(R.id.edtpass);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtId = findViewById(R.id.edtId);
        btnsave = (Button) findViewById(R.id.btnsave);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();//
        databaseReference=FirebaseDatabase.getInstance().getReference();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }


    /**
     * get email and passwor from the field and try to create new user
     */
    private void dataHandler() {
        boolean isok = true;
        String name = edtfirst.getText().toString();
        String lastname = edtLast.getText().toString();
        String id = edtId.getText().toString();
        String phone = edtPhone.getText().toString();
        String email = edtemail.getText().toString();
        String pass = edtpass.getText().toString();

        if (name.length() == 0) {
            edtfirst.setError("Name can not be empty");
            isok = false;

        }
        if (lastname.length() == 0) {
            edtLast.setError("Last name can not be empty");
            isok = false;

        }
        if (id.length() == 0) {
            edtId.setError("Id can not be empty");
            isok = false;

        }
        if (phone.length() == 0) {
            edtPhone.setError("Phone can not be empty");
            isok = false;
        }
        if (email.length() < 4 ||
                email.indexOf('@') < 0 ||
                email.indexOf('.') < 0) {
            edtemail.setError("Wrong Eamil");
            isok = false;
        }
        if (pass.length() < 8) {
            edtpass.setError("Have to be at least 8 char");
            isok = false;
        }
        if (isok) {
            creatAcount(email, pass);
        }

        if (isok) {
            ///MyTask task = new MyTask();
            Parent parent = new Parent();
            parent.setEmail(email);
            parent.setId(id);
            parent.setName(name);
            parent.setPhone(phone);


              /// FirebaseAuth auth = FirebaseAuth.getInstance();

// to get the database root reference
            /////DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

            //to get uid(universal id)
            /////String key = reference.child("Parent").push().getKey();
            ///  parent.setKey(key);

            ////reference.child("Parent").child(key).setValue(parent).addOnCompleteListener(new OnCompleteListener<Void>() {
            ////@Override
            //////public void onComplete(@NonNull Task<Void> task) {
            /////if (task.isSuccessful()) {
            /////Toast.makeText(SignUpActivity.this, "Add Successful", Toast.LENGTH_LONG).show();
            ////} else {
            //////Toast.makeText(SignUpActivity.this, "Add Faild"+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
            ////task.getException().printStackTrace();
            //}
            //}
            //});
            //}

            //4.

            /**
             *create firebase user using email and password
             * @param email user eamil
             * @param passw user password
             *///}



            }

        }


    private void creatAcount(final String email, String pass) {
        final String Firstname=edtfirst.getText().toString();
        final String Lastname=edtLast.getText().toString();
                final String id=auth.getUid();
        auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            HashMap<String,String> hashMap=new HashMap<>();
                            hashMap.put("First name",Firstname);
                            hashMap.put("Last name",Lastname);
                            hashMap.put("Email",email);
                            databaseReference.child("Parent").child(id).setValue(hashMap);
                            Toast.makeText(SignUpActivity.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                            //updateUserProfile(task.getResult().getUser());
                            finish();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Authentication failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            task.getException().printStackTrace();
                        }
                    }
                });


    }
}





