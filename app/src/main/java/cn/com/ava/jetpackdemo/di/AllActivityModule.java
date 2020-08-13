package cn.com.ava.jetpackdemo.di;

import androidx.lifecycle.ViewModel;

import cn.com.ava.jetpackdemo.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class AllActivityModule {


    @ContributesAndroidInjector(modules = {MainActivityModule.class, NoteModule.class})
    abstract MainActivity contributeMainActivityInjector();

    //@ContributesAndroidInjector(modules = SecondActivityModule.class)
    //abstract SecondActivity contributeSecondActivityInjector();


}