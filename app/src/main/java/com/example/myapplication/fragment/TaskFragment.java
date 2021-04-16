package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.activities.BottomSheetForTask;
import com.example.myapplication.R;
import com.example.myapplication.TodoItem;
import com.example.myapplication.activities.EditTaskView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import com.example.myapplication.adapters.TaskListAdapter;

import static android.app.Activity.RESULT_OK;

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
    TaskListAdapter adapter;
    TaskListAdapter.RecyclerViewClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_task, container, false);

        setOnClickListener();
        adapter = new TaskListAdapter(todoItems, listener);

        RecyclerView mainRecyclerView = (RecyclerView) view.findViewById(R.id.main_RecyclerView);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton);

        mainRecyclerView.setAdapter(adapter);

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

    private void setOnClickListener() {
        listener = new TaskListAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                BottomSheetForTask bottomSheetForTask = new BottomSheetForTask();
                bottomSheetForTask.show(getFragmentManager(), "TAG");
            }
        };
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 404){
            if (resultCode == RESULT_OK){
                if (data == null){
                    throw new IllegalStateException("data is null");
                }
                TodoItem todoItem = (TodoItem) data.getSerializableExtra("task");
                todoItems.add(todoItem);
                adapter.notifyDataSetChanged();
            }
        }
    }
}