package com.example.myapplication.activities;

public class DialogListener {
    public interface AllDialogListener{
        public interface TitleDialogListener{
            public void sendTitle(String new_title);
        }

        public interface TimeDialogListener{
            public void sendTime(String new_time);
        }

        public interface DateDialogListener{
            public void sendDate(String new_date);
        }
    }
}
