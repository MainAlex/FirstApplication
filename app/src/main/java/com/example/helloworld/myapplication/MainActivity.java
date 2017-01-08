package com.example.helloworld.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView taskList;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = (ListView) findViewById(R.id.TaskList);

        adapter = new ArrayAdapter<String>(taskList.getContext(), android.R.layout.simple_list_item_1);
        taskList.setAdapter(adapter);
        taskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openTask(view);
            }
        });
    }

    protected void addTaskBtnClick(View view) {

        adapter.add("New Task");

    }

    protected void openTask(View view) {

        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);

    }
}
