package com.example.myapplication.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.Dialogs.DateDialog;
import com.example.myapplication.Dialogs.TimeDialog;
import com.example.myapplication.Dialogs.TitleDialog;
import com.example.myapplication.R;
import com.example.myapplication.TodoItem;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BottomSheetForTask extends BottomSheetDialogFragment implements DialogListener.AllDialogListener.TitleDialogListener,
        DialogListener.AllDialogListener.DateDialogListener, DialogListener.AllDialogListener.TimeDialogListener {

    public BottomSheetForTask(){
    }

    public TextView newTime;
    public TextView newDate;
    public TextView newTitle;

    private Button changeTime;
    private Button changeDate;
    private Button changeTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_task_settings, container, false);

        newTime = view.findViewById(R.id.NewTime);
        newDate = view.findViewById(R.id.NewDate);
        newTitle = view.findViewById(R.id.NewTitle);

        Bundle bundle = this.getArguments();
        ArrayList<String> item = bundle.getStringArrayList("item");
        newDate.setText(item.get(1));
        newTitle.setText(item.get(0));
        newTime.setText("Set Text");

        changeTime = view.findViewById(R.id.ChangeTime);
        changeDate = view.findViewById(R.id.ChangeDate);
        changeTitle = view.findViewById(R.id.ChangeTitle);

        changeTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openDialogForTime();
            }
        });

        changeDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openDialogForDate();
            }
        });

        changeTitle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openDialogForTitle();
            }
        });

        return view;
    }

    private void openDialogForTime() {
        TimeDialog timeDialog = new TimeDialog();
        timeDialog.setTargetFragment(BottomSheetForTask.this, 1);
        timeDialog.show(getFragmentManager(), "time dialog");
    }

    private void openDialogForDate() {
        DialogFragment dateDialog = new DateDialog();
        dateDialog.setTargetFragment(BottomSheetForTask.this, 1);
        dateDialog.show(getFragmentManager(), "date dialog");
    }

    private void openDialogForTitle() {
        TitleDialog titleDialog = new TitleDialog();
        titleDialog.setTargetFragment(BottomSheetForTask.this, 1);
        titleDialog.show(getFragmentManager(), "title dialog");
    }

    @Override
    public void sendTitle(String new_title) {
        newTitle.setText(new_title);
        //newTodoItem.setHead(new_title);
    }

    @Override
    public void sendTime(String new_time) {
        newTime.setText(new_time);
    }

    @Override
    public void sendDate(String new_date) {
        newDate.setText(new_date);
        //newTodoItem.setDater(new_date);
    }

}
