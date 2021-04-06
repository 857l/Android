package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.fragment.CalendarFragment;
import com.example.myapplication.fragment.SettingFragment;
import com.example.myapplication.fragment.TaskFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{

    Fragment taskFragment = new TaskFragment();
    Fragment calendarFragment = new CalendarFragment();
    Fragment settingFragment = new SettingFragment();

    Fragment current = taskFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_content, taskFragment, "task")
                .add(R.id.frame_content, calendarFragment, "calendar")
                .add(R.id.frame_content, settingFragment, "setting")
                .hide(calendarFragment)
                .hide(settingFragment)
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .show(current)
                .commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager manager = getSupportFragmentManager();

                switch (item.getItemId()){
                    case R.id.nav_tasks:
                        changeFragment(taskFragment);
                        return true;
                    case R.id.nav_sett:
                        changeFragment(settingFragment);
                        return true;
                    case R.id.nav_cal:
                        changeFragment(calendarFragment);
                        return true;

                }
                return false;
            }
        });

    }
    private void changeFragment(Fragment newFragment){
        getSupportFragmentManager()
                .beginTransaction()
                .hide(current)
                .show(newFragment)
                .commit();
        current = newFragment;
    }
}