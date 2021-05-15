package com.example.myapplication.Dialogs;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.myapplication.R;
import com.example.myapplication.activities.DialogListener;

public class DateDialog extends AppCompatDialogFragment implements DialogListener.AllDialogListener.DateDialogListener {

    private CalendarView calendarView;

    public DialogListener.AllDialogListener.DateDialogListener dateDialogListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.date_dialog, null);

        builder.setView(view)
                .setTitle("Change Date")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                            @Override
                            public void onSelectedDayChange(@NonNull CalendarView view, final int year, final int month, final int dayOfMonth) {
                                String date = dayOfMonth + "-" + month + "-" + year;
                                dateDialogListener.sendDate(date);
                            }
                        });
                    }
                });

        calendarView = view.findViewById(R.id.calendar_new_date);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            dateDialogListener = (DialogListener.AllDialogListener.DateDialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "must implements TimeDialogListener");
        }
    }

    @Override
    public void sendDate(String new_date) {
    }
}
