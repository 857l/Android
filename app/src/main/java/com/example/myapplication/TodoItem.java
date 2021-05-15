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

    public boolean isCheck() {
        return isCheck;
    }

    public String getHead() {
        return head;
    }

    public String getDater() {
        return dater;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setDater(String dater) {
        this.dater = dater;
    }
}
