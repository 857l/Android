package models;

public class ClassTask {
    private String title;

    public ClassTask(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public boolean verify() {
        return title.isEmpty();
    }
}
