package com.example.noranow.noranfinal2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DocSignin extends AppCompatActivity {
    private Button btndin,btndup;
    private EditText edtdemail,edtdpass;
    FirebaseAuth auth;//to establish sign in sign up
    FirebaseUser user;//user


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_signin);
        btndin=findViewById(R.id.btndin);
        btndup=findViewById(R.id.btndup);
        edtdpass=findViewById(R.id.edtdpass);
        edtdemail=findViewById(R.id.edtdemail);

       btndup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(), DocSignup.class);
                startActivity(i);
            }
        });
        btndin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }

    private void dataHandler()
    {
        String email=edtdemail.getText().toString();
        String passw=edtdpass.getText().toString();
        signIn(email,passw);
    }


    private void signIn(String email, String passw) {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(DocSignin.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(DocSignin.this,DocList.class);
                    startActivity(intent);
                    //  finish();
                }
                else
                {
                    Toast.makeText(DocSignin.this, "signIn failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

}


