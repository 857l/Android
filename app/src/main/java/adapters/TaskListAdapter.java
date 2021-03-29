package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.TodoItem;

import java.util.ArrayList;

import models.ClassTask;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.MainViewHolder> {

    ArrayList<TodoItem> todoItems;

    public TaskListAdapter(ArrayList<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_day_task, parent, false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        TodoItem item = todoItems.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

        final RadioButton radioButton;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            radioButton = itemView.findViewById(R.id.radioButton);
        }

        public void bind(TodoItem item){
            radioButton.setText(item.head);
            radioButton.setChecked(item.isCheck);
        }
    }


}
