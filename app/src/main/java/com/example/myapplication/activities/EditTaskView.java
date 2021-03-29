package com.example.myapplication.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.Date;

import models.ClassTask;

public class EditTaskView extends AppCompatActivity {
    Button savebutton;
    ImageView image;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        savebutton = findViewById(R.id.save_button);
        image = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        savebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ClassTask task = new ClassTask(textView.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("task", (Parcelable) task);
                setResult(RESULT_OK, intent);

                finish();

            }
        });

    }
}
