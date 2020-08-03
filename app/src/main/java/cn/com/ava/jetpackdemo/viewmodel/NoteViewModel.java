package cn.com.ava.jetpackdemo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.nio.channels.MulticastChannel;

import cn.com.ava.jetpackdemo.bean.Note;

public class NoteViewModel extends ViewModel {

    //普通数据
    private MutableLiveData<String> mName = new MutableLiveData<>();

    //LiveData数据
    private MutableLiveData<Note> mNoteLiveData  = new MutableLiveData<>();

    //年龄
    private MediatorLiveData<Integer> mAge = new MediatorLiveData<>();

    public MediatorLiveData<Integer> getAge() {
        return mAge;
    }

    public void setAge(MediatorLiveData<Integer> age) {
        this.mAge = age;
    }

    public MutableLiveData<String> getName() {
        return mName;
    }

    public void setName(MutableLiveData<String> name) {
        this.mName = name;
    }

    public MutableLiveData<Note> getNoteLiveData() {
        return mNoteLiveData;
    }

    public void setNoteLiveData(MutableLiveData<Note> note) {
        this.mNoteLiveData = note;
    }
}
