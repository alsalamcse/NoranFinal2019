package com.example.noranow.noranfinal2019;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.noranow.noranfinal2019.data.Baby;
import com.example.noranow.noranfinal2019.data.TaskAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CardActivity extends AppCompatActivity {
    private TextView tvcard;
    private FloatingActionButton fabadd;
    private ListView listview1;
    private TaskAdapter taskAdapter;
    private ArrayAdapter<String> adapter;
    DatabaseReference reference;
    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        listview1 = findViewById(R.id.listview1);
        tvcard = findViewById(R.id.tvcard);
        taskAdapter = new TaskAdapter(getApplicationContext(), R.layout.task_item);
        listview1.setAdapter(taskAdapter);
        fabadd = findViewById(R.id.fabadd);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        getMyBaby();
        reference=FirebaseDatabase.getInstance().getReference();
        reference.child("Parent").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot d:dataSnapshot.getChildren()){
                    String id=dataSnapshot.child("Parent").getKey();
                    String userId=user.getUid().toString();
                    if (id.contains(userId)){
                        Baby baby=new Baby();
                       taskAdapter.add(baby);



                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddBaby.class);
                startActivity(i);
            }
        });
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(CardActivity.this,ChecksForThisMonth.class);
                startActivity(i);
            }
        });


    }



    private void getMyBaby() {
       reference = FirebaseDatabase.getInstance().getReference();
        reference.child("Parent").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                taskAdapter.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    Baby b = d.getValue(Baby.class);
                    taskAdapter.add(b);
                }
                taskAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(CardActivity.this, "onCancelled", Toast.LENGTH_SHORT).show();

            }
        });
    }




    }
