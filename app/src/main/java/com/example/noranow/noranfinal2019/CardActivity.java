package com.example.noranow.noranfinal2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.noranow.noranfinal2019.data.MyTask;
import com.example.noranow.noranfinal2019.data.TaskAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CardActivity extends AppCompatActivity {
    private TextView tvcard;
private FloatingActionButton fabadd;
private ListView listV;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        listV = findViewById(R.id.listV);
        tvcard = findViewById(R.id.tvcard);
        taskAdapter = new TaskAdapter(getBaseContext(), R.layout.task_item);
        listV.setAdapter(taskAdapter);
        readTask();
        fabadd = findViewById(R.id.fabadd);
        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), AddBaby.class);
                startActivity(i);
            }
        });
    }
    private void readTask() {
        // reference to the database root
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("MyTasks").addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(getBaseContext(), "data changed", Toast.LENGTH_SHORT).show();
                taskAdapter.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    MyTask task = d.getValue(MyTask.class);
                    taskAdapter.add(task);
                }
                taskAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getBaseContext(), "onCancelled", Toast.LENGTH_SHORT).show();
            }
        });

        }
    }
