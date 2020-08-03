package cn.com.ava.jetpackdemo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cn.com.ava.jetpackdemo.bean.Note;

public class NoteViewModel extends ViewModel {

    private MutableLiveData<Note> mNoteLiveData  = new MutableLiveData<>();

    public MutableLiveData<Note> getNoteLiveData() {
        return mNoteLiveData;
    }

    public void setNoteLiveData(MutableLiveData<Note> note) {
        this.mNoteLiveData = note;
    }
}
