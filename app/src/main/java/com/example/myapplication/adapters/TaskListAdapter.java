package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.TodoItem;
import com.example.myapplication.activities.DialogListener;

import java.util.ArrayList;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    ArrayList<TodoItem> todoItems;
    private RecyclerViewClickListener listener;

    public TaskListAdapter(ArrayList<TodoItem> todoItems, RecyclerViewClickListener listener) {
        this.todoItems = todoItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_day_task, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TodoItem item = todoItems.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        final CheckBox checkBox;
        final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.checkBox);
            textView = itemView.findViewById(R.id.dater);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onClick(todoItems.get(position));
                    }
                }
            });
        }

        public void bind(TodoItem item){
            checkBox.setText(item.head);
            checkBox.setChecked(item.isCheck);
            textView.setText(item.dater);
        }


    }

    public interface RecyclerViewClickListener{
        void onClick(TodoItem todoItem);
    }

    public void setRecyclerViewClickListener(RecyclerViewClickListener listener){
        this.listener = listener;
    }

}
