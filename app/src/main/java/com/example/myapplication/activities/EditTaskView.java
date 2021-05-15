package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.TodoItem;

import java.util.ArrayList;

public class EditTaskView extends AppCompatActivity {
    Button saveButton;
    TextView textView;
    EditText editText;
    CalendarView calendarView;
    String date;

    public static ArrayList<TodoItem>save_todoItems;
    public static final String SHARED_PREFS = "sharedPrefs";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        saveButton = findViewById(R.id.button_save);
        editText = findViewById(R.id.NameOfTask);

        calendarView = findViewById(R.id.CreatingCalendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                int mYear = year;
                int mMonth = month;
                int mDay = dayOfMonth;
                dayIs(mYear, mMonth, mDay);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TodoItem todoItem = new TodoItem(true, editText.getText().toString(), date);
                Intent intent = new Intent();

                intent.putExtra("task", todoItem);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void dayIs(int mYear, int mMonth, int mDay){
        String selectedDate;
        if (mDay / 10 == 0){
            selectedDate = new StringBuilder().append("0").append(mDay)
                    .append(".").append(mMonth + 1).append(".").append(mYear)
                    .append(" ").toString();
            date = selectedDate;
            if (mMonth / 10 == 0){
                selectedDate = new StringBuilder().append("0").append(mDay)
                        .append(".").append("0").append(mMonth + 1).append(".").append(mYear)
                        .append(" ").toString();
                date = selectedDate;
            }
        }
        else if (mMonth / 10 == 0){
            selectedDate = new StringBuilder().append(mDay)
                    .append(".").append("0").append(mMonth + 1).append(".").append(mYear)
                    .append(" ").toString();
            date = selectedDate;
        }
        else{
            selectedDate = new StringBuilder().append(mDay)
                    .append(".").append(mMonth + 1).append(".").append(mYear)
                    .append(" ").toString();
            date = selectedDate;
        }
    }
}

