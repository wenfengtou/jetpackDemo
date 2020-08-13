package cn.com.ava.jetpackdemo.di;

import cn.com.ava.jetpackdemo.LoginActivity;
import cn.com.ava.jetpackdemo.SettingActivity;
import dagger.Component;

@Component(modules = {NoteModule.class})
public interface NoteComponent {
    void inject(LoginActivity activity);
    void inject(SettingActivity activity);
}
