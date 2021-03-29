package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.TodoItem;

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

    public void initItems(){
        todoItems.add(new TodoItem(true, "blabla"));
        todoItems.add(new TodoItem(true, "bladddasdasdasdasdbasdla"));
        todoItems.add(new TodoItem(true, "blaasdasdbla"));
        todoItems.add(new TodoItem(true, "blasdasdasdabla"));
        todoItems.add(new TodoItem(true, "blddddabla"));
        todoItems.add(new TodoItem(true, "blaasdbla"));
        todoItems.add(new TodoItem(true, "blasdasdasdasdasdasdasdasdabla"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_task, container, false);
        RecyclerView mainRecyclerView = (RecyclerView) view.findViewById(R.id.main_RecyclerView);

        mainRecyclerView.setAdapter(new TaskListAdapter(todoItems));

        initItems();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        mainRecyclerView.setLayoutManager(linearLayoutManager);

        return inflater.inflate(R.layout.fragment_task, container, false);
    }
}