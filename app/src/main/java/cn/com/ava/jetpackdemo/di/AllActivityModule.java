package cn.com.ava.jetpackdemo.di;

import cn.com.ava.jetpackdemo.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AllActivityModule {


    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivityInjector();

    //@ContributesAndroidInjector(modules = SecondActivityModule.class)
    //abstract SecondActivity contributeSecondActivityInjector();

}