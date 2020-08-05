package cn.com.ava.jetpackdemo.di;


import cn.com.ava.jetpackdemo.bean.Note;
import dagger.Module;
import dagger.Provides;

@Module
public class NoteModule {

    @Provides
    Note provideNote() {
        return new Note("woo", 20);
    }
}
