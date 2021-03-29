package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.fragment.CalendarFragment;
import com.example.myapplication.fragment.SettingFragment;
import com.example.myapplication.fragment.TaskFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import adapters.TaskListAdapter;
import adapters.TasksAdapter;

public class MainActivity extends AppCompatActivity{

   /* ArrayList<TodoItem> todoItems = new ArrayList<>();

    public void initItems(){
        todoItems.add(new TodoItem(true, "blabla"));
        todoItems.add(new TodoItem(true, "bladddasdasdasdasdbasdla"));
        todoItems.add(new TodoItem(true, "blaasdasdbla"));
        todoItems.add(new TodoItem(true, "blasdasdasdabla"));
        todoItems.add(new TodoItem(true, "blddddabla"));
        todoItems.add(new TodoItem(true, "blaasdbla"));
        todoItems.add(new TodoItem(true, "blasdasdasdasdasdasdasdasdabla"));

    }
*/

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




        /*RecyclerView mainRecyclerView = findViewById(R.id.main_RecyclerView);
        mainRecyclerView.setAdapter(new TaskListAdapter(todoItems));

        initItems();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);


        mainRecyclerView.setLayoutManager(linearLayoutManager);

        FloatingActionButton actionButton = findViewById(R.id.floatingActionButton);*/

        /*actionButton.setOnClickListener(new View.OnClickListener{
            public
        });*/


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