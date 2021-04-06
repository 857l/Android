package com.example.myapplication.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.TodoItem;

import java.util.Date;

import models.ClassTask;

public class EditTaskView extends AppCompatActivity {
    Button saveButton;
    TextView textView;
    EditText editText;
    CalendarView calendarView;
    String date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        saveButton = findViewById(R.id.button_save);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.NameOfTask);

        calendarView = findViewById(R.id.calendarView);

        try {
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

                @Override
                public void onSelectedDayChange(CalendarView view, int year,
                                                int month, int dayOfMonth) {
                    int mYear = year;
                    int mMonth = month;
                    int mDay = dayOfMonth;
                    String selectedDate = new StringBuilder().append(mMonth + 1)
                            .append("-").append(mDay).append("-").append(mYear)
                            .append(" ").toString();
                    date = selectedDate;
                }
            });
            }catch(Exception ex){
            Log.d("log_tag",ex.getMessage());
        }

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TodoItem todoItem = new TodoItem(true, editText.getText().toString(), date);

                if(editText.getContext().toString().isEmpty()){
                    Toast.makeText(v.getContext(), "Input name of task", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent();
                    intent.putExtra("task", todoItem);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });


    }
}

