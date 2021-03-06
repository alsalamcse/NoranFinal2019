package com.example.noranow.noranfinal2019;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.noranow.noranfinal2019.data.Baby;
import com.example.noranow.noranfinal2019.data.Doctor;
import com.example.noranow.noranfinal2019.data.MyTask;
import com.example.noranow.noranfinal2019.data.TaskAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;

public class AddBaby extends AppCompatActivity {
    private EditText edtNameBaby, edtWeight, edtLength,edtdate;
    private Button btnAddBaby,btnpickdate;
    private int mYear, mMonth, mDay;
    private long myDate;
    private Spinner Sp;
    private TaskAdapter taskAdapter2;
    private ArrayAdapter<String> adapter2;
    DatabaseReference reference;
    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_baby);
        edtLength = findViewById(R.id.edtLength);
        edtNameBaby = findViewById(R.id.edtNameBaby);
        edtWeight = findViewById(R.id.edtWeight);
        btnAddBaby = findViewById(R.id.btnAddBaby);
        edtdate=findViewById(R.id.edtdate);
        btnpickdate=findViewById(R.id.btnpickdate);

        btnAddBaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {dataHandler();

                //Intent i=new Intent(getApplicationContext(),CardActivity .class);

              //  startActivity(i);
            }
        });

       Spinner spinner=findViewById(R.id.Sp);
       //create an ArrayAdapter using the string array and a default spinner layout
       ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Doctor, android.R.layout.simple_spinner_item);
       //specify the layout to use when the list of choices appears
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       //apply the adapter to the spinner
        spinner.setAdapter(adapter);
      //  spinner.setOnItemSelectedListener(this);
        }




    private void dataHandler() {
        boolean isok = true;
        String name = edtNameBaby.getText().toString();
        String weight = edtWeight.getText().toString();
       // String date = edtdate.getText().toString();
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
      //  if (date.length() == 0) {
          // edtdate.setError("Date can not be empty");
            //isok = false;
       // }
        if (isok) {
            ///MyTask task = new MyTask();
            Baby baby = new Baby();
            baby.setDate(myDate);
            baby.setLenght(length);
            baby.setName(name);
            baby.setWeight(weight);


            //get user email to set is as the owner of this task
            FirebaseAuth auth = FirebaseAuth.getInstance();

// to get the database root reference
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

            //to get uid(universal id)
            String key = reference.child("Parent").push().getKey();
            baby.setKey(key);
String Email=auth.getCurrentUser().getEmail();
            reference.child("babys").child(Email.replace('.','*')).child(key).setValue(baby).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(AddBaby.this, "Add Successful", Toast.LENGTH_LONG).show();
                        Intent i=new Intent(getApplicationContext(),CardActivity .class);
                        startActivity(i);
                    } else {
                        Toast.makeText(AddBaby.this, "Add Faild"+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        task.getException().printStackTrace();
                    }
                }
            });
        }
    }
    public void onClick(View v) {

        if (v == btnpickdate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            c.set(Calendar.YEAR, year);
                            c.set(Calendar.MONTH,monthOfYear);
                            c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                            myDate=c.getTime().getTime();
                          edtdate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
    private void getDoctor() {
        reference = FirebaseDatabase.getInstance().getReference();
        String Email=auth.getCurrentUser().getEmail();

        reference.child("doctor").child(Email.replace('.','*')).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                taskAdapter2.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    Doctor doctor = d.getValue(Doctor.class);
                    taskAdapter2.add(doctor);
                }
                taskAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(AddBaby.this, "onCancelled", Toast.LENGTH_SHORT).show();

            }
        });
    }

}












