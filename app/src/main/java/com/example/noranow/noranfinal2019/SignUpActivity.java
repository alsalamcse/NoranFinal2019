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

public class
SignUpActivity extends AppCompatActivity {
    FirebaseAuth auth;//to establish sign in sign up
    FirebaseUser user;//user

    private EditText edtfirst, edtLast,edtPhone,edtemail,edtpass,edtId;
    private Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtemail=(EditText)findViewById(R.id .edtemail) ;
        edtfirst=(EditText)findViewById(R.id .edtfirst) ;
        edtLast =(EditText)findViewById(R.id .edtLast) ;
        edtpass=(EditText)findViewById(R.id .edtpass) ;
        edtPhone=(EditText)findViewById(R.id.edtPhone);
        edtId=findViewById(R.id.edtId);
        btnsave=(Button)findViewById(R.id.btnsave);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();//

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
        String lastname=edtLast.getText().toString();
        String id = edtId.getText().toString();
        // String date = edtdate.getText().toString();
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
            if(pass.length()<8)
            {
                edtpass.setError("Have to be at least 8 char");
                isok=false;
            }
            if(isok)
            {
                creatAcount(email,pass);
            }

            if (isok) {
                ///MyTask task = new MyTask();
                Parent parent = new Parent();
                parent.setEmail(email);
                parent.setId(id);
                parent.setName(name);
                parent.setPhone(phone);



    }

    //4.

    /**
     *create firebase user using email and password
     * @param email user eamil
     * @param passw user password
     */
    private void creatAcount(String email, String pass) {
        auth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignUpActivity.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                            //updateUserProfile(task.getResult().getUser());
                            finish();
                        }
                        else
                        {
                            Toast.makeText(SignUpActivity.this, "Authentication failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            task.getException().printStackTrace();
                        }
                    }
                });
    }

}


