package com.example.myapplication.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.myapplication.R;

import java.util.Date;

public class TimeDialog extends AppCompatDialogFragment {

    private TimePicker timePicker;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.time_dialog, null);

        builder.setView(view)
                .setTitle("Change Time")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*String new_time = new StringBuilder()
                                .append(timePicker.getCurrentHour())
                                .append(":")
                                .append(timePicker.getCurrentMinute())
                                .toString();
                        listener.applyData("new_time");*/
                    }
                });

        timePicker = view.findViewById(R.id.myTimePicker);

        return builder.create();
    }
}
