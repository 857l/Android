package com.example.myapplication;

import java.io.Serializable;

public class TodoItem implements Serializable {
    public boolean isCheck;
    public String head;
    public String dater;

    public TodoItem(boolean isCheck, String head, String dater ) {
        this.isCheck = isCheck;
        this.head = head;
        this.dater = dater;
    }
}
