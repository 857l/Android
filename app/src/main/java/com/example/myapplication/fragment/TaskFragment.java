package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.TodoItem;
import com.example.myapplication.activities.EditTaskView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import adapters.TaskListAdapter;

public class TaskFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TaskFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TaskFragment newInstance(String param1, String param2) {
        TaskFragment fragment = new TaskFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ArrayList<TodoItem> todoItems = new ArrayList<>();

    /*public void initItems(){
        todoItems.add(new TodoItem(true, "Классное задание", "01.01.2048"));
        todoItems.add(new TodoItem(true, "Сходить в магаз", "29.23.2021"));
        todoItems.add(new TodoItem(true, "Почитать книжку", "15.03.2022"));
        todoItems.add(new TodoItem(true, "Завести собаку", "17.08.2023"));
        todoItems.add(new TodoItem(true, "Поступить в универ", "01.05.2024"));
        todoItems.add(new TodoItem(true, "Сделать дз по инфе", "45.13.2150"));

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_task, container, false);

        RecyclerView mainRecyclerView = (RecyclerView) view.findViewById(R.id.main_RecyclerView);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton);

        mainRecyclerView.setAdapter(new TaskListAdapter(todoItems));

        //initItems();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        mainRecyclerView.setLayoutManager(linearLayoutManager);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditTaskView.class);
                startActivityForResult(intent, 404);
            }
        });

        return view;
    }
}