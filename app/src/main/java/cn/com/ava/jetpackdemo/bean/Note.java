package cn.com.ava.jetpackdemo.bean;

public class Note {
    String author;
    int time;

    public Note(String author, int time) {
        this.author = author;
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
