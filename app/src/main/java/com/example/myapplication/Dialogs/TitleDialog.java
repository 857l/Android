package com.example.myapplication.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.myapplication.R;
import com.example.myapplication.activities.DialogListener;

public class TitleDialog extends AppCompatDialogFragment implements DialogListener.AllDialogListener.TitleDialogListener {

    private EditText editText;

    public DialogListener.AllDialogListener.TitleDialogListener titleDialogListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.title_dialog, null);

        builder.setView(view)
                .setTitle("Change Title")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String new_title = editText.getText().toString();

                        titleDialogListener.sendTitle(new_title);
                    }
                });

        editText = view.findViewById(R.id.edit_new_title);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            titleDialogListener = (DialogListener.AllDialogListener.TitleDialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "must implements TitleDialogListener");
        }
    }

    @Override
    public void sendTitle(String new_Title) {
    }
}
