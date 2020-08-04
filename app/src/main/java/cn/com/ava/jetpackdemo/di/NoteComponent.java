package cn.com.ava.jetpackdemo.di;

import cn.com.ava.jetpackdemo.MainActivity;
import dagger.Component;

@Component(modules = {NoteModule.class})
public interface NoteComponent {
    void inject(MainActivity activity);
}
