package cn.com.ava.jetpackdemo.di;

import android.app.Activity;

import cn.com.ava.jetpackdemo.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public class MainActivityModule {

    @Provides
    String provideName() {
        return MainActivity.class.getName();
    }

    @Provides
    int provideId() {
        return 998;
    }

}