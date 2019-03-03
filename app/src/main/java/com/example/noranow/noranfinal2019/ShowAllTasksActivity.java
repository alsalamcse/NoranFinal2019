package com.example.noranow.noranfinal2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.noranow.noranfinal2019.data.MyTask;
import com.example.noranow.noranfinal2019.data.TaskAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ShowAllTasksActivity extends AppCompatActivity {
    private  ListView lsvTasks;
    private  TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_tasks);
        lsvTasks=findViewById(R.id.lstvTask);
        taskAdapter=new TaskAdapter(getBaseContext(),R.layout.task_item);
        lsvTasks.setAdapter(taskAdapter);
        readTask();
    }
    private void readTask(){
        final ArrayList<MyTask>myTasks=new ArrayList<>();
        // reference to the database root

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
         databaseReference.child("MyTasks").addChildEventListener(new ValueEventListener(){


    }
}
