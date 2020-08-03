package cn.com.ava.jetpackdemo.viewmodel;

import androidx.lifecycle.ViewModel;

import cn.com.ava.jetpackdemo.bean.Note;

public class NoteViewModel extends ViewModel {
    private Note mNote;

    public Note getNote() {
        return mNote;
    }

    public void setNote(Note note) {
        this.mNote = note;
    }
}
