package cn.com.ava.jetpackdemo.di;

import android.app.Activity;

import javax.inject.Named;

import cn.com.ava.jetpackdemo.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public class MainActivityModule {

    @Named("MainActivityName")
    @Provides
    String provideName() {
        return MainActivity.class.getName();
    }

    @Named("MainActivitySimpleName")
    @Provides
    String provideSimpleName() {
        return MainActivity.class.getSimpleName();
    }

    @Provides
    int provideId() {
        return 998;
    }

}