package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewTasks extends AppCompatActivity {
    private TextView textViewTask;
    private TextView textViewStep;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tasks);

        textViewTask = (TextView) findViewById(R.id.new_task);
        textViewStep = (TextView) findViewById(R.id.step1);

        button = (Button) findViewById(R.id.taskB);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                openDialog();
            }

        });




    }

    public void openDialog() {

    }
}