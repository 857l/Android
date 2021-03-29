package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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

        final CheckBox checkBox;
        final TextView textView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.checkBox);
            textView = itemView.findViewById(R.id.dater);
        }

        public void bind(TodoItem item){
            checkBox.setText(item.head);
            checkBox.setChecked(item.isCheck);
            textView.setText(item.dater);
        }
    }


}
