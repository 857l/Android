package com.example.myapplication.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Dialogs.DateDialog;
import com.example.myapplication.Dialogs.TimeDialog;
import com.example.myapplication.Dialogs.TitleDialog;
import com.example.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Date;

public class BottomSheetForTask extends BottomSheetDialogFragment implements TitleDialog.TimeDialogListener {

    public BottomSheetForTask(){
    }


    private TextView newTime;
    private TextView newDate;
    private TextView newTitle;

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
        timeDialog.show(getFragmentManager(), "time dialog");
    }

    private void openDialogForDate() {
        DateDialog dateDialog = new DateDialog();
        dateDialog.show(getFragmentManager(), "date dialog");
    }

    private void openDialogForTitle() {
        TitleDialog titleDialog = new TitleDialog();
        titleDialog.show(getFragmentManager(), "title dialog");
    }

    @Override
    public void sendText(String new_title) {
        newTitle.setText(new_title);
    }
}
